package com.VTiger.GenericLib;

import org.openqa.selenium.WebElement;
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
		sel.deselectByVisibleText(text);
	}


}
