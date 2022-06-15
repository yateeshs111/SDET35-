package practiceTopic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReadMultiple 
{

	public static void main(String[] args) throws Throwable, IOException
	{
FileInputStream fis = new FileInputStream("./TestFolder/data driven.xlsx");
		
		//Open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);

		//Control of the Sheet
		Sheet sheet = book.getSheet("Sheet1");
	
		//control of the Row
		int line = sheet.getPhysicalNumberOfRows();
		for(int i =0;i<line;i++)
		{
			Row row = sheet.getRow(i);
			for(int j =0;j<row.getLastCellNum();j++)
			{
			   String data = row.getCell(j).toString();
			   System.out.println(data);
			}
		}
		
		//close the workbook
		
		book.close();
	}
}
