package com.crm.TimeC.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



//Rule 1:Create a separate class for every page in application
public class LoginPage 
{
//Rule 2: Execute all the elements and initialize the elements PageFactory.initElelemts(Initialization)
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//Rule 3: Identify all the elements by using @FindBy,@FindBys and @FindAll(Declaration)	
	@FindBy(name="user_name")
//Rule4: Declare all the  elements as private	
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
//Rule 5: Provide the access through Getters method	 and business method(Utilization)
	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getUsernameEdt() 
	{
		return userNameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return passWordEdt;
	}

	public WebElement getSubmitbutton() 
	{
		return submitButton;
	}
	
//Login to the application(Business method)	
	public void  loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		submitButton.click();
		System.out.println("LoggedIn to the Application Successfully");
	}
	
	
}
