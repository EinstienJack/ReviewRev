package com.reviewrev.april;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.loginPage;
import pages.signupPage;
import utlilities.commonMethods;

public class loginPageTest extends baseFile{
	
	loginPage log;
	signupPage sign;
	
	
	@BeforeMethod
	public void setup() {
		intialize();
		log = new loginPage();	
		sign = new signupPage();
	}
	
	@Test
	public void loginTest() {	
		String url = prop.getProperty("qaURL");		
		driver.get(url);
		commonMethods.pageLoadWait();
		String usrName = "01noccqa0704@yopmail.com";
		String pass = "test";
		boolean rememChk = false;		
		log.login(usrName, pass, rememChk);		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Builder - ReviewRev";		
		assertTrue("Login Fail", actualPageTitle.contains(expectedPageTitle));
	}
	
	
	@Test
	public void creatProjectTest() {
		String url = prop.getProperty("qaURL");	
		int numberofProject = 10;
		
		for (int i= 0; i<numberofProject; i++) {
		driver.get(url);
		commonMethods.pageLoadWait();		
		sign = log.navigateCreateAccount();		
		String urlval= "";		
		if (driver.getCurrentUrl().contains("my.qa")) {urlval = "_qarev";}
		else if (driver.getCurrentUrl().contains("mystaging")) {urlval = "_stagrev";}
		else if (driver.getCurrentUrl().contains("my")) {urlval = "_prodrev";}
		else {urlval = "_invalid";}		
		
		String emailValue = commonMethods.getDateTime()+urlval+"@yopmail.com";
		String passwordValue = "test";
		String phonenumber = Long.toString(commonMethods.generateID());		
		sign.creatProject(emailValue, passwordValue , phonenumber);			
		} 
		
		driver.close();
	}
	
	
	@AfterTest 
	public void Test() {
		driver.quit();
	}

}
