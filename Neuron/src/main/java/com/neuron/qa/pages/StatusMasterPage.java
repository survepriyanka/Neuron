package com.neuron.qa.pages;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.neuron.qa.base.Testbase;

public class StatusMasterPage extends Testbase
{
		
	
	@FindBy(xpath="//button[contains(text(), 'Add Status')]")
	WebElement AddStatusbtn;
	
	@FindBy(xpath="//input[@ng-reflect-name='status_name']")
	WebElement statusNametext;
	
	@FindBy(xpath="//input[@ng-reflect-name='slug']")
	WebElement statusSlugtext;	
	
	@FindBy(xpath="//select[@ng-reflect-name='is_book_action']")
	WebElement BookActionDD;	
	
	@FindBy(xpath="//button//span[text()='Add']")
	WebElement addStatusformbtn;	
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	WebElement EditIcon;
	
	@FindBy(xpath="//label[@class='validation-error2']")
	WebElement ErrorMessage1;
	@FindBy(xpath="//label[@class='validation-error']")
	WebElement ErrorMessage2;
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement ErrorMessageCommon;
	
	@FindBy(xpath="//div[text()=' Success ']")
	WebElement ErrorMessageSuccess;

	
	public void Statusdropdown() {
		Select select=new Select(BookActionDD);
		select.selectByVisibleText("No");
		
	}
	public void statuslink() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.get("https://cbadev.choiceconnect.in/research-report/masters/status");
		
	}
	public void addStatusClick() throws InterruptedException {
		Thread.sleep(2000);
		AddStatusbtn.click();
		Thread.sleep(3000);
		
	}
	public StatusMasterPage(WebDriver webDriver)
	{
	
		this.driver=webDriver;
		PageFactory.initElements(driver, this);
		}
	public void addStatusMaster(String nameTextvalue,String slugtextvalue) throws InterruptedException 
	{
		Thread.sleep(3000);
		statusNametext.sendKeys(nameTextvalue);
		Thread.sleep(2000);
		statusSlugtext.sendKeys(slugtextvalue);
		Select select=new Select(BookActionDD);
		select.selectByVisibleText("Yes");
		Thread.sleep(2000);
		
	}
	
	public void addStatusformbuttonclick() throws InterruptedException {
		addStatusformbtn.click();	
		Thread.sleep(6000);
//		try {
//		if(ErrorMessage1!=null || ErrorMessage2 !=null|| ErrorMessageCommon!=null  && ErrorMessage1.isDisplayed()||ErrorMessage2.isDisplayed()||ErrorMessageCommon.isDisplayed())
//		{		
//			System.out.println("failed TC");
//			this.statuslink();
//		}
//		}
//		catch(Exception e) {		
//		
//			if(ErrorMessageSuccess!=null && ErrorMessageSuccess.isDisplayed())
//			{
//				System.out.println("Test cases is Passed");
//			}
//				
//			Thread.sleep(3000);		
//		addCallTypeformbtn.click();	
			
		//}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void StatusMasterlink() {		
		driver.get("https://neuronbeta.choicetechlab.com/research-report/masters/status");
	}
	
	

}
