package com.neuron.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.base.Testbase;
import com.neuron.qa.pages.CallTypeMasterPage;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.StatusMasterPage;
import com.neuron.qa.pages.TechnicalReportPage;
import com.neuron.qa.utility.DropdownHandler;

public class TechnicalReportTest {
	
	TechnicalReportPage TechnicalreportPage;
	LoginPage loginpage;
	DropdownHandler dropdownhandler;
	Configuration config;
	WebDriver webDriver;
	String sheetname="NeuronTestData";
	String sheetPath;

	@BeforeTest
	public void sampleTest() throws InterruptedException 
	{
		dropdownhandler=new DropdownHandler();
		this.config = new Configuration();
		this.webDriver = this.config.openBrowser();	
		TechnicalreportPage=new TechnicalReportPage(this.webDriver);
		loginpage=new LoginPage(this.webDriver);
		loginpage.adminlogin();
		Thread.sleep(2000);
		webDriver.manage().window().maximize();	
		Thread.sleep(3000);
		TechnicalreportPage.TechnicalReportLink();
		Thread.sleep(6000);
	}

  @DataProvider
	public Object[][] TechnicalReportTestData() 
  {
		this.sheetPath=StatusMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
		Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 5);
		System.out.println(data.length+"=="+data[0].length);
		return data;
  }
    
	@Test(dataProvider="TechnicalReportTestData")
	
	public void TechnicalReportTest(String EntryPriceTextValue, String StopLossTextValue,String Descriptiontextvalue
) throws InterruptedException
	{
		
		TechnicalreportPage.TechnicalReportLink();
		TechnicalreportPage.TechnicalReportClick();		
	    dropdownhandler.AngularDropdown(TechnicalreportPage.getReportSubCategoryDD(),"Equity Bazaar");
	    Thread.sleep(2000);
	    dropdownhandler.AngularDropdown(TechnicalreportPage.getResearchTypeDD(),"Intra Day");
	    Thread.sleep(2000);
	    dropdownhandler.AngularDropdown(TechnicalreportPage.getSegmentDD(),"Equity");
	    Thread.sleep(2000);
	    dropdownhandler.AngularDropdown(TechnicalreportPage.getScripDD(),"AARTIIND (NSE)");
	    Thread.sleep(2000);
	    dropdownhandler.AngularDropdown(TechnicalreportPage.getCallTypeDD(),"Buy");
	    Thread.sleep(2000);
	    TechnicalreportPage.addTechnicalReport(EntryPriceTextValue, StopLossTextValue);
	    Thread.sleep(2000);
	    TechnicalreportPage.DescriptionData(Descriptiontextvalue);
	    Thread.sleep(3000);
	    TechnicalreportPage.addtechnicalReportform();
	    Thread.sleep(3000);
	}
	 


  
  
  
  
  
  
  
  
  
  
}

