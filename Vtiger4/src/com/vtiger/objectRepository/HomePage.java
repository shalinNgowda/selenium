package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement admin;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;

	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[contains(text(),'Purchase Order')]")
	private WebElement purchaseOrderLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsLink;

	public WebElement getPurchaseOrder() {
		return purchaseOrderLink;
	}


	public WebElement getVendorsLink() {
		return vendorsLink;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getAdmin() {
		return admin;
	}


	public WebElement getSignOut() {
		return signOut;
	}
	
	

}
