package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends HomePage {
      LoginPage loginPage;
      HomePage homepage;
      TestUtil testutil;
      ContactsPage  contactpage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","HomePage title is not matched");
	}
	@Test(priority = 2)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
		
	}
	
	@Test(priority= 3)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactpage = homepage.clickOnContactsLink();
	}
		
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
