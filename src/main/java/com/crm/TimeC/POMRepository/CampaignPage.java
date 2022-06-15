package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCompaignImg;
	
	
	public WebDriver getDriver() 
	{
		return driver;
	}


	public WebElement getCreateCompaignImg() 
	{
		return createCompaignImg;
	}
	
	
	
	
	

}
