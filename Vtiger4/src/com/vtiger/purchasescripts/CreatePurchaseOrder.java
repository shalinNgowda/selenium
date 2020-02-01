package com.vtiger.purchasescripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.vtiger.genericLibrary.Base;
import com.vtiger.objectRepository.CreateVendorPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.PurchasePage;
import com.vtiger.objectRepository.VendorsPage;

public class CreatePurchaseOrder extends Base
{
	public HomePage hp =PageFactory.initElements(driver, HomePage.class);
	public VendorsPage vp;
	public CreateVendorPage creat;
	public PurchasePage Ppage;
	
	@Test
	public void createVendor() 
	{
		
		 vp=PageFactory.initElements(driver, VendorsPage.class);
		 creat=PageFactory.initElements(driver, CreateVendorPage.class);
		 
		 util.moveToElement(driver, hp.getMoreLink());
		 hp.getVendorsLink().click();
		
		
		 WebElement image=vp.getCreateVendorImg();
		 wait.until(ExpectedConditions.elementToBeClickable(image));
		 image.click();
		 
		 String vName=flib.getExcelData("Vendor", 1, 0);
	     String email=flib.getExcelData("Vendor", 1, 1);
		 String phone=flib.getExcelData("Vendor", 1, 4);
		 String website=flib.getExcelData("Vendor", 1, 2);		 
		 creat.createVendor(vName, email, phone, website);
		 util.selectByValue( creat.getGlAccount(), flib.getExcelData("Vendor", 1, 3));
	}
	
	@Test
	public void createPurchase()
	{
		 hp =PageFactory.initElements(driver, HomePage.class);
		
		util.moveToElement(driver, hp.getMoreLink());
		hp.getPurchaseOrder().click();
		
		Ppage=PageFactory.initElements(driver, PurchasePage.class);
		Ppage.getCreratePurchaseImg().click();
		
	}
}


