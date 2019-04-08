package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reviewrev.april.baseFile;

public class homePage extends baseFile{
	
	@FindBy (id= "lnkNotifyHub")
	WebElement notificationIcon;
	
	@FindBy (id= "imgProfile")
	WebElement profileIcon;
	
	@FindBy (linkText= "Business Settings")
	WebElement businessSettings;
	
	@FindBy (linkText= "My Profile")
	WebElement myProfile;
	
	@FindBy (linkText= "Log Out")
	WebElement logOut;
	
	@FindBy (xpath= "//a[@data-title='Connect Social Accounts']")
	WebElement connectSocialTile;
	
	@FindBy (xpath= "//a[@data-title='Social Calendar']")
	WebElement socialCalendarTile;
	
	@FindBy (xpath= "//a[@data-title='Competition Tracker']")
	WebElement competitionTrackerTile;
	
	@FindBy (xpath= "//a[@data-title='Get 5 Star reviews']")
	WebElement get5starReviewsTile;
	
	@FindBy (xpath= "//a[@data-title='Reputation Manager']")
	WebElement reputationManagerTile;
	
	@FindBy (xpath= "//a[@data-title='Your Customers']")
	WebElement customersTile;
	
	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void notificationScreen() {
		act.moveToElement(notificationIcon).click();		
	}
	
	public void navigateBusinessSetting() {
		act.moveToElement(profileIcon);
		act.moveToElement(businessSettings);
		act.click().build().perform();
	}
	
	public void navigateMyProfile() {
		act.moveToElement(profileIcon);
		act.moveToElement(myProfile);
		act.click().build().perform();
	}
	
	public void navigateLogout() {
		act.moveToElement(profileIcon);
		act.moveToElement(logOut);
		act.click().build().perform();
	}
	
	public void navigateconnectSocialTile() {
		connectSocialTile.click();		
	}
}
