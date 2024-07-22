package com.neuron.qa.utility;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neuron.qa.base.Testbase;

public class DropdownHandler extends Testbase{
	public void  AngularDropdown( final WebElement Dropdown,String Userinput) throws InterruptedException {
	//public WebDriver driver;
	 Dropdown.click();
//	 Wait<WebDriver> wait= new WebDriverWait(this.driver, 5).ignoring(NoSuchElementException.class);
//	 wait.until(new ExpectedCondition<Boolean>(){
//		 public Boolean apply(WebDriver webDriver) {
//			 return Dropdown.findElement(By.xpath(".//ng-dropdown-panel")).isDisplayed();
//		 }});		 

  	 List<WebElement> ngDropdownAllValues=Dropdown.findElements(By.xpath(".//ng-dropdown-panel//div[contains(@class,'ng-option')]")); //xpath of all options,present in list
  	 Thread.sleep(2000);
  	 for(WebElement we:ngDropdownAllValues) {
  		
  		if(we!=null && we.getText().trim().equalsIgnoreCase(Userinput)) {
  			Thread.sleep(4000);
  			we.click();
  			break;
  			
  		} } 
	}
}
	
	