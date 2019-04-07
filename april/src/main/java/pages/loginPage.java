package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.reviewrev.april.baseFile;

public class loginPage extends baseFile {

	@FindBy (how = How.XPATH, using = "//input[@id='txtUsername']")
	WebElement emailField;
	
	@FindBy (id="txtPassword")
	WebElement passwordField;
	
	@FindBy (id="cbRememberme")
	WebElement rememberMeCheckBox;
	
	@FindBy (id="aPasswordRecovery")
	WebElement forgotPasswordURL;
	
	@FindBy(id="btnLoginSubmit")
	WebElement loginCTA;
	
	@FindBy(id="ancSignup")
	WebElement creatAccountURL;
	
	
	
	
	public loginPage() {		
		PageFactory.initElements(driver, this);		
	}
	
	public void login (String username, String password, boolean remember_me) {		
		String value1 = username	;
		String value2 = password;
		boolean value3 = remember_me;		
		emailField.sendKeys(value1);
		passwordField.sendKeys(value2);
		if (value3) {
			rememberMeCheckBox.click();
		}
		loginCTA.click();
	}
	
	public signupPage navigateCreateAccount() {		
		creatAccountURL.click();
		return new signupPage();
	}

}
