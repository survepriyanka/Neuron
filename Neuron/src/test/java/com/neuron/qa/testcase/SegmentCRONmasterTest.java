package com.neuron.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.ReportCategoryMasterPage;
import com.neuron.qa.pages.SegmentCRONmasterPage;
import com.neuron.qa.utility.DropdownHandler;

public class SegmentCRONmasterTest {

	SegmentCRONmasterPage SegmentCRONmasterpage;
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
		SegmentCRONmasterpage=new SegmentCRONmasterPage(this.webDriver);
	//	calltypemasterPage =new CallTypeMasterPage(this.webDriver);
		loginpage=new LoginPage(this.webDriver);
		loginpage.adminlogin();
		Thread.sleep(2000);
		webDriver.manage().window().maximize();		
		
	}

	@DataProvider
	public Object[][] SegmentCRONMasterTestData() //not nedd to same name as sheetname.dataprovidername and methodname must be same.
	{
		this.sheetPath=ReportCategoryMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
		Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 4);
		System.out.println(data.length+"=="+data[0].length);
		return data;
		
	}
	
	@Test(dataProvider = "SegmentCRONMasterTestData")
	public void ReportcategormasterTest(String NameTextvalue,String SegmentIdTextvalue,String HourTextValue,String MinTextValue


) throws InterruptedException
	{
		SegmentCRONmasterpage.segmentCRONlink();
		SegmentCRONmasterpage.addSegmentCRONclick();
		SegmentCRONmasterpage.addReportCategoryMaster(NameTextvalue, SegmentIdTextvalue, HourTextValue, MinTextValue);
		SegmentCRONmasterpage.addSegmentCRONform();
		Thread.sleep(3000);
		
		
	}



}
