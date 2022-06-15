package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement camapaingName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productAddImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement produdctEnterInPopup;
	
	public WebElement getProductAddImg() 
	{
		return productAddImg;
	}

	public WebElement getProdudctEnterInPopup() 
	{
		return produdctEnterInPopup;
	}

	public WebElement getSearchInPopup() 
	{
		return searchInPopup;
	}

	public WebElement getProductSelectInPopup() 
	{
		return productSelectInPopup;
	}

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchInPopup;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement productSelectInPopup;
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getCamapaingName() 
	{
		return camapaingName;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	
	
	
	
	
	
}
