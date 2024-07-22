package com.neuron.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;
import com.neuron.qa.utility.DropdownHandler;

public class TechnicalReportPage extends Testbase {
	
	
	@FindBy(xpath="//button[@ng-reflect-tooltip='Add New']")
	WebElement AddTechnicalReportbtn;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='report_subtype_uuid']")
	WebElement ReportSubCategoryDD;	
	
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addReportTypeformbtn;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='research_type']")
	WebElement ResearchTypeDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='segment']")
	WebElement SegmentDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='scrip_data']")
	WebElement ScripDD;
	
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
	WebElement ExpiryDateClick;
	
	@FindBy(xpath="//body[@id='tinymce']")	
	WebElement Descriptiontxt;
	
	@FindBy(xpath="//button//span[contains(text(),'Add')]")	
	WebElement AddTechnicalReportFormbtn;
	
	public void addTechnicalReport(String EntryPricevalue,String StopLossvalue) throws InterruptedException 
	{
		Thread.sleep(3000);
		EntryPricetxt.clear();
		EntryPricetxt.sendKeys(EntryPricevalue);
		Thread.sleep(2000);
		StopLossPricetxt.sendKeys(StopLossvalue);
		Thread.sleep(2000);
		//TargetPricetxt.sendKeys(Targetpricevalue);		
		//Thread.sleep(2000);
				
	}
	 public void DescriptionData(String describe) throws InterruptedException 
		{
			Thread.sleep(3000);		
		
			try {
				Descriptiontxt.sendKeys(describe);
			}
			catch(NoSuchElementException e){
				System.out.println("handled NoSuchElementException");
			}
			Thread.sleep(2000);
			
		}
	 
	 public void addtechnicalReportform() throws InterruptedException {
		 AddTechnicalReportFormbtn.click();	
			Thread.sleep(6000);
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

	public WebElement getScripDD() {
		return ScripDD;
	}
	
	public WebElement getCallTypeDD() {
		return CallTypeDD;
	}
	
	public void TechnicalReportLink() throws InterruptedException {
		this.driver.get("https://cbadev.choiceconnect.in/research-report/research/technical");
		Thread.sleep(6000);
		
	}
	public  TechnicalReportPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
	}
	public void TechnicalReportClick() throws InterruptedException {
		 Thread.sleep(3000);
		 AddTechnicalReportbtn.click();
		 Thread.sleep(3000);
				 
	}	
	
//	public void TechnicalReportlink() throws InterruptedException {		
//		driver.get("https://neuronbeta.choicetechlab.com/research-report/research/technical");
//		 Thread.sleep(4000);
//	}
	
	

}
