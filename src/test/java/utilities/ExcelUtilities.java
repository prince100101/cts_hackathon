package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	static XSSFWorkbook wb;
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException 
	{
		FileInputStream fi=new FileInputStream(xlfile);
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
}
