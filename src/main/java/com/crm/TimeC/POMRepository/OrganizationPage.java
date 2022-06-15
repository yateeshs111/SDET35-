package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationImg;
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getCreateOrganizationImg() 
	{
		return createOrganizationImg;
	}
	
	
	
}

