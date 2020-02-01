package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateVendorPage 
{
	@FindBy(name="vendorname")
	private WebElement vendorsNameTB;
	
	@FindBy(id="email")
	private WebElement emailTB;
	
	@FindBy(id="phone")
	private WebElement phoneTB;
	
	@FindBy(name="glacct")
	private WebElement glAccount;
	
	@FindBy(name="website")
	private WebElement websiteTB;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getVendorsNameTB() {
		return vendorsNameTB;
	}

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPhoneTB() {
		return phoneTB;
	}

	public WebElement getGlAccount() {
		return glAccount;
	}

	public WebElement getWebsiteTB() {
		return websiteTB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createVendor(String vendorName,String email,String phoneNum,String website)
	{
		vendorsNameTB.sendKeys(vendorName);
		emailTB.sendKeys(email);
		phoneTB.sendKeys(phoneNum);
		websiteTB.sendKeys(website);
		saveBtn.click();
		
		
		
	}

}
