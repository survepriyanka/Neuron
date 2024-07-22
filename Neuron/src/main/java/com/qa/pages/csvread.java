package com.qa.pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class csvread {

	public List<Map<String, String>> readcsvdata() throws IOException, CsvException 
	{
		List<Map<String,String>> list= new ArrayList();
		String path="C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\src\\main\\java\\com\\testdata\\NeuronDataSet.csv";
	    CSVReader reader = new CSVReader(new FileReader(path) );
	    List<String[]>val=reader.readAll();
	    
	    for(int i=1;i<val.size();i++)
	    {
	    	Map<String,String> map = new HashMap<String, String>();
	    	String username=val.get(i)[0];  //store 1st row username(of csv file) in string username
	    	String password=val.get(i)[1];  //store 1st row password(of csv file) in string password
	    	String uname=username;          //after store value in string username,it assigned to string uname
	    	String pword=password;          //after store value in string password,it assigned to string pword
	    	map.put("username", uname);     
			map.put("password", pword);
			list.add(map);
	    	
	    	
	    }
	   
		return list;
		}
	    
	    
	}
	


