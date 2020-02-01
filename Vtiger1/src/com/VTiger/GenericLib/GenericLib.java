package com.VTiger.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib 
{
	public void setExcelData(String sheetName,int rowNum,int cellNum,String value)
	{
		try
		{
			FileInputStream file=new FileInputStream("./testdata/testdata.xlsx");
			 
			 Workbook wb=WorkbookFactory.create(file);
			 wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
			 
			 FileOutputStream op=new FileOutputStream("./Excel/Purchase.xlsx");
			 
			 wb.write(op);
			 
			 wb.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
	
	
	}
	
		public String getExcelData(String sheetName,int rowNum,int cellNum)
		{
			FileInputStream file=null;
			Workbook wb=null;
			try{
				file=new FileInputStream("./Excel/Purchase.xlsx");
				wb=WorkbookFactory.create(file);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		}
		
		public String getKeyValue(String key)
		{
			
			
			Properties prop=null;
			try
			{
				FileInputStream file=new FileInputStream("./Excel/commonData.properties");
				prop=new Properties();
			    prop.load(file);
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return prop.getProperty(key);
		}


}
