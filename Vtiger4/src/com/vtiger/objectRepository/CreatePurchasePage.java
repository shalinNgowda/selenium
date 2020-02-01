package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePurchasePage
{
	@FindBy(name="subject")
	private WebElement subjectName;
	
	@FindBy(xpath="//input[@name='vendor_id']/following-sibling::img[@title='Select']")
	private WebElement vendorSelect;
	
	@FindBy(id="tracking_no")
	private WebElement trackingNoTB;
	
	@FindBy(id="requisition_no")
	private WebElement requisitionNoTB;
	
	@FindBy(xpath="//input[@name='contact_id']/following-sibling::img[@title='Select']")
	private WebElement contactSelect;
	
	@FindBy(name="carrier")
	private WebElement carrierSelect;
	
	@FindBy(id="exciseduty")
	private WebElement exciseDutyTB;
	
	@FindBy(id="salescommission")
	private WebElement salesCommissionTB;
	
	@FindBy(name="postatus")
	private WebElement status;
	
	@FindBy(name="bill_street")
	private WebElement billStreetTB;
	
	@FindBy(name="ship_street")
	private WebElement shipStreetTB;
	
	@FindBy(xpath="//img[@id='searchIcon1' and @title='Products']")
	private WebElement productSelect;
	
	@FindBy(id="inventory_currency")
	private WebElement currencySel;
	
	@FindBy(id="qty1")
	private WebElement quantityTB;
	
	@FindBy(id="listPrice1")
	private WebElement priceTB;
	
	@FindBy(id="taxtype")
	private WebElement taxType;
	
	@FindBy(xpath="//input[contains(@id,'shipping_handling')]")
	private WebElement shippingCharge;
	
	@FindBy(id="adjustment")
	private WebElement adjustmentTB;
	
	
	@FindBy(id="adjustmentType")
	private WebElement adjustType;
	
	@FindBy(id="grandTotal")
	private WebElement totalAmount;
	
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement saveBtn;
	

}
