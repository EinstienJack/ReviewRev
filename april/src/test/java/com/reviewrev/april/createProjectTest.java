package com.reviewrev.april;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.loginPage;
import pages.signupPage;
import utlilities.excelUtility;

public class createProjectTest extends baseFile {
	
	loginPage log;
	signupPage sign;	
	
	@BeforeMethod
	public void setup() {
		intialize();
		log = new loginPage();	
		sign = new signupPage();
	}	
	
	@Test (enabled=false)
	public void creatProject() {
		String url = prop.getProperty("qaURL");
		driver.get(url);
		sign = log.navigateCreateAccount();	
		String data[] = sign.creatProject("FristName1","LastName1","9840321456","qarev16may04@yopmail.com","test");
		System.out.println(data [0]);	
		System.out.println(data [1]);	
		driver.close();
	}
	
	
	@Test (enabled=true)
	public void creatProjectFromExcel() {
		String url = prop.getProperty("qaURL");
		excelUtility.ShName = "CreateProject";		
		Sheet sh = excelUtility.readExcel();
		int lastRow = sh.getLastRowNum();
		
		for (int i=1; i<=lastRow; i++) {		
			String check = excelUtility.getvalue(i, 5);				
			if (check==null || check.length()==0) {				
			String a = excelUtility.getvalue(i, 0).toString(); 
			String b = excelUtility.getvalue(i, 1).toString();
			String c = excelUtility.getvalue(i, 2).toString();
			String d = excelUtility.getvalue(i, 3).toString();
			String e = excelUtility.getvalue(i, 4).toString();				
			driver.get(url);
			sign = log.navigateCreateAccount();				
			String data[] = sign.creatProject(a,b,c,d,e);				
			excelUtility.setvalue(data[0], data[1], data[2], i);
			driver.manage().deleteAllCookies();			
			} 
		}driver.close();	
	}
	
	@AfterTest 
	public void Test() {
		driver.quit();
	}
	
}