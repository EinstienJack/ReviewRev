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
	WebElement fbConnect;
	
	@FindBy (xpath= "//div[@networkid='29154']//button[@id='btnLogin']")
	WebElement googlereviewsConnect;
	
	
	public socialAccountPage() {		
		PageFactory.initElements(driver, this);
	}	
	
	
	
	public void connectFacebook(String Emailid, String Password, String FBpage)  {
		
		// User already connected
		//Invalid FB login 
		//FB not a business page
		//Business Page given was not valid or not exist 
		
		String loginValue = Emailid;
		String passwordValue = Password;
		String page= FBpage;
		
		js.executeScript("document.getElementsByClassName('module-loader no-bg')[0].style.display = 'none';");
		commonMethods.pageLoadWait();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(fbConnect));		
		act.moveToElement(fbConnect).click().build().perform();
		
		
		String MainWindow = driver.getWindowHandle();
		
		for (String activeHandle : driver.getWindowHandles()) {
			
			if (!activeHandle.equals(MainWindow)) {
				driver.switchTo().window(activeHandle);
			}
		}
		
		wait.until(ExpectedConditions.titleContains("Facebook"));

		driver.findElement(By.cssSelector("#email")).sendKeys(loginValue);
		driver.findElement(By.cssSelector("#pass")).sendKeys(passwordValue);
		driver.findElement(By.cssSelector("#u_0_0")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='nextBtn']")));		
		driver.findElement(By.xpath("//button[@data-testid='nextBtn']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='nextBtn']")));		
		driver.findElement(By.xpath("//button[@data-testid='nextBtn']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='nextBtn']")));		
		driver.findElement(By.xpath("//button[@data-testid='nextBtn']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='nextBtn']")));		
		driver.findElement(By.xpath("//button[@data-testid='nextBtn']")).click();
		
		driver.switchTo().window(MainWindow);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
		
		WebElement selectFBpage = driver.findElement(By.xpath("//div[@class='col-xs-6 margin-30' and contains(@title , '"+page+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(selectFBpage));
		
		act.moveToElement(selectFBpage).click().build().perform();
		driver.findElement(By.id("idSaveButton")).click();		
		
        wait.until(ExpectedConditions.attributeContains(fbConnect, "display", "none"));
	}

}
