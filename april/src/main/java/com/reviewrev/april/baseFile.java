package com.reviewrev.april;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class baseFile {

	public static Properties prop;
	public static WebDriver driver;
	public static Actions act;
	
		public baseFile() {		
			prop = new Properties();			
			try {
				FileInputStream fl = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\properties\\object.properties");
				prop.load(fl);
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			} catch (IOException e) {			
				e.printStackTrace();
			}		
		}
		
		public static void intialize() {			
			String browerName = prop.getProperty("browser");
			if (browerName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				driver.quit();
				System.out.println("Invalid Browser");
			}	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			act = new Actions(driver);
		}	
}
