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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VTiger.GenericLib.FileUtility;
import com.VTiger.GenericLib.GenericLib;

public class TC_05_Edit
{
	public static FileUtility select = new FileUtility();
	public static WebDriver driver;
	public static GenericLib lib = new GenericLib();

	public static void main(String[] args) {
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

		driver.findElement(By.name("Vendors")).click();

		String vTitle = driver.getTitle();

		System.out.println(vTitle);

		if (vTitle.contains("Administrator - Vendors - vtiger CRM 5")) {
			System.out.println("Vedors page displayed==>pass");

		} else {
			System.out.println("Vendors page not displaye==>Fial");
		}

		driver.findElement(By.xpath("//img[contains(@alt,'Create Vendor')]")).click();

		driver.findElement(By.xpath("//input[@name='vendorname']"))
				.sendKeys(lib.getExcelData("Vendor", 2, 0).toString());

		driver.findElement(By.id("email")).sendKeys(lib.getExcelData("Vendor", 3, 1));

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement acct = driver.findElement(By.xpath("//select[@name='glacct']"));
		select.selectByValue(acct, lib.getExcelData("Vendor", 1, 3).toString());

		driver.findElement(By.id("category")).sendKeys(lib.getExcelData("Vendor", 3, 5));

		driver.findElement(By.id("phone")).sendKeys(lib.getExcelData("Vendor", 3, 4));

		driver.findElement(By.name("website")).sendKeys(lib.getExcelData("Vendor", 3, 2));

		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();

		WebElement text = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));

		System.out.println(text.getText());

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

		driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Purchase", 3, 0));

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

		driver.findElement(By.id("tracking_no")).sendKeys(lib.getExcelData("Purchase", 1, 1));

		driver.findElement(By.id("salescommission")).sendKeys(lib.getExcelData("Purchase", 1, 2));

		WebElement status = driver.findElement(By.name("postatus"));
		select.selectByValue(status, lib.getExcelData("Purchase", 1, 3).toString());

		driver.findElement(By.id("requisition_no")).sendKeys(lib.getExcelData("Purchase", 1, 4));

		WebElement car = driver.findElement(By.xpath("//select[@name='carrier']"));
		select.selectByValue(car, lib.getExcelData("Purchase", 1, 5));

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

		

		driver.findElement(By.id("qty1")).sendKeys(lib.getExcelData("Purchase", 1, 8));

		//driver.findElement(By.id("listPrice1")).sendKeys(lib.getExcelData("Purchase", 1, 9));

		

		driver.findElement(By.name("bill_street")).sendKeys(lib.getExcelData("Purchase", 1, 6));

		driver.findElement(By.name("ship_street")).sendKeys(lib.getExcelData("Purchase", 1, 7));

		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		act.moveToElement(driver.findElement(By.linkText("More"))).perform();

		driver.findElement(By.linkText("Purchase Order")).click();
		
		driver.findElement(By.xpath("//span[@vtfieldname='subject']/preceding-sibling::a[text()='Keybord order']")).click();
		
		WebElement orderInfo=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		
		System.out.println(orderInfo.getText());
		
		driver.findElement(By.xpath("//input[@name='Edit']")).click();
		
		WebElement edit=driver.findElement(By.name("subject"));
		
		edit.clear();
		edit.sendKeys(lib.getExcelData("Purchase", 4, 0));
		
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		act.moveToElement(driver.findElement(By.linkText("More"))).perform();

		driver.findElement(By.linkText("Purchase Order")).click();
		
		driver.findElement(By.xpath("//span[@vtfieldname='subject']/preceding-sibling::a[text()='Scanner']")).click();
		
	
		
		
		
		
		
		

	}

}
