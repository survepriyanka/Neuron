package com.neuron.qa.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Configuration {
	private static WebDriver webDriver;
	private static Properties properties;
	
	public Configuration() 
	{
		// TODO Auto-generated constructor stub
		Configuration.properties = new Properties();
		this.readProperties();
	}

	private void readProperties() {
		try {
			Configuration.properties
					.load(Configuration.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	private boolean isValidURL(String urlString) {
//		try {
//			URL url = new URL(urlString);
//			url.toURI();
//			return true;
//		} catch (URISyntaxException | MalformedURLException e) {
//			// TODO Auto-generated catch block
//			return false;
//		}
//	}
//	public boolean isBrowserOpened() {
//		return Configuration.webDriver != null;
//	}
	
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		boolean isHeadLess = Configuration.properties.getProperty("isHeadLess", "false").equalsIgnoreCase("true");
		boolean isDevToolsOpen = Configuration.properties.getProperty("isDevToolsOpen", "false")
				.equalsIgnoreCase("true");
		System.out.println("start-maximized");
		options.addArguments("start-maximized");
		if (isHeadLess) {
			System.out.println("--headless");
			options.addArguments("--headless");
		}
		if (isDevToolsOpen) {
			System.out.println("auto-open-devtools-for-tabs");
			options.addArguments("auto-open-devtools-for-tabs");
		}
		System.out.println(options.toString());
		return options;
	}
	public WebDriver openBrowser() 
	{

		String operatingSystem = this.getOS();  //invoked getOS() method to check system OS
		String browser = Configuration.properties.getProperty("browser");  //takes from config properties
		String url = Configuration.properties.getProperty("url", "");  //takes from config properties
		String driverPath = Configuration.properties.getProperty(operatingSystem + "DriverPath", null);  //takes from config properties    ..why pass null value
		System.out.println("driverpath is "+ driverPath);
		//Integer timeOut = new Integer(Configuration.properties.getProperty("timeout", "10")); //
		
		System.out.println(operatingSystem);
		System.out.println("==============");
		System.out.println(browser);
		System.out.println("==============");
		System.out.println(url);			
		System.out.println("=============="); //TAKEN FROM CONFIG.PROPERTIES FILE (SOURCES)

		if (browser != null && driverPath != null) {
			System.setProperty("webdriver." + browser.toLowerCase() + ".driver",
					Configuration.class.getClassLoader().getResource(driverPath).getFile()); //getfile():  file is getting from resources(driver chrome.exe file)
		//	Configuration.webDriver = browser.equalsIgnoreCase("FireFox") ? new FirefoxDriver()
					//: new ChromeDriver(this.getChromeOptions());

		}
		WebDriver driver = new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	
	}
	public String getOS() //what
	{
		String operatingSystem = System.getProperty("os.name").toLowerCase();
		return (operatingSystem.indexOf("win") >= 0 ? "Windows"
				: operatingSystem.indexOf("mac") >= 0 ? "Mac"
						: operatingSystem.indexOf("sunos") >= 0 ? "Solaris" : "Linux");//check system OS
	}

	public void waitUntilPageLoads(int timeOut) {
		WebDriverWait wait = new WebDriverWait(Configuration.webDriver, timeOut);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		});
	}

	public void waitUntil(int timeOut, ExpectedCondition<Boolean> condition) {
		WebDriverWait wait = new WebDriverWait(Configuration.webDriver, timeOut);
		wait.until(condition);
	}

	public String getURL() {
		return Configuration.properties.getProperty("url");
	}

	public String getProperty(String key) {
		return Configuration.properties.getProperty(key);
	}
	
}
