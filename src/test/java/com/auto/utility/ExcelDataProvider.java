package com.auto.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src = new File("C:\\Users\\ADMIN\\eclipse-workspace\\PractApp\\TestData\\Excel1.xlsx"); 
		
		try {
			FileInputStream fis = new  FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("Excel Data doesnt support" +e.getMessage());
		}		
	}
	
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getIntData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
