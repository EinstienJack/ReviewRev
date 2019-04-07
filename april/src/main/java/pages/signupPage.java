package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reviewrev.april.baseFile;

public class signupPage extends baseFile {
	
	@FindBy (id= "txtUsername")
	WebElement emailField;
	
	@FindBy (id="txtPassword")
	WebElement passwordField;
	
	@FindBy (id="txtReEnterPassword")
	WebElement confirmpasswordField;
	
	@FindBy (id="txtPhoneNumber")
	WebElement phonenumberField;
	
	@FindBy (id="btnSignUp")
	WebElement createAccountCTA;
	
	
	public signupPage() {		
		PageFactory.initElements(driver, this);
	}	
	
	public void creatProject(String email, String password, String phonenumber) {
		String value1 = email;
		String value2 = password;
		String value3 = phonenumber;
		System.out.println(value1);
		emailField.sendKeys(value1);
		passwordField.sendKeys(value2);
		confirmpasswordField.sendKeys(value2);
		phonenumberField.sendKeys(value3);
		createAccountCTA.click();
	}

}
