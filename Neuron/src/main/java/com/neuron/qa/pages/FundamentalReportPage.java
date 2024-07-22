package com.neuron.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;

public class FundamentalReportPage extends Testbase
{
	@FindBy(xpath="//button[@ng-reflect-tooltip='Add New']")
	WebElement AddFundamentalReportbtn;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='report_subtype_uuid']")
	WebElement ReportSubCategoryDD;	
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='research_type']")
	WebElement ResearchTypeDD;
	
	@FindBy(xpath="//select[@ng-reflect-name='segment']")
	WebElement SegmentDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='scrip_data']")
	WebElement ScripNameDD;
	
	@FindBy(xpath="//ng-select[@ng-reflect-name='call_type_uuid']")
	WebElement CallTypeDD;
	
	@FindBy(xpath="//input[@ng-reflect-name='cmp']")
	WebElement CMPtxt;
	
	@FindBy(xpath="//input[@ng-reflect-name='upside_potential_percentage']")
	WebElement UpsidePotentialtxt;
	
	@FindBy(xpath="//input[@ng-reflect-name='target_price']")
	WebElement TargetPricetxt;
	
	@FindBy(xpath="//input[@ng-reflect-name='holding_period']")
	WebElement HoldingPeriodtxt;
	

	@FindBy(xpath="//body[@id='tinymce']")
	WebElement Descriptiontxt;
	
	@FindBy(xpath="//button//span[contains(text(),'Add')]")
	WebElement AddFundamentalReportFormbutton;	
	
	public void FundamentalReportClick() throws InterruptedException {
		 Thread.sleep(3000);
		 AddFundamentalReportbtn.click();
		 Thread.sleep(3000);
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
	
	public WebElement getResearchTypeDD() {
		return ResearchTypeDD;
	}
	
	public WebElement getSegmentDD() {
		Select select= new Select(SegmentDD);
		select.selectByVisibleText("Derivative");
		return SegmentDD;
	}	
	
	public void FundamentalReportLink() throws InterruptedException {
		this.driver.get("https://cbadev.choiceconnect.in/research-report/research/fundamental");
		Thread.sleep(6000);
		
	}
	public FundamentalReportPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
	}
	public void addFundamentalReport(String CMPValue,String UpsidePotentialValue,String TargetPriceValue,String 
			HoldingPeriodvalue,String Descriptionvalue) throws InterruptedException 
	{
		Thread.sleep(3000);
		CMPtxt.clear();
		CMPtxt.sendKeys(CMPValue);
		Thread.sleep(2000);
		UpsidePotentialtxt.sendKeys(UpsidePotentialValue);
		Thread.sleep(2000);
		TargetPricetxt.sendKeys(TargetPriceValue);
		Thread.sleep(2000);
		HoldingPeriodtxt.sendKeys(TargetPriceValue);


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
	 
	 public void addFundamentalReportform() throws InterruptedException {
		 AddFundamentalReportFormbutton.click();	
			Thread.sleep(6000);
	 }
}
