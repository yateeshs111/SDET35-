package practiceTopic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileWrite 
{

	public static void main(String[] args) throws Throwable, Throwable 
	{
FileInputStream fis = new FileInputStream("./TestFolder/data driven.xlsx");
		
		//Open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);

		//Control of the Sheet
		Sheet sheet = book.getSheet("Sheet1");
	
		//control of the Row
		Row row = sheet.getRow(2);
		
		//control of the cell
		Cell cell = row.createCell(6);
		
		cell.setCellValue("AnyThing");
		
		//Write the data in the cell
		FileOutputStream fout = new FileOutputStream("./TestFolder/data driven.xlsx");
		
		book.write(fout);
		
		//Close the workbook
		book.close();
		
	}

}
