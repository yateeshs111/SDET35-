package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class ContactPage extends WebDriverUtility
{
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchforContact;
	
	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement dropdown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchBtn;
	
	
	@FindBy(xpath="//span[contains(.,'No Contact Found !')]")
	private WebElement noContactfoundMsg;
	
	public WebElement getSearchforContact() 
	{
		return searchforContact;	
	}
	
	public WebElement getDropdown() 
	{
		return dropdown;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getDeleteContact() {
		return deleteContact;
	}

	@FindBy(xpath="//a[.='del']")
	private WebElement deleteContact;
	
//Create the Getters for all the Elements	
	
	public WebDriver getDriver()
	{
		return driver;
	
	}
	public WebElement getCreateContactImg() 
	{
		return createContactImg;
	}
	
public WebElement getNoContactfoundMsg()
	{
		return noContactfoundMsg;
	}

	//Handle Alert Window to Accept for Delete Contact	
	public void alertAccept(WebDriver driver)
	{
		swithToAlertWindowAndAccpect(driver, "Are You Sure You want to Delete?");	
	}
	
	

}
