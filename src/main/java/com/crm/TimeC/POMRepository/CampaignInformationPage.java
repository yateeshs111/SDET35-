package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage 
{
	WebDriver driver;
	public CampaignInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement savedmsg;
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getSavedmsg() 
	{
		return savedmsg;
	}
	
	
	
}
