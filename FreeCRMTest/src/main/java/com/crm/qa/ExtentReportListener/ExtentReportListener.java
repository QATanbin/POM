package com.crm.qa.ExtentReportListener;

import java.io.File;//allow yo read or create a extend virtual file
import java.util.Calendar;//allow to work with calendar jar
import java.util.Date;//allow to work with date
import java.util.List;//build in function which act as an array
import java.util.Map;//build in function which allow to map method structure

import org.testng.IReporter;//IReporter is testng interface
import org.testng.IResultMap;//mapping the result properly according to the test cases.
import org.testng.ISuite;//reading the suites which is regression and sanity
import org.testng.ISuiteResult;//IsuiteResult basically each test page result
import org.testng.ITestContext;//ITestContext each of the TC Result
import org.testng.ITestResult;//Capture the overall result of your execution
import org.testng.xml.XmlSuite;//reading the values from POM XML of maven dependency


import com.relevantcodes.extentreports.ExtentReports;//extend reporter jars
import com.relevantcodes.extentreports.ExtentTest;//extend test(test cases reader) jars
import com.relevantcodes.extentreports.LogStatus;//jar for pass/fail/skip result

public class ExtentReportListener implements IReporter{

	private ExtentReports extent;

	@Override
	public void generateReport(List<XmlSuite> smlsuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		extent = new ExtentReports(outputDirectory + File.separator + "Extent.html",true);
		for(ISuite suite:suites){
			Map<String,ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				
				buildTestNodes(context.getPassedTests(),LogStatus.PASS);
				buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
			}
		}
		extent.flush();//when execute then give the new report
		extent.close();//close the report
		
	}

	private void buildTestNodes(IResultMap tests,LogStatus status){
		ExtentTest test;
		if(tests.size()>0){
			for(ITestResult result : tests.getAllResults()){
				test = extent.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				for(String group:result.getMethod().getGroups()){
					test.assignCategory(group);
					if (result.getThrowable()!= null){
						test.log(status, result.getThrowable());//rearranging your report fresh
					}else{
						test.log(status, "Test"+status.toString().toLowerCase()+"ed");
					}
					extent.endTest(test);
				}
			}
		}
	}
	private Date getTime(long millis){
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}
}
