package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataRead {
	
	@Test
	public void GetDataExcel() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\Books.xlsx");
	
		XSSFWorkbook wb = new XSSFWorkbook(fis); //Open excel sheet 
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		
		XSSFRow row = sheet.getRow(4);
		int colnum = row.getLastCellNum();
		
		XSSFCell cell = row.getCell(1);
		
		System.out.println(cell);
		
		System.out.println(rowcount);
		
		System.out.println(colnum);
		 
		for(int i=0; i<colnum;i++)
		{
			 
			XSSFRow row1 = sheet.getRow(2);
			
			XSSFCell cell1 =row1.getCell(i);
			System.out.println(cell1);
		}
		 int k=sheet.getLastRowNum();
		for(int i=1;i<=k;i++)
		{
			XSSFRow row2=sheet.getRow(i);
			
			for(int j=0;j<colnum;j++)
			{
				XSSFCell cell2 =row2.getCell(j);
				System.out.println(cell2);
			}
		}
		
	}

}
