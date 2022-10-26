package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignInSignOutPage;
import pages.SignUpPage;
import utils.BaseClass;

public class SignInSignOutSteps extends BaseClass {	
	SignUpPage signUpPage;
	SignInSignOutPage signInSignOut;
	
	public SignInSignOutSteps() {
		signUpPage = new SignUpPage(driver);	
		signInSignOut = new SignInSignOutPage(driver);
	}
	
	@Given("Click on Sign In Link")
	public void clickSignInLink() {
		signInSignOut.clickSignInLink();
	}
	
    @When("Enter login details")
    public void fillLoginDetailsAndSubmit() {
    	signUpPage.enterEmail(testData.getProperty("Email"));
    	signUpPage.enterPassword(testData.getProperty("Password"));
    	signInSignOut.clickSignInButton();
    }
    
    @Then("Verify that user is successfully logged in")
    public void verifySuccessfulLogin() {
    	Assert.assertEquals(testData.getProperty("Username"), signUpPage.getSignedUsername());
    }
    
    @Given("Verify that user is signed in and if not then do login")
	public void verifySignedInOrNot() throws Exception{
    	if(signInSignOut.signInHyperLinkVisible()) {
    		signInSignOut.clickSignInLink();
    		signUpPage.enterEmail(testData.getProperty("Email"));
        	signUpPage.enterPassword(testData.getProperty("Password"));
        	signInSignOut.clickSignInButton();
        	Thread.sleep(3000);
    	}
	}
    
    @And("Click on Username hyperlink in header")
    public void clickUsernameHyperlink() throws Exception{
    	signUpPage.clickUsernameHyperlink();
    	Thread.sleep(3000);
    }    
    
    @When("Click Edit Profile Settings")
    public void clickEditProfileSettingsButton() throws Exception{
    	signInSignOut.clickEditProfileSettingsButton();
    }
    
    @And("Click on Log Out button")
    public void clickLogOutButton() {
    	signInSignOut.clickButtonLogOut();
    }
    
    @Then("Verify that user is successfully logged out")
    public void verifySuccessfullLogOut() {
    	signInSignOut.verifySignInHyperlinkIsVisible();
    }

}
