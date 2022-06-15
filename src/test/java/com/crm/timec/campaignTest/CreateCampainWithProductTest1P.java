package com.crm.timec.campaignTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.TimeC.POMRepository.CampaignInformationPage;
import com.crm.TimeC.POMRepository.CampaignPage;
import com.crm.TimeC.POMRepository.CreateCampaignPage;
import com.crm.TimeC.POMRepository.CreateProductsPage;
import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.LoginPage;
import com.crm.TimeC.POMRepository.ProductsInformationPage;
import com.crm.TimeC.POMRepository.ProductsPage;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampainWithProductTest1P 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver;
		WebDriverUtility Wlib= new WebDriverUtility();
		FileUtility Plib = new FileUtility();
		JavaUtility Jlib = new JavaUtility();
		ExcelUtility Elib = new ExcelUtility();
	
		String browser = Plib.getPropertyKeyValue("browser");
		String url = Plib.getPropertyKeyValue("url");
		String username = Plib.getPropertyKeyValue("username");
		String password = Plib.getPropertyKeyValue("password");
			
//Open the browser
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		Wlib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
	
//Login to the application	
		LoginPage lp=new LoginPage(driver);
		driver.get(url);
		lp.loginToApp(username, password);
//Navigate to the application		
		HomePage hp = new HomePage(driver);
//Navigate to the products
		hp.getProductsLink().click();
//navigate to the create product
		ProductsPage pg= new ProductsPage(driver);
		pg.getCreateProductImg().click();
//Navigate to enter the product name
		CreateProductsPage cpp = new CreateProductsPage(driver);
		
		int ran = Jlib.getRandomNum();
		System.out.println("Generated Random number is "+ran);
		String productName = Elib.getExceldata("Sheet1", 1, 6)+ran;
		System.out.println("Generated Product name is "+productName);
		cpp.getProductName().sendKeys(productName);
		cpp.getSaveButton().click();
		System.out.println("Product Name saved successfully");
		
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		String productsaved = pip.getSuccessFulMsg().getText();
		
		if(productsaved.contains(productName))
		{
			System.out.println("Created Product is verified");
			}
		else
			{
			System.out.println("created Product is not verified");
			}
//Navigate to the Campaign page
		hp.getMoreLink().click();
		hp.getCampaingsLink().click();
//Navigate to Create Campaign page
		CampaignPage cp = new CampaignPage(driver);
		cp.getCreateCompaignImg().click();
//Enter the Details in to Create campaign Page	
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		
		int ran1 = Jlib.getRandomNum();
		System.out.println(ran1);
		String campName = Elib.getExceldata("Sheet1", 1, 4)+ran1;
		System.out.println("Generated campaign name is "+campName);
		ccp.getCamapaingName().sendKeys(campName);
		
		ccp.getProductAddImg().click();
		Wlib.swithToWindow(driver,"Products&action");
		System.out.println("Switched to child window successfully");
//Child window Actions		
		ccp.getProdudctEnterInPopup().sendKeys(productName);
		ccp.getSearchInPopup().click();
		ccp.getProductSelectInPopup().click();
		
		Wlib.swithToWindow(driver,"Campaigns&action");
		System.out.println("Switched to parent window successfully");
		
		ccp.getSaveButton().click();
		System.out.println("Capmaign with Product saved successfully");
		
//Navigate to Campaign information page
		CampaignInformationPage cip= new CampaignInformationPage(driver);
		String savedCamapign = cip.getSavedmsg().getText();
		
		if(savedCamapign.contains(campName))
			
		{
			System.out.println("Created Camapaign with product is verified");
		}
		else
			{
			System.out.println("Created Camapaign with product is not verified");
			}
		
//Navigate to log out
		hp.signOut();

	}

}
