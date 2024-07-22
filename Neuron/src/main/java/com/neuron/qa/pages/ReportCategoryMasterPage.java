package com.neuron.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;

public class ReportCategoryMasterPage extends Testbase
{
	//WebDriver webDriver;
	@FindBy(xpath="//button[contains(text(), 'Add Report Category')]")
	WebElement AddReportCategorybtn;
	
	@FindBy(xpath="//input[@ng-reflect-name='report_name']")
	WebElement reportNametext;
	
	@FindBy(xpath="//input[@ng-reflect-name='report_slug']")
	WebElement ReportSlugtext;	

	@FindBy(xpath="//body[@id='tinymce']")
	WebElement ReportDescriptiontext;

	@FindBy(xpath="//select[@ng-reflect-name='report_status']")
	WebElement StatusDD;	
	
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addReportTypeformbtn;
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	WebElement EditIcon;
	
	@FindBy(xpath="//button[contains(text(),'View')]")
	WebElement ViewIcon;
	
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
	
	
	public void statusdropdown() {
		Select select=new Select(StatusDD);
		select.selectByVisibleText("Inactive");
		
	}	

		public void ReportCategorylink () throws InterruptedException {		
		driver.get("https://cbadev.choiceconnect.in/research-report/masters/report-type");
		 Thread.sleep(4000);
	}
		public  ReportCategoryMasterPage(WebDriver webDriver) {
			this.driver=webDriver;
			PageFactory.initElements(driver, this);
			
		}
		 public void AddReportCategoryclick() throws InterruptedException {
			 Thread.sleep(3000);
			 AddReportCategorybtn.click();
			 Thread.sleep(5000);
		}
		 public void addReportCategoryMaster(String nameTextvalue,String Slugtextvalue) throws InterruptedException 
			{
				Thread.sleep(3000);
				reportNametext.sendKeys(nameTextvalue);
				Thread.sleep(2000);
				ReportSlugtext.sendKeys(Slugtextvalue);
				Thread.sleep(2000);
//				ReportDescriptiontext.sendKeys(descriptiontextvalue);
//				Thread.sleep(2000);
				Select select=new Select(StatusDD);
				select.selectByVisibleText("Inactive");
				Thread.sleep(2000);				
			}
		 
		 public void DescriptionData(String describe) throws InterruptedException 
			{
				Thread.sleep(3000);		
			//	JavascriptExecutor js=(JavascriptExecutor)this.driver;
			//	js.executeScript(document.getElementById('tinymce').click()");
				
//				((JavascriptExecutor) this.driver).executeScript(
//						  "arguments[0].setAttribute('value',+ describe)",
//						  ReportDescriptiontext);
				try {
				ReportDescriptiontext.sendKeys(describe);
				}
				catch(NoSuchElementException e){
					System.out.println("handled NoSuchElementException");
				}
				Thread.sleep(2000);
				
				
				
				
				//document.getElementById("tinymce");
				
			}
		 public void addReportCategoryform() throws InterruptedException {
			 addReportTypeformbtn.click();	
				Thread.sleep(6000);
//				try {
//				if(ErrorMessage1!=null || ErrorMessage2 !=null|| ErrorMessageCommon!=null  && ErrorMessage1.isDisplayed()||ErrorMessage2.isDisplayed()||ErrorMessageCommon.isDisplayed())
//				{		
//					System.out.println("failed TC");
//					this.ReportCategorylink();
//				}
//				}
//				catch(Exception e) {		
//				
//					if(ErrorMessageSuccess!=null && ErrorMessageSuccess.isDisplayed())
//					{
//						System.out.println("Test cases is Passed");
//					}
//						
////					Thread.sleep(3000);		
////				addCallTypeformbtn.click();	
//					
//				}
				}
			
}
