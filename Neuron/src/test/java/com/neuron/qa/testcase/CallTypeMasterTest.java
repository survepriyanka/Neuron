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
import com.neuron.qa.base.Testbase;
import com.neuron.qa.pages.CallTypeMasterPage;
import com.neuron.qa.pages.LoginPage;
import com.neuron.qa.utility.DropdownHandler;



public class CallTypeMasterTest extends Testbase{
	DropdownHandler dropdownhandler;
	LoginPage loginpage;
	CallTypeMasterPage callTypeMaster;
	private Configuration config;
	public WebDriver webDriver;
	String sheetName="NeuronTestData";
	String sheetPath;
	
	@BeforeTest	
	public void sampleTest() throws InterruptedException 
{
	dropdownhandler=new DropdownHandler();
	this.config = new Configuration();
	this.webDriver = this.config.openBrowser();	
	callTypeMaster=new CallTypeMasterPage(this.webDriver);
	loginpage=new LoginPage(this.webDriver);
	loginpage.adminlogin();
	Thread.sleep(2000);
	webDriver.manage().window().maximize();
	
	
	
}	
	 @DataProvider
		public Object[][] CallTypeMasterTestData(){
		 this.sheetPath=CallTypeMasterTest.class.getClassLoader().getResource("NeuronTestData.xls").getPath();
			Object data[][] = ExcelDataProvider.getTestData(sheetName,sheetPath,0);
			System.out.println(data.length + "====" + data[0].length);
			return data;
		} 
	 
	 @Test(dataProvider="CallTypeMasterTestData")

	 public void CallTypeMasterTest(String NameTextvalue) throws InterruptedException
	 {
		 callTypeMaster.callTypeLink();
			Thread.sleep(4000);
			callTypeMaster.addcallTypeclick();
			callTypeMaster.addCallTypeMaster(NameTextvalue);
			Thread.sleep(3000);
			callTypeMaster.addCallTypeformbutton();
			Thread.sleep(4000);
	 }
}
