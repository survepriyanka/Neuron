package com.neuron.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;

public class ReportSubcategoryMasterPage extends Testbase
{
	WebDriver webDriver=driver;
	@FindBy(xpath="//button[contains(text(), 'Add Report Subtype')]")
	WebElement AddReportsubcategorybtn;
	
	@FindBy(xpath="//input[@ng-reflect-name='report_subtype_name']")
	WebElement reportSubtypeNametext;
	
	@FindBy(xpath="//input[@ng-reflect-name='report_subtype_slug']")
	WebElement ReportSubtypeSlugtext;	

	@FindBy(xpath="//body[@id='tinymce']")
	WebElement ReportDescriptiontext;
	
	@FindBy(xpath="//div[@class='form-group']//select[@ng-reflect-name='report_type_uuid']")
	WebElement ReportCategoryDD;
	
	@FindBy(xpath="//select[@ng-reflect-name=\"special_subtype_flag\"]")
	WebElement SpecialFlagDD;	
	
	@FindBy(xpath="//select[@ng-reflect-name='visible_on_app']")
	WebElement VisibleAppDD;	
	

	@FindBy(xpath="//select[@ng-reflect-name='notification_flag']")
	WebElement NotificationDD;	
	
	@FindBy(xpath="//input[@ng-reflect-name='file_upload']")
	WebElement fileUploadicon;	
	
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addReportSubTypeformbtn;	
	
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
	
	
	
	public void Reportsubcategorylink() {		
		driver.get("https://cbadev.choiceconnect.in/research-report/masters/report-subtype");
	}
	
	public void ReportCategorydropdown() {
		Select select=new Select(ReportCategoryDD);
		select.selectByVisibleText("Fundamental");
		
	}

	public void  SpecialFlagdropdown() {
		Select select=new Select(SpecialFlagDD);
		select.selectByVisibleText("No");
		
	}
	public void VisibleAppdropdown() {
		Select select=new Select(VisibleAppDD);
		select.selectByVisibleText("No");
		
	}
	public void Notificationdropdown() {
		Select select=new Select(NotificationDD);
		select.selectByVisibleText("No");
		
	}	
	
	 public void AddReportSubCategoryclick() throws InterruptedException {
		 Thread.sleep(3000);
		 AddReportsubcategorybtn.click();
	}
	public  ReportSubcategoryMasterPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
}
	 public void addReportSubCategoryMaster(String nameTextvalue,String slugtextvalue,String descriptiontextvalue) throws InterruptedException 
		{
			Thread.sleep(3000);
			reportSubtypeNametext.sendKeys(nameTextvalue);
			Thread.sleep(2000);
			ReportSubtypeSlugtext.sendKeys(slugtextvalue);
			Thread.sleep(2000);
			try {
				ReportDescriptiontext.sendKeys(descriptiontextvalue);
				}
				catch(NoSuchElementException e){
					System.out.println("handled NoSuchElementException");
				}
				
			Thread.sleep(2000);
			this.VisibleAppdropdown();
			Thread.sleep(2000);
			this.Notificationdropdown();
			Thread.sleep(2000);
			this.SpecialFlagdropdown();
			Thread.sleep(2000);
			this.ReportCategorydropdown();
			Thread.sleep(2000);
		}
	 public void addReportSubCategoryform() throws InterruptedException {
		 Thread.sleep(2000);
		 addReportSubTypeformbtn.click();	
			Thread.sleep(6000);
//			try {
//			if(ErrorMessage1!=null || ErrorMessage2 !=null|| ErrorMessageCommon!=null  && ErrorMessage1.isDisplayed()||ErrorMessage2.isDisplayed()||ErrorMessageCommon.isDisplayed())
//			{		
//				System.out.println("failed TC");
//				this.Reportsubcategorylink();
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
