package com.reviewrev.april;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.loginPage;
import utlilities.commonMethods;

public class connectSocialAccountTest extends baseFile {

	loginPage log;
	
	@BeforeTest
	public void setup() {
		intialize();
		log = new loginPage();
		
	}
	
	@Test
	public void verifySocialAccountConnect() {		
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
	
}
