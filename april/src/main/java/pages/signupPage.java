package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reviewrev.april.baseFile;

public class signupPage extends baseFile {
	
	@FindBy (id= "txtFirstName")
	WebElement firstNameField;
	
	@FindBy (id= "txtLastName")
	WebElement lastNameField;
	
	@FindBy (id="txtPhoneNumber")
	WebElement phonenumberField;
	
	@FindBy (id= "txtUsername")
	WebElement emailField;
	
	@FindBy (id="txtPassword")
	WebElement passwordField;
	
	@FindBy (id="txtReEnterPassword")
	WebElement confirmpasswordField;	
	
	@FindBy (id="btnSignUp")
	WebElement createAccountCTA;	
	
	@FindBy (xpath="//a[@tabindex='8']")
	WebElement loginLink;
	
	public signupPage() {		
		PageFactory.initElements(driver, this);
	}	
	
	public void creatProject(String fName, String lName, String phonenumber, String email, String password) {
		String value1 =fName;
		String value2 =lName;
		String value3 = phonenumber;
		String value4 = email;
		String value5 = password;
		
		firstNameField.sendKeys(value1);
		lastNameField.sendKeys(value2);
		phonenumberField.sendKeys(value3);
		emailField.sendKeys(value4);
		passwordField.sendKeys(value5);
		confirmpasswordField.sendKeys(value5);		
		createAccountCTA.click();
	}

}