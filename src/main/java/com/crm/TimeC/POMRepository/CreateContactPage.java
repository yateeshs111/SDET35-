package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage
{
	WebDriver driver;
	public CreateContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}

	public void createContact(String lastname)
	{
		lastNameEdt.sendKeys(lastname);
		saveButton.click();
	}
	
	
	
	

	
	
	
}
