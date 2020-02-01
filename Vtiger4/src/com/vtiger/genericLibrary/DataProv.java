package com.vtiger.genericLibrary;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProv 
{
	@DataProvider	
	public Object[][] getAllData()
	{
		Object[][] data=new Object[3][3];
		data[0][0]="Mouse";
		data[0][1]="lenova";
		data[0][2]=123;
		
		data[1][0]="Keybord";
		data[1][1]="dell";
		data[1][2]=123;
		
		data[2][0]="Monitor";
		data[2][1]="dell";
		data[2][2]=123;
		return data;
		
		
	}
	
	@Test(dataProvider="getAllData")
	public void data(String prod,String manu,int price)
	{
		System.out.println("Product"+prod+"Manufacture"+manu+"Price"+price);
	}

}
