package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name" )
	WebElement firstname;
	
	@FindBy(id = "surname" )
	WebElement lastname;
	
	
	@FindBy(name = "client_lookup" )
	WebElement company;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement savebtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	/*public void selectContactsBy(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}*/
	@FindBy(name = "contact_id")
	WebElement getcontacttextbox;
	
	
	public WebElement checkboxTick() {
		return getcontacttextbox;
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp) {
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		company.sendKeys(comp);
		savebtn.click();
	}
}
