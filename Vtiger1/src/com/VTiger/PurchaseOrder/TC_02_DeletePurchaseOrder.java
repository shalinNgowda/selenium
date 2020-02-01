package com.VTiger.PurchaseOrder;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.VTiger.GenericLib.FileUtility;
import com.VTiger.GenericLib.GenericLib;

public class TC_02_DeletePurchaseOrder 
{
	public static FileUtility select = new FileUtility();
	public static WebDriver driver;
	public static GenericLib lib = new GenericLib();

	@Test
	public  void deleteOrderTest() {
		if (lib.getKeyValue("browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (lib.getKeyValue("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		driver.get(lib.getKeyValue("url"));

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys(lib.getKeyValue("username"));

		driver.findElement(By.name("user_password")).sendKeys(lib.getKeyValue("password"), Keys.ENTER);

		Actions act = new Actions(driver);

		/* Move curssor on More Link */
		act.moveToElement(driver.findElement(By.linkText("More"))).perform();
		
		driver.findElement(By.linkText("Purchase Order")).click();
		String pTitle = driver.getTitle();

		// to verify the purchase order page//

		if (pTitle.contains("Administrator - Purchase Order")) {
			System.out.println("Purchase order page displayed==>pass");
		} else {
			System.out.println("Purchase order page not displayed==>fail");

		}

		driver.findElement(By.xpath("//img[contains(@alt,'Create Purchase')]")).click();

		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Purchase", 2, 0).toString());

		// to select vendor
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		// to get session id of al the windows
		Set<String> ids = driver.getWindowHandles();

		Iterator<String> i = ids.iterator();

		String pid = i.next();

		String cid = i.next();

		// To switch to new window ->vendors//
		driver.switchTo().window(cid);

		driver.findElement(By.xpath("//a[text()='Vendors1']")).click();

		driver.switchTo().window(pid);

		driver.findElement(By.id("tracking_no")).sendKeys(lib.getExcelData("Vendor", 2, 1).toString());

		driver.findElement(By.id("salescommission")).sendKeys(lib.getExcelData("Purchase", 2, 2).toString());

		WebElement status = driver.findElement(By.name("postatus"));
		select.selectByValue(status, lib.getExcelData("Purchase", 2, 3).toString());

		driver.findElement(By.id("requisition_no")).sendKeys(lib.getExcelData("Purchase", 2, 4).toString());

		WebElement car = driver.findElement(By.xpath("//select[@name='carrier']"));
		select.selectByValue(car, lib.getExcelData("Purchase", 2, 5).toString());

		driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
		Set<String> winds = driver.getWindowHandles();

		Iterator<String> itr = winds.iterator();

		String p = itr.next();

		String c = itr.next();

		driver.switchTo().window(c);

		String proTitle = driver.getTitle();

		System.out.println(proTitle);
		driver.findElement(By.name("selected_id")).click();

		driver.findElement(By.linkText("Mi mobile")).click();

		driver.switchTo().window(p);

		

		driver.findElement(By.id("qty1")).sendKeys(lib.getExcelData("Purchase", 2, 8).toString());

		//driver.findElement(By.id("listPrice1")).sendKeys(lib.getExcelData("Purchase", 2, 9).toString());

		

		driver.findElement(By.name("bill_street")).sendKeys(lib.getExcelData("Purchase", 2, 6).toString());

		driver.findElement(By.name("ship_street")).sendKeys(lib.getExcelData("Purchase", 2, 7).toString());

		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		
		driver.switchTo().alert().accept();
		
		WebElement text=driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		System.out.println(text.getText());

	}
	
	



}
