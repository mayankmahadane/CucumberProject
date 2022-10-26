package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utils.CommonUtils;


public class SignUpPage{
	WebDriver driver;
	
	Wait<WebDriver> wait;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#/register']")
	private WebElement SignUpLink;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement buttonSignUp;
	
	@FindBy(xpath = "/html/body/div/app-header/nav/div/ul[2]/li[4]/a")
	private WebElement signedUpUser;
	
	
	public void clickSignUpLink() {
		SignUpLink.click();
	}
	
	public void enterUsername(String value) {
		userName.sendKeys(value);
	}
	
	public void enterEmail(String value) {
		email.sendKeys(value);
	}
	
	public void enterPassword(String value) {
		password.sendKeys(value);
	}
	
	public void submitSignUpForm() throws Exception{
		buttonSignUp.click();
		Thread.sleep(5000);
	}
	
	public String getSignedUsername() {
		CommonUtils.waitForElementToBeVisible(driver, signedUpUser);
				
		return signedUpUser.getText();
	}
	
	public void clickUsernameHyperlink() {
		CommonUtils.waitForElementToBeClickable(driver, signedUpUser);
		
		signedUpUser.click();
	}
}
