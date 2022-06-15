package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class ContactInforamationPage extends WebDriverUtility
{
	WebDriver driver;
	public ContactInforamationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successFulMsg;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteContact;
	
	
	
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getSuccessFulMsg()
	{
		return successFulMsg;
	}
	
	public WebElement getDeleteContact() 
	{
		return deleteContact;
	}
	
	
//For Delete the Contact	
	public void deleteContact(WebDriver driver)
	{
		deleteContact.click();
		swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");	
	}	
	
	public String actualContactName()
	{
		return getSuccessFulMsg().getText();
	}

}


	
	
	

