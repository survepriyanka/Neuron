package com.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XLSreader 
{
	 static WebDriver webdriver;
	 static WebElement username;
	 static WebElement password;
	
	public List<Map<String,String>> datareader() throws Exception
	{
		List<Map<String,String>> list= new ArrayList();
		
		File src=new File("C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\src\\main\\java\\com\\testdata\\NRlogindata2.csv");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("logindata");
//	    String data=sh.getRow(0).getCell(0).getStringCellValue();
//	    System.out.println("data is"+ data);
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			Map<String,String> map = new HashMap<String, String>();
			XSSFRow rw=sh.getRow(i);
			XSSFCell UN=rw.getCell(0);
			XSSFCell PWD=rw.getCell(1);
			String uname = UN == null ? null:UN.toString();
			String pass = PWD==null? null:PWD.toString();
			map.put("username", uname);
			map.put("password", pass);
			list.add(map);
//			System.out.println(UN);
//			System.out.println(PWD);				
		}	    
		return list;	}
}
