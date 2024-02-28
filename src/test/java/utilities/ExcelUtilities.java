package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	static XSSFWorkbook wb;
	
	public static String getCellData(String xlsheet, int rownum, int colnum) throws IOException 
	{
		System.out.println(System.getProperty("user.dir")+"\\testData"+"\\testData.xlsx");
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
		FileInputStream fileInput = new FileInputStream((System.getProperty("user.dir") + "\\testData\\testData.xlsx"));  
		XSSFWorkbook wb = new XSSFWorkbook(fileInput);    
		XSSFSheet sheet = wb.getSheetAt(2); 
		  
		XSSFRow newRow = sheet.createRow(1);     
		
		newRow.createCell(0).setCellValue(dataToWrite);  
			
		FileOutputStream fileOutput = new FileOutputStream((System.getProperty("user.dir") + "\\testData\\testData.xlsx")); 
		wb.write(fileOutput);     
		fileOutput.close(); 
		wb.close();      
		fileInput.close();  
		}
}
