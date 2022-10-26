package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PostArticlePage;
import utils.BaseClass;
import utils.RandomDataGenerator;

public class PostArticleSteps extends BaseClass {
	PostArticlePage postArticlePage;
	String title = "MayankArticle"+RandomDataGenerator.getUniqueUserName();
	
	public PostArticleSteps() {
		postArticlePage = new PostArticlePage(driver);
	}

	@And("Click on New Article Hyperlink from header")
	public void clickNewArticleHyperLink() throws Exception{
		postArticlePage.clickNewArticleHyperlink();
		Thread.sleep(3000);
	}
	
    @When("Fill all required details and Submit Article")
    public void fillAllRequiredDetails() throws Exception{
    	postArticlePage.enterArticleTitle(title);
    	postArticlePage.enterArticleAbout("Demo Project Assignment");
    	postArticlePage.enterArticleText("This is a demo assignment to create new article");
    	postArticlePage.enterArticleTag("QA Requirement");
    	postArticlePage.clickPublishArticleButton();   	
	}
    
    @Then("Verify that Article is submitted successfully")
    public void verifyArticleSubmitted() {
		Assert.assertEquals( postArticlePage.getPublishedArticleTitle(), title);
	}
}