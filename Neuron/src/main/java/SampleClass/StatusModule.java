package SampleClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StatusModule {
 
	static WebDriver webdriver = null;
	
	
	public void AddStatus() throws InterruptedException 
	{
		WebElement ResearchReportTab=webdriver.findElement(By.xpath("//span[text()='Research Report']"));
		ResearchReportTab.click();
		Thread.sleep(2000);
		
		WebElement MasterTab=webdriver.findElement(By.xpath("//span[text()='RR Masters']"));
		MasterTab.click();
		Thread.sleep(2000);
		
		WebElement statustab=webdriver.findElement(By.xpath("//span[text()='Status']"));
		statustab.click();
		Thread.sleep(7000);
		
		
		WebElement addStatus=webdriver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		addStatus.click();
		Thread.sleep(4000);
		
		WebElement statusName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='status_name']"));
		statusName.sendKeys("uququq");
		Thread.sleep(2000);
		
		WebElement slugName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='slug']"));
		slugName.sendKeys("pending");
		Thread.sleep(2000);
		
		Select sc=new Select(webdriver.findElement(By.xpath("//select[@ng-reflect-name='is_book_action']")));
		Thread.sleep(2000);
		sc.selectByVisibleText("No");
		
		WebElement addbutton=webdriver.findElement(By.xpath("//span[text()='Add']"));
		addbutton.click();
		Thread.sleep(4000);
	}	
		
	
	public void EditStatus() throws InterruptedException 
	{
		WebElement editbutton=webdriver.findElement(By.xpath("//button[@title='Edit']"));
		editbutton.click();
		
	
		WebElement statusName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='status_name']"));
		statusName.clear();
		statusName.sendKeys("zqzqzq");
		
		Thread.sleep(2000);
		
		WebElement slugName=webdriver.findElement(By.xpath("//input[@ng-reflect-name='slug']"));
		slugName.clear();
		slugName.sendKeys("hold");
		
		Thread.sleep(2000);
		
		WebElement bookactiondropdown= webdriver.findElement(By.xpath("//select[@ng-reflect-name='is_book_action']"));
		Select sc=new Select(bookactiondropdown);
		Thread.sleep(2000);
		sc.selectByVisibleText("Yes");
		Thread.sleep(3000);
		
		WebElement updatebutton=webdriver.findElement(By.xpath("//span[text()='Update']"));
		updatebutton.click();
		Thread.sleep(3000);
//		statusName.toString();
//		slugName.toString();
	WebElement liststatusholder=webdriver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
	String listStatus=liststatusholder.getText();
	System.out.println(listStatus);
	String statusupdate="zqzqzq";
	
	if(listStatus.equalsIgnoreCase(statusupdate))
	{
		System.out.println("data is match");
	}
	else
		System.out.println("data is not match");	
		
	}



	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\OtherDoc\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		Thread.sleep(5000);
		webdriver.get("http://neuronbeta.choicetechlab.com/");
		Thread.sleep(2000);
		
		WebElement username = webdriver.findElement(By.xpath("//input[@id='Username']"));
		username.sendKeys("priyanka.surve@choicetechlab.com");
		
		WebElement password = webdriver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("Choice@123");
		
		WebElement loginbutton = webdriver.findElement(By.xpath("//button[text()='Login']"));
		loginbutton.click();
		Thread.sleep(8000);
		
		StatusModule statusmodule=new StatusModule();
		statusmodule.AddStatus();
		statusmodule.EditStatus();
	}

	}
