package com.neuron.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neuron.qa.DataProvider.ExcelDataProvider;
import com.neuron.qa.base.Configuration;
import com.neuron.qa.pages.CallTypeMasterPage;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.pages.StatusMasterPage;
import com.neuron.qa.utility.DropdownHandler;

public class StatusMasterTest {
	
	StatusMasterPage statusmasterpage;
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
		statusmasterpage=new StatusMasterPage(this.webDriver);
		//calltypemasterPage =new CallTypeMasterPage(this.webDriver);
		
		loginpage=new LoginPage(this.webDriver);
		loginpage.adminlogin();
		Thread.sleep(2000);
		webDriver.manage().window().maximize();	
		Thread.sleep(5000);
		//statusmasterpage.statuslink();
		
		
	}

	@DataProvider
	public Object[][] StatusMasterTestData() //not nedd to same name as sheetname.dataprovidername and methodname must be same.
	{
		this.sheetPath=StatusMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
		Object[][]data=ExcelDataProvider.getTestData(sheetname, sheetPath, 1);
		System.out.println(data.length+"=="+data[0].length);
		return data;
		
	}
	@Test(dataProvider="StatusMasterTestData")
	public void StatusMasterTest(String NameTextvalue,String slugtextvalue) throws InterruptedException
	{
		statusmasterpage.statuslink();
		statusmasterpage.addStatusClick();
		statusmasterpage.addStatusMaster(NameTextvalue, slugtextvalue);
		statusmasterpage.addStatusformbuttonclick();
		Thread.sleep(4000);
	}
	
	
	
	

	
	
	
	
	
	
	
	
	

}
