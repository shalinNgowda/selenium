package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage 
{
	@FindBy(xpath="//img[contains(@alt,'Create Purchase')]")
	private WebElement creratePurchaseImg;

	public WebElement getCreratePurchaseImg() {
		return creratePurchaseImg;
	}
	

}
