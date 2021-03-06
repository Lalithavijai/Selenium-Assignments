package week5.day2.assignment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {

	
	public static String[][] readExcelData(String sheetName) throws InvalidFormatException, IOException {
		
		//Workbook
		File excelFilename=new File("./data/Leads.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(excelFilename);
		
		//Sheet
		XSSFSheet sheet = wbook.getSheet(sheetName);
		
		//Iterate to read
		
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			//Row
			XSSFRow row = sheet.getRow(i);
        for (int j = 0; j < colCount; j++) {
        	//Column cell
        	XSSFCell cell = row.getCell(j);
        	System.out.println(cell.getStringCellValue());
        	data[i-1][j]=cell.getStringCellValue();
        	
	
}
			
			
		}
		wbook.close();
		return data;
		

	}

}
