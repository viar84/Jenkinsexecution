package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	
	public String getDataFromExcelFile(String sheetName,int rowNo,int celNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\ExcelInputData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		Sheet sht = wbook.getSheet(sheetName);
		Row  row = sht.getRow(rowNo);
		Cell cel = row.getCell(celNo);
		DataFormatter formatt = new DataFormatter();
		String strValue = formatt.formatCellValue(cel);
		return strValue;
	}

}
