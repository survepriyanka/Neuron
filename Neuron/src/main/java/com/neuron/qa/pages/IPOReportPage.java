package com.neuron.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neuron.qa.base.Testbase;

public class IPOReportPage extends Testbase {
	
	@FindBy(xpath="//button[@ng-reflect-tooltip='Add New']")
	WebElement AddIPOReportbtn;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='report_subtype_uuid']")
	WebElement ReportSubCategoryDD;	
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='scrip_data']")
	WebElement ScripNameDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='call_type_uuid']")
	WebElement CallTypeDD;
	
	@FindBy(xpath="//input[@ng-reflect-name='potential_price']")
	WebElement PotentialPricetxt;
	

	@FindBy(xpath="	//input[@ng-reflect-name='price_band']")
	WebElement PriceBandtxt;
	

	@FindBy(xpath="//input[@ng-reflect-name='mcap_at_higher_price_band']")
	WebElement MCAPpriceBandtxt;
	

	@FindBy(xpath="//input[@ng-reflect-name='enterprise_value_at_higher_pri']")
	WebElement EnterpriseValuetxt;
	
	@FindBy(xpath="//body[@id='tinymce']")
	WebElement Descriptiontxt;
	
	@FindBy(xpath="//button//span[contains(text(),'Add')]")
	WebElement AddIPOReportFormbutton;	
	
	
	public void addIPOReport(String PotentialPriceValue,String PriceBandValue,String MCAPpriceBandValue,String 
			EnterpriseValue) throws InterruptedException 
	{
		Thread.sleep(3000);
		
		PotentialPricetxt.sendKeys(PotentialPriceValue);
		Thread.sleep(2000);		
		PriceBandtxt.sendKeys(PriceBandValue);
		Thread.sleep(2000);		
		MCAPpriceBandtxt.sendKeys(MCAPpriceBandValue);
		Thread.sleep(2000);		
		EnterpriseValuetxt.sendKeys(EnterpriseValue);
		Thread.sleep(2000);
		//Descriptiontxt.sendKeys("Pend");
		
		
		
	}
	 public void DescriptionData() throws InterruptedException 
		{
//			Thread.sleep(3000);		
//		
//			try {
//				Descriptiontxt.sendKeys(describe);
//			}
//			catch(NoSuchElementException e){
//				System.out.println("handled NoSuchElementException");
//			}
//			Thread.sleep(2000);
			Descriptiontxt.sendKeys("Pend");
			
			
		}
	
	public WebElement getCallTypeDD() {
		return CallTypeDD;
	}	
	
	public WebElement getScripNameDD() {
		return ScripNameDD;
	}
	
	
	
	public WebElement getReportSubCategoryDD() {
		return ReportSubCategoryDD;
	}	
	public void IPOReportClick() throws InterruptedException {
		 Thread.sleep(3000);
		 AddIPOReportbtn.click();
		 Thread.sleep(3000);
	}

	public void IPOReportLink() throws InterruptedException {
		this.driver.get("https://cbadev.choiceconnect.in/research-report/research/ipo");
		Thread.sleep(6000);
		
	}
	public IPOReportPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void addIPOReportform() throws InterruptedException {
		AddIPOReportFormbutton.click();	
			Thread.sleep(6000);
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
