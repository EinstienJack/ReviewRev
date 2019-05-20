package com.reviewrev.april;

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
	
	@Test (enabled=false) // Need to update the URL
	public void loginTest() {	
		String url = prop.getProperty("qaURL");		
		driver.get(url);
		commonMethods.pageLoadWait();		
	}	
	
	@AfterTest 
	public void Test() {
		driver.quit();
	}

}