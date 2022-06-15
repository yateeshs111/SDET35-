package practiceTopic;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileRead {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./TestFolder/data driven.xlsx");
		
		//Open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);

		//Control of the Sheet
		Sheet sheet = book.getSheet("Sheet1");
	
		//control of the Row
		Row row = sheet.getRow(2);
		
		//Control of the Cell
		Cell cell = row.getCell(0);
		
		//Get the Required data from excel sheet
		String data = cell.getStringCellValue();
		
		//Display the data fetched
		System.out.println(data);
		
		//close the workbook
		
		book.close();
	
	}
}
