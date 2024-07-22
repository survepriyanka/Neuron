package com.neuron.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neuron.qa.base.Testbase;

public class LoginPage extends Testbase {
	
	
	@FindBy(xpath="//input[@id='Username']")
	WebElement usernametxt;
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordtxt;
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginformbtn;
	@FindBy(xpath="//li[7]//a")
	WebElement loginbtn;
	

	
	 public  LoginPage(WebDriver webDriver) {
		 this.driver=webDriver;
		 PageFactory.initElements(driver, this);
		 
		}
	 public void adminlogin() throws InterruptedException {
	     Thread.sleep(4000);
	     
	     driver.get("http://commondev.choiceconnect.in/");
		// waitUntilPageLoads(this.driver, 40);
		 Thread.sleep(8000);
		 loginbtn.click();
		// usernametxt.sendKeys("bharat@choicetechlab.com");
		 usernametxt.sendKeys("shripad.mayekar@choicetechlab.com");
		 passwordtxt.sendKeys("Ch12#9");
		// passwordtxt.sendKeys("Choice@123");
		 
		 Thread.sleep(2000);
		 loginformbtn.click();
		 Thread.sleep(12000);

}
}
