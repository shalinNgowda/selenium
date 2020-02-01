package com.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary 
{
	/*
	 * This method is used to access the value from .properties file
	 * return type String
	 */
	public String getPropertyKeyValue(String key)
	{
		FileInputStream ip=null;
		
		try 
		{
			ip=new FileInputStream("./TestData/testData.properties");
			
		}
		catch (FileNotFoundException e) 
		{
		
			e.printStackTrace();
		}
		
		 
		Properties prop=new Properties();
		try 
		{
			prop.load(ip);
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
		
		return prop.getProperty(key);
	}
	
	/*
	 * This method is used to access the data from .xlsx file
	 * return type String
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum)
	{
		FileInputStream ip=null;
		Workbook wb=null;
		try {
			ip=new FileInputStream("./TestData/Purchase.xlsx");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(ip);
		} catch (EncryptedDocumentException | IOException e) {
			
			e.printStackTrace();
		}
		
		Cell c=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		String cType=c.getCellType().toString();
		
		if(cType.equals("NUMERIC"))
		{
			int numericData=(int)c.getNumericCellValue();
			return String.valueOf(numericData);
		}
		else
		{
			String strData=c.getStringCellValue();
			return strData;
		}
		
	}

}
