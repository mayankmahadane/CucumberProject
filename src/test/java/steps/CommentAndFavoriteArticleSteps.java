package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CommentAndFavoritePage;
import utils.BaseClass;

public class CommentAndFavoriteArticleSteps extends BaseClass{
	CommentAndFavoritePage commentAndFavoritePage;
	
	
	public CommentAndFavoriteArticleSteps() {
		commentAndFavoritePage = new CommentAndFavoritePage(driver);
	}
	
	@And("Click Global Feed Tab on Homepage")
	public void clickGlobalFeedTab() {
		commentAndFavoritePage.clickGlobalFeedTab();
	}
	
	@When("Click title of first shown feed")
	public void clickFirstFeedTitle() {
		commentAndFavoritePage.clickFirstFeedTitle();
		commentAndFavoritePage.verifyArticleIsOpenedForComments();
	}
	
	@And("Add and Post Comment")
	public void addAndPostComment() throws Exception{
		commentAndFavoritePage.addCommentsInCommentBox("Mayank has added his comments to the activity post");
		commentAndFavoritePage.clickPostCommentButton();
	}
}
