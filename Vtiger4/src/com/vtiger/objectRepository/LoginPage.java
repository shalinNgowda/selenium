package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(name="user_name")
	private WebElement usernameEB;
	
	@FindBy(name="user_password")
	private WebElement passwordEb;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUsernameEB() {
		return usernameEB;
	}

	public WebElement getPasswordEb() {
		return passwordEb;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void logIn(String username,String password)
	{
		usernameEB.sendKeys(username);
		passwordEb.sendKeys(password);
		submitButton.click();
	}
	

}
