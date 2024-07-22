package com.neuron.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;


public class CallTypeMasterPage extends Testbase{
	
	@FindBy(xpath="//button[contains(text(),'Add Call Type')]")
	WebElement addCallTypebtn;
	@FindBy(xpath="//input[@ng-reflect-name='call_type_name' and @placeholder='Enter Name']")
	WebElement nametext;
	@FindBy(xpath="//select[@ng-reflect-name='call_category']")
	WebElement CallCategoryDropdown;
	@FindBy(xpath="//select[@ng-reflect-name='ipo_flag']")
	WebElement IPOdropdown;
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addCallTypeformbtn;
	@FindBy(xpath="//label[@class='validation-error2']")
	WebElement ErrorMessage1;
	@FindBy(xpath="//label[@class='validation-error']")
	WebElement ErrorMessage2;
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement ErrorMessageCommon;
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	WebElement EditIcon;
	@FindBy(xpath="//button//span[text()='Update']")
	WebElement FormUpdatebtn;
	@FindBy(xpath="//div[text()=' Success ']")
	WebElement ErrorMessageSuccess;
	
	

	
	
	public void callTypeLink() {
		this.driver.get("https://cbadev.choiceconnect.in/research-report/masters/call-type");
		
	}
	public  CallTypeMasterPage(WebDriver webDriver) {
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		
	}
	 public void addcallTypeclick() throws InterruptedException {
		 Thread.sleep(3000);
		 addCallTypebtn.click();
	}
	public void addCallTypeMaster(String nameTextvalue) throws InterruptedException 
	{
		Thread.sleep(3000);
		nametext.sendKeys(nameTextvalue);
		Thread.sleep(2000);
		Select select=new Select(CallCategoryDropdown);
		select.selectByVisibleText("Sell");
		Thread.sleep(2000);
		Select select1=new Select(IPOdropdown);
		select1.selectByVisibleText("No");	
		Thread.sleep(5000);
			
	}
	
	
	public void addCallTypeformbutton() throws InterruptedException {
		addCallTypeformbtn.click();	
		Thread.sleep(6000);
		try {
		if(ErrorMessage1!=null || ErrorMessage2 !=null|| ErrorMessageCommon!=null  && ErrorMessage1.isDisplayed()||ErrorMessage2.isDisplayed()||ErrorMessageCommon.isDisplayed())
		{		
			System.out.println("failed TC");
			this.callTypeLink();
		}
		}
		catch(Exception e) {		
		
			if(ErrorMessageSuccess!=null && ErrorMessageSuccess.isDisplayed())
			{
				System.out.println("Test cases is Passed");
			}
				
//			Thread.sleep(3000);		
//		addCallTypeformbtn.click();	
			
		}
		}
		
//		catch (Exception e) {
//			// TODO: handle exception
//		}
	
	
	}
	

