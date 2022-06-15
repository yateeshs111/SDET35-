package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage
{

	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getOrganizationName() 
	{
		return organizationName;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	
	
}
