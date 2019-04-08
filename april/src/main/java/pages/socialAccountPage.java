package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reviewrev.april.baseFile;

public class socialAccountPage extends baseFile {
	
	@FindBy (xpath= "//div[@networkid='1051']//button[@id='btnLogin']")
	WebElement facebookConnect;
	
	
	
	public socialAccountPage() {		
		PageFactory.initElements(driver, this);
	}	
	public void connectFacebook() {
	
		
	}

}
