package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

//Create Class for Every Page and Extend the General Utilities if required
public class HomePage extends WebDriverUtility
{
	WebDriver driver;
//Create Constructor of the class	
	public HomePage(WebDriver driver)
	{
//Initialize the all the elements in constuctorth
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//Identify all the elements and make them as private
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationLink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement ProductsLink;
	
	@FindBy(linkText ="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campaingsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	
//Generate the Getters 
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	public WebElement getCampaingsLink() 
	{
		return campaingsLink;
	}

	public WebElement getAdministratorImg() 
	{
		return administratorImg;
	}
	
	public WebElement getOrganizationLink() 
	{
		return organizationLink;
	}

	public WebElement getContactLink() 
	{
		return contactLink;
	}

	public WebElement getProductsLink() 
	{
		return ProductsLink;
	}

	public WebElement getMoreLink() 
	{
		return moreLink;
		
	}

	public WebElement navigateToAdministratorImg() 
	{
		return administratorImg;
	}

	public WebElement getSignOutLink() 
	{
		return signOutLink;
	}
		
	
//Create the general Sign out method	
	public void signOut()
	{
		mouseOverOnElement(driver, administratorImg);
		signOutLink.click();
		System.out.println("Sigout successfully");
		driver.quit();	
	}
}

