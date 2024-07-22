package com.neuron.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.base.Testbase;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.SpecialReportPage;
import com.neuron.qa.utility.DropdownHandler;

public class SpecialReportTest extends Testbase {
	
		
		SpecialReportPage SpecialreportPage;
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
			SpecialreportPage=new SpecialReportPage(this.webDriver);
			loginpage=new LoginPage(this.webDriver);
			loginpage.adminlogin();
			Thread.sleep(2000);
			webDriver.manage().window().maximize();	
			Thread.sleep(3000);
			SpecialreportPage.SpecialReportLink();
			Thread.sleep(6000);
		}
		
	  @DataProvider
	  public Object[][] SpecialReportTestData()
		//public Object[][] TechnicalReportTestData() 
	  {
			this.sheetPath=SpecialReportTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
			Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 7);
			System.out.println(data.length+"=="+data[0].length);
			return data;
	  }
	  @Test(dataProvider="SpecialReportTestData")
		
		public void SpecialReportTestg(String EntryPriceTextValue, String StopLossTextValue) throws InterruptedException
		{
		  		  		
		   	SpecialreportPage.SpecialReportLink();
			SpecialreportPage.SpecialReportClick();		
		    dropdownhandler.AngularDropdown(SpecialreportPage.getReportSubCategoryDD(),"Sumeet Bagadia’s Desk");
		    Thread.sleep(2000);
		    dropdownhandler.AngularDropdown(SpecialreportPage.getResearchTypeDD(),"Intra Day");
		    Thread.sleep(2000);
		    dropdownhandler.AngularDropdown(SpecialreportPage.getSegmentDD(),"Equity");
		    Thread.sleep(2000);
		    dropdownhandler.AngularDropdown(SpecialreportPage.getScripNameDD(),"AARTIIND (NSE)");
		    Thread.sleep(2000);
		    dropdownhandler.AngularDropdown(SpecialreportPage.getCallTypeDD(),"Buy");
		    Thread.sleep(2000);
		    SpecialreportPage.addSpecialReport(EntryPriceTextValue, StopLossTextValue);
		    Thread.sleep(2000);
		    SpecialreportPage.addSpecialReportform();
		    Thread.sleep(3000);
		    
		}
	}

