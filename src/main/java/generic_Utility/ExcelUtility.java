package generic_Utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @Author Yateesh
 *
 */


public class ExcelUtility 
{
	
	public  String getExceldata(String sheetName, int rowNum,int cellNum) throws Throwable
	{
		
		/**
		 * This method is used to fetch or Read the data from Excel
		 */
		
		FileInputStream fis = new FileInputStream("./TestFolder/data driven.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.toString();
		return data;
	}
	
	public  double getExceldataNumeric(String sheetName, int rowNum,int cellNum) throws Throwable
	{
		
		/**
		 * This method is used to fetch or Read the Numeric data from Excel
		 */
		
		FileInputStream fis = new FileInputStream("./TestFolder/data driven.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		double data = cell.getNumericCellValue();
		return data;
	}
	
	
	
	
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable 
	{
		FileInputStream fis  = new FileInputStream("./TestFolder/data driven.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fout = new FileOutputStream("./TestFolder/data driven.xlsx");
		wb.write(fout);
	
	}
	
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis  = new FileInputStream("./TestFolder/data driven.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();

	}
}
