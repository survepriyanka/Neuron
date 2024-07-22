package com.neuron.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.base.Testbase;
import com.neuron.qa.pages.FundamentalReportPage;
import com.neuron.qa.pages.IPOReportPage;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.utility.DropdownHandler;

public class IPOReportTest extends Testbase {
	
	
	    IPOReportPage IPOreportPage;
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
			IPOreportPage=new IPOReportPage(this.webDriver);
			loginpage=new LoginPage(this.webDriver);
			loginpage.adminlogin();
			Thread.sleep(2000);
			webDriver.manage().window().maximize();	
			Thread.sleep(3000);
			IPOreportPage.IPOReportLink();
			Thread.sleep(6000);
		}
		
		  @DataProvider
			public Object[][] IPOReportTestData() 
		  {
				this.sheetPath=IPOReportTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
				Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 8);
				System.out.println(data.length+"=="+data[0].length);
				return data;
				
		  }  	  
		  
		  @Test(dataProvider="IPOReportTestData")
			
			public void IPOReportTest(String PotentialPricetextValue,String PriceBandtextValue,String MCAPpriceBandtextValue,String 
					EnterprisetextValue) 
					throws InterruptedException
			{
			  
			  IPOreportPage.IPOReportLink();
			  Thread.sleep(4000);
			  IPOreportPage.IPOReportClick();
			  Thread.sleep(4000);
			  dropdownhandler.AngularDropdown(IPOreportPage.getReportSubCategoryDD(),"IPO REPORT");
			  Thread.sleep(3000);
			  dropdownhandler.AngularDropdown(IPOreportPage.getScripNameDD(),"HDFC DEBT LTD");
			  Thread.sleep(3000);
			  dropdownhandler.AngularDropdown(IPOreportPage.getCallTypeDD(),"Subscribe");
			  Thread.sleep(3000);
			  IPOreportPage.addIPOReport(PotentialPricetextValue, PriceBandtextValue, MCAPpriceBandtextValue, EnterprisetextValue);
			  Thread.sleep(3000);
			  IPOreportPage.DescriptionData();
			  Thread.sleep(3000);
			  IPOreportPage.addIPOReportform();
			  Thread.sleep(3000);	  	  
		
			}

}
