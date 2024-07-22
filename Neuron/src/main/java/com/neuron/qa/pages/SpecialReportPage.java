package com.neuron.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neuron.qa.base.Testbase;

public class SpecialReportPage extends Testbase {
	
	@FindBy(xpath="//button[@ng-reflect-tooltip='Add New']")
	WebElement AddSpecialReportbtn;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='report_subtype_uuid']")
	WebElement ReportSubCategoryDD;	
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='research_type']")
	WebElement ResearchTypeDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='segment']")
	WebElement SegmentDD;
		
	@FindBy(xpath="//ng-select[@ng-reflect-name='scrip_data']")
	WebElement ScripNameDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='call_type_uuid']")
	WebElement CallTypeDD;
	
	@FindBy(xpath="//input[@ng-reflect-name='entry_price']")
	WebElement EntryPricetxt;
	
	@FindBy(xpath="//input[@ng-reflect-name='stop_loss_price']")
	WebElement StopLossPricetxt;
	
	@FindBy(xpath="//input[@ng-reflect-name='target_price']")
	WebElement TargetPricetxt;
	
	@FindBy(xpath="//input[@ng-reflect-name='expiry_date']")
	WebElement ExpiryDateCalender;	

	@FindBy(xpath="//tr[5]//td[3]//span")
	WebElement ExpiryDate;
	
	@FindBy(xpath="//button//span[contains(text(),'Add')]")
	WebElement AddSpecialReportFormbutton;
	
	public WebElement getCallTypeDD() {
		return CallTypeDD;
	}	
	
	public WebElement getScripNameDD() {
		return ScripNameDD;
	}
	
	public WebElement getReportSubCategoryDD() {
		return ReportSubCategoryDD;
	}
	
	public WebElement getResearchTypeDD() {
		return ResearchTypeDD;
	}
	
	public WebElement getSegmentDD() {
		return SegmentDD;
	}
	
	public void addSpecialReport(String EntryPricevalue,String StopLossvalue) throws InterruptedException 
	{
		Thread.sleep(3000);
		EntryPricetxt.clear();
		EntryPricetxt.sendKeys(EntryPricevalue);
		Thread.sleep(2000);
		StopLossPricetxt.sendKeys(StopLossvalue);
		Thread.sleep(2000);
//		TargetPricetxt.sendKeys(Targetpricevalue);		
//		Thread.sleep(2000);
				
	}
	public void SpecialReportLink() throws InterruptedException {
		this.driver.get("https://cbadev.choiceconnect.in/research-report/research/special");
		Thread.sleep(6000);
		
	}
	public  SpecialReportPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
	}
	public void SpecialReportClick() throws InterruptedException {
		 Thread.sleep(3000);
		 AddSpecialReportbtn.click();
		 Thread.sleep(3000);
				 
	}	
	 public void addSpecialReportform() throws InterruptedException {
		 AddSpecialReportFormbutton.click();	
			Thread.sleep(6000);
	 }
	
	
	
	
	
	
	
	
	
	
	

}
