package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage 
{
	WebDriver driver;
	public CreateProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getProductName() 
	{
		return productName;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	
	
	
	
	
	
}
