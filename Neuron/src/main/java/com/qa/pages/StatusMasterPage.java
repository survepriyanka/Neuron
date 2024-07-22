package com.qa.pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class StatusMasterPage 
{
    @Test
	public List<Map<String, String>> ReadStatusData() throws IOException, CsvException 
	{
		List<Map<String,String>> list= new ArrayList();
		String spath="C:\\Users\\surve\\OneDrive\\Desktop\\NEURON\\Neuron\\src\\main\\java\\com\\testdata\\NeuronStatusMaster.csv";
		  CSVReader reader = new CSVReader(new FileReader(spath) );
		    List<String[]>val=reader.readAll();
	    
	    for(int i=1;i<val.size();i++)
	    {
	    	Map<String,String> map = new HashMap<String, String>();
	    	String name=val.get(i)[0];  //store 1st row username(of csv file) in string username
	    	String slug=val.get(i)[1];  //store 1st row password(of csv file) in string password
	    	String statusName=name;          //after store value in string username,it assigned to string uname
	    	String statusSlug=slug;          //after store value in string password,it assigned to string pword
	    	map.put("name", statusName);     
			map.put("slug", statusSlug);
			list.add(map);
	    	
	    	
	    }
	   
		return list;
		}
	    
	 

	

}
