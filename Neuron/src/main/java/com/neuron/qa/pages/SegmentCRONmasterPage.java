package com.neuron.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;

public class SegmentCRONmasterPage extends Testbase
{
	WebDriver webDriver=driver;
	
	@FindBy(xpath="//button[contains(text(),'Add Segment CRON Time')]")
	WebElement AddSegmentbtn;
	
	@FindBy(xpath="//input[@ng-reflect-name='segment_name']")
	WebElement segmentNametext;
	
	@FindBy(xpath="//input[@ng-reflect-name='segment_id']")
	WebElement segmentIDtext;
	
	@FindBy(xpath="//input[@placeholder='HH']")
	WebElement CRONtimeHourText;
	
	@FindBy(xpath="//input[@placeholder='MM']")
	WebElement CRONtimeMinuteText;
	
	@FindBy(xpath="//button[text()='AM ']")
	WebElement AMiconbtn;
	
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addCallTypeformbtn;
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	WebElement EditIcon;
	
	@FindBy(xpath="//button//span[text()='Update']")
	WebElement FormUpdatebtn;
	
	@FindBy(xpath="//label[@class='validation-error2']")
	WebElement ErrorMessage1;
	@FindBy(xpath="//label[@class='validation-error']")
	WebElement ErrorMessage2;
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement ErrorMessageCommon;
	
	@FindBy(xpath="//div[text()=' Success ']")
	WebElement ErrorMessageSuccess;
		
	
	public void segmentCRONlink() {		
		driver.get("https://cbadev.choiceconnect.in/research-report/masters/segmentcron-time");
	}
	public  SegmentCRONmasterPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
	}
	 public void addSegmentCRONclick() throws InterruptedException {
		 Thread.sleep(3000);
		 AddSegmentbtn.click();
	}
	 public void addReportCategoryMaster(String nameTextvalue,String segmentID,String Hour,String Min) throws InterruptedException 
		{
			Thread.sleep(3000);
			segmentNametext.sendKeys(nameTextvalue);
			Thread.sleep(2000);
			segmentIDtext.sendKeys(segmentID);
			Thread.sleep(2000);
			CRONtimeHourText.sendKeys(Hour);
			Thread.sleep(2000);
			CRONtimeMinuteText.sendKeys(Min);		
			Thread.sleep(2000);
			AMiconbtn.click();
			Thread.sleep(2000);
		}
	 public void addSegmentCRONform() throws InterruptedException {
		 addCallTypeformbtn.click();	
			Thread.sleep(6000);
//			try {
//			if(ErrorMessage1!=null || ErrorMessage2 !=null|| ErrorMessageCommon!=null  && ErrorMessage1.isDisplayed()||ErrorMessage2.isDisplayed()||ErrorMessageCommon.isDisplayed())
//			{		
//				System.out.println("failed TC");
//				this.segmentCRONlink();
//			}
//			}
//			catch(Exception e) {		
//			
//				if(ErrorMessageSuccess!=null && ErrorMessageSuccess.isDisplayed())
//				{
//					System.out.println("Test cases is Passed");
//				}
//					
////				Thread.sleep(3000);		
////			addCallTypeformbtn.click();	
//				
//			}
			}
		
			

}
