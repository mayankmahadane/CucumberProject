package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class SignInSignOutPage {
	WebDriver driver;
	
	
	public SignInSignOutPage(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#/login']")
	private WebElement signInLink;	
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement buttonSignIn;
	
	@FindBy(xpath = "(//a[@href='#/settings'])[2]")
	private WebElement editProfileSettingsButton;
	
	@FindBy(xpath = "//button[@class = 'btn btn-outline-danger' and @ng-click = '$ctrl.logout()']")
	private WebElement buttonLogOut;
	
	
	public boolean signInHyperLinkVisible() {
		return signInLink.isDisplayed();
	}
	
	public void clickSignInLink() {
		signInLink.click();
	}
	
	public void clickSignInButton() {
		buttonSignIn.click();
	}
	
	public void clickEditProfileSettingsButton() throws Exception{
		CommonUtils.waitForElementToBeVisible(driver, editProfileSettingsButton);
	
		editProfileSettingsButton.click();
	}
	
	public void clickButtonLogOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		CommonUtils.waitForElementToBeClickable(driver, buttonLogOut);
		CommonUtils.scrollToElement(driver, buttonLogOut);
		buttonLogOut.click();
	}
	
	public void verifySignInHyperlinkIsVisible(){
		CommonUtils.waitForElementToBeVisible(driver, signInLink);
	}
}
