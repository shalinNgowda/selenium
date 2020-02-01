package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VendorsPage
{
	@FindBy(xpath="//img[contains(@alt,'Create Vendor')]")
	private WebElement createVendorImg;

	public WebElement getCreateVendorImg() {
		return createVendorImg;
	}
	
	
}
