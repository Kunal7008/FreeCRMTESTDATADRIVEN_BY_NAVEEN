package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
    ContactsPage  contactpage;
    String sheetName = "contacts";

	
	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		 loginPage = new LoginPage();
		 contactpage = new ContactsPage();
		 homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testutil.switchToFrame();
		 //contactpage = homepage.clickOnContactsLink();
		
	}
	
	@Test(priority = 1)
	public void verifyContactLabelTest() {
		Assert.assertTrue(contactpage.verifyContactLabel(),"contacts label is missing on the page");
	}
	/*@Test(priority =2)
	public void verifySelectContactTest() {
		contactpage.selectContactsBy("abhi");
	}
	public void tickCheckBoxValue() {
	contactpage.checkboxTick().click();	
	}*/
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data [][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company) {
		homepage.clickOnNewContactlink();
		contactpage.createNewContact(title, firstName, lastName, company);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
