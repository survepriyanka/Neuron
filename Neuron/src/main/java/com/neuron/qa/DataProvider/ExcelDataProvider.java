package com.neuron.qa.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.neuron.qa.base.Testbase;

public class ExcelDataProvider extends Testbase{
	public static long Load_Time = 40;
	public static long Implicit = 40;
	
	public static String TESTDATA_SHEET_PATH;
	// ="E:\\Workspace\\choiceconnecttest\\src\\main\\java\\com\\choiceconnect\\qa\\testdata\\DDT.xls"
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName, String TESTDATA_SHEET_PATH,int SheetNo) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheetAt(SheetNo);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];

		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		// System.out.println(sheet.getLastRowNum()+"---------"+sheet.getRow(0).getLastCellNum());
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(i).getLastCellNum());
			for (int k = 0; k < sheet.getRow(1).getLastCellNum(); k++) {
				try {
					System.out.println(i + "===" + k + "====>" + sheet.getRow(i).getCell(k));
					if (sheet.getRow(i) != null && sheet.getRow(i).getCell(k) != null
							&& sheet.getRow(i).getCell(k).toString() != null && sheet.getRow(i).getCell(k).getCellType() != Cell.CELL_TYPE_BLANK) {
						// System.out.println(i+"==="+k+"====>"+sheet.getRow(i).getCell(k).toString());
						data[i][k] = sheet.getRow(i).getCell(k).toString();
					}else {
						data[i][k] = "";
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
		return data;

	}


}
