package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;



public class WebEventListener extends TestBase implements WebDriverEventListener{

	public WebEventListener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		System.out.println("Element Value Changed to:"+element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Clicked On:"+ element.toString());
	}

	public void afterFindBy(By by, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("Found Element by: "+by.toString());
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Navigation back to previous page");

	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Navigation forward to next page");

	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Navigated to:'"+ url +"'");
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		System.out.println("Trying to value changed:"+element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Trying to click on"+element.toString());
	}

	public void beforeFindBy(By by, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("Trying to find element by:" +by.toString());
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Navigation back to previous page");
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Navigation forward to next page");
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Before navigating to: '"+ url +"'");
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Exception Occured: "+error);
		
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
