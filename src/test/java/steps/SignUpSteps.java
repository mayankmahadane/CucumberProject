package steps;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;
import utils.BaseClass;
import utils.RandomDataGenerator;

public class SignUpSteps extends BaseClass {
	SignUpPage signUpPage;
	String uniqueNewUsername;
	
	public SignUpSteps() throws Exception{
		signUpPage = new SignUpPage(driver);
		uniqueNewUsername = RandomDataGenerator.getUniqueUserName();
	}
	

	@Given("Click Sign Up button from header")
	public void clickSignUpButton() throws Exception{
		signUpPage.clickSignUpLink();
		Thread.sleep(2000);
	}
	
	@When("Fill Sign Up Form and Submit")
	public void fillSignUpForm() throws Exception{
		signUpPage.enterUsername(uniqueNewUsername);
		signUpPage.enterEmail(uniqueNewUsername+"@gmail.com");
		signUpPage.enterPassword(testData.getProperty("Password"));
		signUpPage.submitSignUpForm();
	}
	
	@Then("Verify that sign up is done successfully")
	public void verifySuccessfullSignUp() {
		Assert.assertEquals(uniqueNewUsername, signUpPage.getSignedUsername());
	}
}
