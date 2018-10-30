package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() throws IOException{
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void VerifyHomepageTitileTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page Title is incorrect");
	}
	@Test(priority=2)
	public void VerifyUserName(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void VerifyContacts() throws IOException{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	@AfterMethod
	public void teardo(){
		driver.quit();
	}
}
