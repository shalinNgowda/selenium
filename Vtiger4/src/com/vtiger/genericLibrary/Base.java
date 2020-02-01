package com.vtiger.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class Base
{
	public  WebDriver driver;
	public static  WebDriver scrDriver;
	public WebDriverWait wait;
	public FileLibrary flib = new FileLibrary();
	public FileUtility util=new FileUtility();
	@BeforeClass
	public void configBC()
	{
		if(flib.getPropertyKeyValue("browser").equals("chrome"))
		{
			driver=new ChromeDriver();
			scrDriver=driver;
		}
		else if(flib.getPropertyKeyValue("browser").equals("firefox"))
		{
			driver=new FirefoxDriver();
			scrDriver=driver;
		}
		else
		{
			driver=new ChromeDriver();
			scrDriver=driver;
			System.out.println("Defult browser");
			
		}
		
		driver.manage().window().maximize();
		
		driver.get(flib.getPropertyKeyValue("url"));
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		wait=new WebDriverWait(driver, 20);
	}
	
	@BeforeMethod
	public void configBM()
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		lp.logIn(flib.getPropertyKeyValue("username"), flib.getPropertyKeyValue("password"));
	}
	
	@AfterMethod
	public void configAM()
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		
		util.moveToElement(driver, hp.getAdmin());
		hp.getSignOut().click();
		
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}

}
