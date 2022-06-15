package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInformationPage 
{
	WebDriver driver;
	public ProductsInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement successFulMsg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productAddImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement produdctEnterInPopup;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchInPopup;
	
	@FindBy(xpath="//tr[@class='lvtColData']")
	private WebElement productSelectInPopup;
		
	public WebDriver getDriver() 
	{
		return driver;
	}

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

	public WebElement getSuccessFulMsg() 
	{
		return successFulMsg;
	}
	
	

	
	
	
}
