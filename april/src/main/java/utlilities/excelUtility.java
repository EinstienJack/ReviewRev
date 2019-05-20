package utlilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reviewrev.april.baseFile;

public class excelUtility extends baseFile{	
	
	public static Workbook workbook;
	public static Sheet sheet;
	public static String ShName;
	static FileInputStream ips;
	static FileOutputStream ops;
	static Cell cell = null;
	static File fl = new File(prop.getProperty("exceldata"));
	
	public static Sheet readExcel() {			
		try {
			ips = new FileInputStream(fl);
			workbook = new XSSFWorkbook(ips);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();		
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		sheet = workbook.getSheet(ShName);	
		return sheet;
	}
	
	public static String getvalue(int rowNumber, int cellNumber) {	
		Sheet sh =  readExcel();
		int rowNo = rowNumber ;
		int cellNo = cellNumber ;					
		Row row = sh.getRow(rowNo);
		String value;
		if (row.getCell(cellNo)!= null) {	value = row.getCell(cellNo).toString(); }
		else {value = null;}
		return value;
		}	
	
	public static void setvalue(String cellValue1,String cellValue2, String cellValue3, int rowNumber) {		
		Sheet sh =  readExcel();
		int rowNo = rowNumber ;			
		String value1 = cellValue1 ;
		String value2 = cellValue2 ;	
		String value3 = cellValue3;
		cell = sh.getRow(rowNo).createCell(5);
		cell.setCellValue(value1);
		cell = sh.getRow(rowNo).createCell(6);
		cell.setCellValue(value2);
		cell = sh.getRow(rowNo).createCell(7);
		cell.setCellValue(value3);	
		try {
			ips.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		writeExcel();
		}	
	
	public static void writeExcel() {		
		try {
			ops = new FileOutputStream(fl);
			workbook.write(ops);
			ops.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();		
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
}