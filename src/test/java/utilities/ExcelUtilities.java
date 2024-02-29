package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	static XSSFWorkbook wb;
	
	public static String getCellData(String xlsheet, int rownum, int colnum) throws IOException 
	{
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\testData"+"\\testData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		XSSFRow row=ws.getRow(rownum);
		XSSFCell cell=row.getCell(colnum);
	
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            wb.close();
    		fi.close();
            return data;
            
		}
		catch (Exception e) {
			data="";
		}
		
		return data;
	}
	
	public static void writeExcel(String dataToWrite) throws IOException {
		FileInputStream fileInput = new FileInputStream((System.getProperty("user.dir") + "\\testData\\testOutput.xlsx"));  
		XSSFWorkbook wb = new XSSFWorkbook(fileInput);    
		XSSFSheet sheet = wb.getSheetAt(0); 
		  
		XSSFRow newRow = sheet.createRow(1);     
		
		newRow.createCell(0).setCellValue(dataToWrite);  
			
		FileOutputStream fileOutput = new FileOutputStream((System.getProperty("user.dir") + "\\testData\\testOutput.xlsx")); 
		wb.write(fileOutput);     
		fileOutput.close(); 
		wb.close();      
		fileInput.close();  
		}
	
	public static void writeExcel(ArrayList<String> dataToWrite, String sheetName, int row,int col) throws IOException {
		FileInputStream fileInput = new FileInputStream((System.getProperty("user.dir") + "\\testData\\testOutput.xlsx"));  
		XSSFWorkbook wb = new XSSFWorkbook(fileInput);    
		if(wb.getSheetIndex(sheetName)==-1) {
			wb.createSheet(sheetName);
		}
		XSSFSheet sheet = wb.getSheet(sheetName);  
		
		for(String s: dataToWrite) {
			XSSFRow newRow = sheet.getRow(row++);  
			if(newRow==null) {
				newRow = sheet.createRow(row++);
			}
			newRow.createCell(col).setCellValue(s);  
		}
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		
		FileOutputStream fileOutput = new FileOutputStream((System.getProperty("user.dir") + "\\testData\\testOutput.xlsx")); 
		wb.write(fileOutput);     
		fileOutput.close(); 
		wb.close();      
		fileInput.close();  
		}
}
