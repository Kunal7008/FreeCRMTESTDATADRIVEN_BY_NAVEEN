package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath ="//a[text()='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath = "//a[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[text()='Tasks']")
	WebElement taskLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
    public boolean verifyCorrectUserName() {
    	return userNameLabel.isDisplayed();
    }
    
	public ContactsPage clickOnContactsLink() {
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink() {
		dealsLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactlink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactslink).build().perform();
		newContactsLink.click();
	}
}
