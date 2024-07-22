package com.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.ErrorManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

public class Demo {

	static WebDriver webdriver = null;

	public static void main(String[] args) throws IOException, CsvException, InterruptedException
	{			
//		csvread rd=new csvread();
//		rd.readcsvdata();
//		List<Map<String, String>> data = rd.readcsvdata();
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\OtherDoc\\chromedriver_win32\\chromedriver.exe");
//		WebDriver webdriver = new ChromeDriver();
//		webdriver.get("http://neuronbeta.choicetechlab.com/");
//		
//		for (Map<String, String> map : data) 
//		{
//
//			LoginPageLocators LoginPageLocators = new LoginPageLocators();
//			LoginPageLocators.uname(webdriver, map.get("username"));
//			LoginPageLocators.passwd(webdriver, map.get("password"));
//			try {
//				String dashpage="https://neuronbeta.choicetechlab.com/dashboard";
//				String dpage= webdriver.getCurrentUrl();
//				System.out.println(dpage);
//				
//				if (dpage.equals(dashpage))
//				{
//					LoginPageLocators.logoutclick(webdriver);
//				
//			}
//				LoginPageLocators.loginclick(webdriver);
//				LoginPageLocators.logoutclick(webdriver);
//				
//			} catch (Exception e) 
//			{
//				
//			}	
//		}			
		try
		{
		
		StatusMasterPage statusmasterpage=new StatusMasterPage();
		statusmasterpage.ReadStatusData();
		List<Map<String, String>> data = statusmasterpage.ReadStatusData();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\OtherDoc\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.get("http://neuronbeta.choicetechlab.com/");
		
		Thread.sleep(2000);
		
		WebElement username = webdriver.findElement(By.xpath("//input[@id='Username']"));
		username.sendKeys("priyanka.surve@choicetechlab.com");
		
		WebElement password = webdriver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("Choice@123");
		
		WebElement loginbutton = webdriver.findElement(By.xpath("//button[text()='Login']"));
		loginbutton.click();
		Thread.sleep(8000);
		
		LoginPageLocators lpl= new LoginPageLocators();
		lpl.ResearchReportTab(webdriver);
		lpl.RRmasterTab(webdriver);
		lpl.Statusmastertab(webdriver);
		lpl.addStatusbutton(webdriver);		
		
		
		
		
		
		for (Map<String, String> map : data) 
			{	
			
				lpl.statusformNameTextField(webdriver, map.get("name"));
				lpl.statusformSlugTextField(webdriver, map.get("slug"));
				lpl.bookActionDropdown(webdriver);
				Thread.sleep(2000);
				lpl.statusFormAddButton(webdriver);
				Thread.sleep(4000);
				
				WebElement statusAddMSG=webdriver.findElement(By.xpath("//div[contains(text(),'Success')]"));
				String addmsg=statusAddMSG.getText();
				String statusAddmessage="Success";
				if(addmsg.equalsIgnoreCase(statusAddmessage))
				{
					Thread.sleep(4000);
					System.out.println(addmsg);
					lpl.addStatusbutton(webdriver);		
				}
			}
		}
				
				catch (Exception e) {
					
				}
				
				//boolean addbutton=false;
				
//				try 
//				{					
//					addbutton=ErrorMessage!=null && ((WebElement) ErrorMessage).isDisplayed();
//		        }
//				catch(Exception e) {
//					addbutton=false;
//		        }		
				
		List<WebElement> errorList = webdriver.findElements(By.xpath("//label[@class='validation-error2']"));
		if(errorList.size()>0) {
			for(int i=0;i<errorList.size();i++) {
				System.out.println(errorList.get(i).getText());
			}
		}
////				WebElement slugInvalidErrormsg=webdriver.findElement(By.xpath("//label[contains(text(),'Slug is invalid')]"));
//				String slugInvalidMessage=slugInvalidErrormsg.getText();
//				
//				WebElement nameInvalidErrormsg=webdriver.findElement(By.xpath("//label[contains(text(),'Name is invalid')]"));
//				String NameInvalidMessage= nameInvalidErrormsg.getText();
//				
//				WebElement nameReqErrormsg= webdriver.findElement(By.xpath("//label[contains(text(),'Name is required')]"));
//				String nameReqmsg=nameReqErrormsg.getText();
//									
//				WebElement nameCharMinErrormsg=webdriver.findElement(By.xpath("//label[contains(text(),'Minimum 3 Characters')]"));
//				String nameCharMinMessage=nameCharMinErrormsg.getText();
//				
//				WebElement nameduplicatemsg=webdriver.findElement(By.xpath("//div[text()=' Invalid request parameter [The status name has already been taken.] ']"));
//				String duplicatemsg=nameduplicatemsg.getText();
//				
//								
//				WebElement mandatoryfield=webdriver.findElement(By.xpath("//span[contains(text(),'*')]"));
//				String mandText=mandatoryfield.getText();
//				
//						
//				String nameRequiredMSG="Name is required";
//				String nameInvalidMSG="Name is invalid";
//				String nameMincharMsg="Minimum 3 Characters";
//				String slugInvalidmsg= "Slug is invalid";
//				String duplicateNameMsg="Invalid request parameter [The status name has already been taken.]";
//			
//				String mandField="*";
//				
//				if(NameInvalidMessage.equalsIgnoreCase(nameInvalidMSG))
//				{
//					System.out.println("1" + NameInvalidMessage);
//					
//				}
//				else if(nameReqmsg.equalsIgnoreCase(nameRequiredMSG))
//				{
//					System.out.println("2"+ nameReqmsg);
//				}
//				else if(slugInvalidMessage.equalsIgnoreCase(slugInvalidmsg))
//				{
//					System.out.println("3"+ slugInvalidMessage);
//				}
//				else if(nameCharMinMessage.equalsIgnoreCase(nameMincharMsg))
//				{
//					System.out.println("slugmsg is :"+nameCharMinMessage);
//				}
//				else if (duplicatemsg.equalsIgnoreCase(duplicateNameMsg)) 
//				{
//					System.out.println("5" + duplicatemsg);
//					
//				}
////				else if(addmsg.equalsIgnoreCase(statusAddmessage))
////				{
////					System.out.println("5" + addmsg);
////					
////					
////				}
////				
////				else if(mandText.equalsIgnoreCase(mandField))
////				{
////					System.out.println(nametxt+ "is mandatory");
////					
////				}			
//				else 
//				{
//				
//					System.out.println("pop");
//				}				
	}
}
			
		
	
			
	
		
	

//	private static void getInvalidRefNumberErrorMessage()
//	{
//		WebElement errorMessage=;
//		return webdriver.findElement(errorMessage).getText().contains("Invalid request parameter [The status name may not be greater than 50 characters.]");
//		
//		
//	}




	


