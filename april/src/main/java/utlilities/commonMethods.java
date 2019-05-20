package utlilities;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.reviewrev.april.baseFile;

public class commonMethods extends baseFile {
	
	static JavascriptExecutor js;
	
	
	public static void pageLoadWait() {	
		js = (JavascriptExecutor)driver;
		js.executeScript("return document.readyState").equals("complete");		
	}
	
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("ddMM_HHmmss");
		Date date = new Date();
		String formateddate = dateFormat.format(date); 
		return formateddate;
	}
	
	public static long generateID() { 
	    Random rnd = new Random();
	    char [] digits = new char[11];
	    digits[0] = (char) (rnd.nextInt(9) + '1');
	    for(int i=1; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	public static String captureScreenShot(){		    
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	
		String path = "C:\\Users\\Einstien\\git\\ReviewRev\\april\\screenshot\\screenshot"+System.currentTimeMillis()+".png";
		try {		 
		FileUtils.copyFile(src, new File(path));  
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	public static void connectDatabase() throws ClassNotFoundException, SQLException {		
		String dbUrl = "jdbc:mysql://localhost:3306/reviewrev";
		String username = "root";			
		String password = "happyjack";			
		String query = "select *  from user;";
		Class.forName("com.mysql.jdbc.Driver");			
        
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

		// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String emailId = rs.getString(1);								        
                    String pasword = rs.getString(2);
                    String phoneNumber = rs.getString(3);
                    String accontStatus = rs.getString(4);
                    String createdDate = rs.getString(5);
                    System. out.println(emailId +"  "+pasword );		
            }		
			 // closing DB Connection		
			con.close();			
		
	}

}
