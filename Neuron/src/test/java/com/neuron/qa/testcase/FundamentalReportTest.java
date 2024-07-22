package com.neuron.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.base.Testbase;
import com.neuron.qa.pages.FundamentalReportPage;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.TechnicalReportPage;
import com.neuron.qa.utility.DropdownHandler;

public class FundamentalReportTest extends Testbase {
	 FundamentalReportPage FundamentalreportPage;
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
			FundamentalreportPage=new FundamentalReportPage(this.webDriver);
			loginpage=new LoginPage(this.webDriver);
			loginpage.adminlogin();
			Thread.sleep(2000);
			webDriver.manage().window().maximize();	
			Thread.sleep(3000);
			FundamentalreportPage.FundamentalReportLink();
			Thread.sleep(6000);
		}
		
		  @DataProvider
			public Object[][] FundamentalReportTestData() 
		  {
				this.sheetPath=StatusMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
				Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 6);
				System.out.println(data.length+"=="+data[0].length);
				return data;
				
				
				
				
		  }
		  
		  @Test(dataProvider="FundamentalReportTestData")
			
			public void FundamentalReportTest(String CMPtextValue,String UpsidePotentialTextValue,String TargetPriceTextValue,String 
					HoldingPeriodTextvalue,String Descriptiontextvalue) 
					throws InterruptedException
			{
			  			  
			  FundamentalreportPage.FundamentalReportLink();
			  Thread.sleep(4000);
			  FundamentalreportPage.FundamentalReportClick();
			  Thread.sleep(4000);
			  dropdownhandler.AngularDropdown(FundamentalreportPage.getReportSubCategoryDD(),"Economy");
			  Thread.sleep(3000);
			  dropdownhandler.AngularDropdown(FundamentalreportPage.getResearchTypeDD(),"Short Term");
			  Thread.sleep(3000);
			  FundamentalreportPage.getSegmentDD();
			  Thread.sleep(7000);
			  dropdownhandler.AngularDropdown(FundamentalreportPage.getScripNameDD(),"A2ZINFRA (BSE)");
			  Thread.sleep(7000);
			  dropdownhandler.AngularDropdown(FundamentalreportPage.getCallTypeDD(),"Sell on Rise");
			  Thread.sleep(3000);
			  FundamentalreportPage.addFundamentalReport(CMPtextValue, UpsidePotentialTextValue, TargetPriceTextValue, HoldingPeriodTextvalue, Descriptiontextvalue);
			  Thread.sleep(3000);
			  Thread.holdsLock(HoldingPeriodTextvalue);
			  Thread.sleep(5000);
			  FundamentalreportPage.DescriptionData(Descriptiontextvalue);
			  Thread.sleep(3000);
			  FundamentalreportPage.addFundamentalReportform();
			  Thread.sleep(3000);
			  
			
			  
			  
			  
			   
//	
//  driver.get("https://neuronbeta.choicetechlab.com/research-report/research/fundamental");
//  Thread.sleep(10000);
// 
//  WebElement AddFundamentalReportbtn=driver.findElement(By.xpath("//button[@ng-reflect-tooltip='Add New']"));	 
//  AddFundamentalReportbtn.click();
//  Thread.sleep(4000);
// // WebElement ReportSubCategoryDD=driver.findElement(By.xpath("//ng-select[@ng-reflect-name='report_subtype_uuid']"));//  
// dropdownhandler.AngularDropdown2(this.getReportSubCategoryDD(),'Special Report');
			  
//WebElement ResearchTypeDD=driver.findElement(By.xpath("//ng-select[@ng-reflect-name='research_type']"));
//  WebElement SegmentDD=driver.findElement(By.xpath("//select[@ng-reflect-name='segment']"));
//	Select sc= new Select(SegmentDD);
//	sc.selectByVisibleText("Derivative");
//  
//	// WebElement ScripNameDD=driver.findElement(By.xpath("//ng-select[@ng-reflect-name="scrip_data"]"));
//	// WebElement CallTypeDD=driver.findElement(By.xpath("//ng-select[@ng-reflect-name="call_type_uuid"]"));
//  
//	 Thread.sleep(2000);
//	  WebElement CMPtxt=driver.findElement(By.xpath("//input[@ng-reflect-name='cmp']"));
//	  CMPtxt.sendKeys("1240");
//	  Thread.sleep(2000);
//	  WebElement UpsidePotentialtxt=driver.findElement(By.xpath("//input[@ng-reflect-name='upside_potential_percentage']"));
//	  UpsidePotentialtxt.sendKeys("58");
//	  Thread.sleep(2000);
//	  WebElement TargetPricetxt=driver.findElement(By.xpath("//input[@ng-reflect-name='target_price']"));
//	  TargetPricetxt.sendKeys("9568");
//	  Thread.sleep(2000);
//	  WebElement HoldingPeriodtxt=driver.findElement(By.xpath("//input[@ng-reflect-name='holding_period']"));
//	  HoldingPeriodtxt.sendKeys("25");
//	  Thread.sleep(4000);
//	  WebElement Descriptiontxt=driver.findElement(By.xpath("//body[@id='tinymce']"));
//	  Descriptiontxt.sendKeys("Pending");
//	  WebElement AddTechnicalReportFormbutton=driver.findElement(By.xpath("//button//span[contains(text(),'Add')]"));
//	  AddTechnicalReportFormbutton.click();
//	  Thread.sleep(4000);  
//  
//  
//  
//  
//  
//  
}
}