package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.reviewrev.april.baseFile;

import utlilities.commonMethods;

public class socialAccountPage extends baseFile {
	
	@FindBy (xpath= "//div[@networkid='1051']//button[@id='btnLogin']")
	WebElement facebookConnect;	

	@FindBy (xpath= "//div[@networkid='29154']//button[@id='btnLogin']")
	WebElement googleReviewConnect;
	
	
	public socialAccountPage() {		
		PageFactory.initElements(driver, this);
	}	
	public void connectFacebook() {			
		
		js.executeScript("document.getElementsByClassName('module-loader no-bg active')[0].style.display = 'none';");
		js.executeScript("document.getElementsByClassName('upgrade-btn btn')[0].style.display = 'none';");
		wait.until(ExpectedConditions.invisibilityOf(googleReviewConnect));
		facebookConnect.click();	
		commonMethods.pageLoadWait();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testmopro1@gmail.com");
		
		
		
	}

}
