package com.neuron.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.ReportCategoryMasterPage;
import com.neuron.qa.pages.ReportSubcategoryMasterPage;
import com.neuron.qa.utility.DropdownHandler;

public class ReportSubCategoryMasterTest {
	 
			ReportSubcategoryMasterPage ReportSubCategoryMasterPage;
			LoginPage loginpage;
			//CallTypeMasterPage calltypemasterPage;
			DropdownHandler dropdownhandler;
			Configuration config;
			WebDriver webDriver;
			String sheetname="NeuronTestData";
			String sheetPath;
			
			@BeforeTest
			public void sampletest() throws InterruptedException {
				dropdownhandler=new DropdownHandler();
				this.config=new Configuration();
				this.webDriver=config.openBrowser();
				ReportSubCategoryMasterPage=new ReportSubcategoryMasterPage(this.webDriver);
			//	calltypemasterPage =new CallTypeMasterPage(this.webDriver);
				
				loginpage=new LoginPage(this.webDriver);
				loginpage.adminlogin();
				Thread.sleep(2000);
				webDriver.manage().window().maximize();		
				
			}

			@DataProvider
			public Object[][] ReportSubTypeMasterTestData() //not nedd to same name as sheetname.dataprovidername and methodname must be same.
			{
				this.sheetPath=ReportSubCategoryMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
				Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 3);
				System.out.println(data.length+"=="+data[0].length);
				return data;
				
			}
			@Test(dataProvider="ReportSubTypeMasterTestData")
			public void ReportSubcategormasterTest(String NameTextvalue,String slugtextvalue,String Descriptiontextvalue) throws InterruptedException
			{
				ReportSubCategoryMasterPage.Reportsubcategorylink();
				ReportSubCategoryMasterPage.AddReportSubCategoryclick();
				ReportSubCategoryMasterPage.addReportSubCategoryMaster(NameTextvalue, slugtextvalue, Descriptiontextvalue);
//				ReportSubCategoryMasterPage.ReportCategorydropdown();
//				ReportSubCategoryMasterPage.VisibleAppdropdown();
//				ReportSubCategoryMasterPage.Notificationdropdown();
//				ReportSubCategoryMasterPage.SpecialFlagdropdown();
				ReportSubCategoryMasterPage.addReportSubCategoryform();
				Thread.sleep(3000);
				
			}	
			
			

}
