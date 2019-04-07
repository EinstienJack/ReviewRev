package utlilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;

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

}
