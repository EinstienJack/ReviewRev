package com.reviewrev.april;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.homePage;
import pages.loginPage;
import utlilities.commonMethods;

public class connectSocialAccountTest extends baseFile {

	loginPage log;
	homePage home;
	
	@BeforeTest
	public void setup() {
		intialize();
		log = new loginPage();
		home = new homePage();
		
	}
	
	@Test
	public void verifySocialAccountConnect() {		
		String url = prop.getProperty("qaURL");		
		driver.get(url);		
		String usrName = "01noccqa0704@yopmail.com";
		String pass = "test";
		boolean rememChk = false;		
		log.login(usrName, pass, rememChk);		
		commonMethods.pageLoadWait();
		home.navigateconnectSocialTile();
		
		
	}
	
}
