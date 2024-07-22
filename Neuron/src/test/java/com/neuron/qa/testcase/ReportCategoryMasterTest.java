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
import com.neuron.qa.pages.CallTypeMasterPage;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.ReportCategoryMasterPage;
import com.neuron.qa.pages.StatusMasterPage;
import com.neuron.qa.utility.DropdownHandler;

public class ReportCategoryMasterTest {
		
	    ReportCategoryMasterPage ReportcategoryMasterPage;
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
			ReportcategoryMasterPage=new ReportCategoryMasterPage(this.webDriver);
			loginpage=new LoginPage(this.webDriver);
			loginpage.adminlogin();
			Thread.sleep(2000);
			webDriver.manage().window().maximize();	
			Thread.sleep(2000);
//			ReportcategoryMasterPage.ReportCategorylink();
//			Thread.sleep(2000);
			
		}

		@DataProvider
		public Object[][] ReportTypeMasterTestData() //not nedd to same name as sheetname.dataprovidername and methodname must be same.
		{
			this.sheetPath=ReportCategoryMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
			Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 2);
			System.out.println(data.length+"=="+data[0].length);
			return data;
			
		}
		
		@Test(dataProvider = "ReportTypeMasterTestData")
		public void ReportcategormasterTest(String NameTextvalue,String slugtextvalue,String Descriptiontextvalue) throws InterruptedException
		{
			ReportcategoryMasterPage.ReportCategorylink();
			ReportcategoryMasterPage.AddReportCategoryclick();
			ReportcategoryMasterPage.addReportCategoryMaster(NameTextvalue, slugtextvalue);
			ReportcategoryMasterPage.DescriptionData(Descriptiontextvalue);
			ReportcategoryMasterPage.addReportCategoryform();
			Thread.sleep(3000);
			
		}
}
