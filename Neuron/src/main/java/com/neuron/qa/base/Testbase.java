package com.neuron.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testbase {
	public WebDriver driver;// here we are create  driver global Variable because we have to use driver ;
	public static Properties prop; //  here we are create properties object
	
	public Testbase(){
		try{
				 prop=new Properties();
				 File file = new File(Testbase.class.getClassLoader().getResource("config.properties").getPath());//find and get path of config.properties file(C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\target\\classes\\config.properties) 
			     FileInputStream fis=new FileInputStream(file);
			     prop.load(fis);//store path of same config.properties1 file
			    // System.out.println(prop.getProperty("Browsername"));
		}
	
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void waitUntilPageLoads(WebDriver webDriver, int timeOut) {
 		WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		});

}
}
