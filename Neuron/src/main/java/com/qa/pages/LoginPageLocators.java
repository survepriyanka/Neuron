package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPageLocators {
	static WebDriver webdriver = null;
//	private static String UN = null;
//	private static String PWD = null;
	
	public void uname(WebDriver webdriver, String UN) throws InterruptedException {
		Thread.sleep(2000);
		WebElement username = webdriver.findElement(By.xpath("//input[@id='Username']"));
		username.clear();
		username.sendKeys(UN);
		System.out.println("username is: "+ UN);

	}

	public void passwd(WebDriver webdriver, String PWD) {
		WebElement password = webdriver.findElement(By.xpath("//input[@id='Password']"));
		password.clear();
		password.sendKeys(PWD);
		System.out.println("password is: "+ PWD);
		
	}

	public boolean loginclick(WebDriver webdriver) throws InterruptedException {
		boolean isLoginValid=true;
		WebElement loginbutton = webdriver.findElement(By.xpath("//button[text()='Login']"));
		loginbutton.click();
		
		
		List<WebElement> responseElement =new ArrayList();
		
		try {		
		WebElement messgage=webdriver.findElement(By.xpath("//li[text()='Invalid username or password']"));
		Thread.sleep(4000);
		
		//WebElement responceElement2=webdriver.findElement(By.xpath("//li[text()='The Username field is required.']"));
		//WebElement responceElement3=webdriver.findElement(By.xpath("//li[text()='The Password field is required.']"));
		
		
			String actualres = messgage.getText();
			String experes = "Invalid username or password";
			//String actualres2= responceElement2.getText();
			//String expres2= "The Username field is required.";
			//String actualres3= responceElement2.getText();
			//String expres3= "The Password field is required.";
			
			
			if (actualres.equals(experes)) 
			{
				System.out.println(actualres);
				
			}
//			else if(actualres2.equals(expres2))
//			{
////				WebElement username = webdriver.findElement(By.xpath("//input[@id='Username']"));
////				String user=username.toString();
//				String uname = null;
//				if(uname.isEmpty()&& actualres2.equals(expres2))
//				{
//					System.out.println(expres2);
//					
//				}
//			}
			
//			else
//			{
//			
//				System.out.println(actualres);
//			}
			
		} catch (Exception e)
		{
		}
		return isLoginValid;
	}

	public void logoutclick(WebDriver webdriver) throws InterruptedException {
		
		boolean logoutvalid=true;
		Thread.sleep(8000);
		WebElement profilrbutton = webdriver.findElement(By.xpath("//a[@class='dropdown initial-dropdown']"));
		profilrbutton.click();
		Thread.sleep(2000);
		WebElement logoutbtn = webdriver.findElement(By.xpath("//a[text()=' Logout']"));
		logoutbtn.click();

	}
	
	public void ResearchReportTab(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(4000);
		WebElement RReportTab=webdriver.findElement(By.xpath("//span[text()='Research Report']"));
		RReportTab.click();
		
	}
	public void RRmasterTab(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(4000);
		WebElement masterTab=webdriver.findElement(By.xpath("//span[text()='RR Masters']"));
		masterTab.click();		
	}
	public void Statusmastertab(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(4000);
		WebElement statustab=webdriver.findElement(By.xpath("//span[text()='Status']"));
		statustab.click();		
	}
	
	public void addStatusbutton(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(4000);
		WebElement addStatusbtn=webdriver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		addStatusbtn.click();
		
	}
	public void statusformNameTextField(WebDriver webdriver,String stName) throws InterruptedException 
	{
			
		Thread.sleep(2000);
		WebElement statusName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='status_name']"));
		statusName.clear();
		statusName.sendKeys(stName);
		
	//	System.out.println("name is: "+ stName);
	
		
	}
	public void statusformSlugTextField(WebDriver webdriver, String stSlug) throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement statusSlugName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='slug']"));
		statusSlugName.clear();
		statusSlugName.sendKeys(stSlug);
	//	System.out.println("slug is: "+ stSlug);
	
	}
	
	public void bookActionDropdown(WebDriver webdriver) throws InterruptedException 
	{
		Select sc=new Select(webdriver.findElement(By.xpath("//select[@ng-reflect-name='is_book_action']")));
		Thread.sleep(2000);
		sc.selectByVisibleText("No");
		
	}
	public void statusFormAddButton(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement addbutton=webdriver.findElement(By.xpath("//span[text()='Add']"));
		
//		WebElement statusName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='status_name']"));
//		String nameprevious=statusName.getText();
//		System.out.println("name is" + nameprevious);
		addbutton.click();
		
		
	}
	public void statusFormResetButton(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement ResetButton=webdriver.findElement(By.xpath("//button[text()='Reset']"));
		ResetButton.click();
		
		
	}
	public void statusFormCloseIcon(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(2000);;
		WebElement CloseIcon=webdriver.findElement(By.xpath("//button[@aria-label='Close']"));
		CloseIcon.click();
	}
	public void StatusEditButton(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement editbutton=webdriver.findElement(By.xpath("//button[@title='Edit']"));
		editbutton.click();
		
	}
	public void statusFormUpdateButton(WebDriver webdriver) throws InterruptedException 
	{
		Thread.sleep(3000);		
		WebElement updatebutton=webdriver.findElement(By.xpath("//span[text()='Update']"));
		updatebutton.click();
		
		
	}
	
	
}
