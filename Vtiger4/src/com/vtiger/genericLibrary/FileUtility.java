package com.vtiger.genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FileUtility
{
	public void selectByValue(WebElement webElement,String value)
	{
		Select sel=new Select(webElement);
		sel.selectByValue(value);
	}
	
	public void selectByIndex(WebElement webElement,int index)
	{
		Select sel=new Select(webElement);
		sel.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement webElement,String text)
	{
		Select sel=new Select(webElement);
		sel.selectByVisibleText(text);
	}
	
	public void moveToElement(WebDriver driver,WebElement webElement)
	{
		Actions act=new Actions(driver);
		act.moveToElement(webElement).perform();
		
	}

}
