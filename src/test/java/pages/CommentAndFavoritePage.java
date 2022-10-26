package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.CommonUtils;

public class CommentAndFavoritePage {
	WebDriver driver;
	String articleTitle = "";
	int currentCountOfComments = 0;
	
	public CommentAndFavoritePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//*[(text() = '   Loading articles... ')]")
	private WebElement loadingArticleMessage;
	
	@FindBy(xpath = "//*[text() = '   No articles are here... yet. ']")
	private WebElement noArticleHereMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Global Feed')]")
	private WebElement globalFeedTab;
	
	@FindBy(xpath = "//h1[@ng-bind = '$ctrl.article.title']")
	private List<WebElement> allShownFeedTitles;
	
	@FindBy(xpath = "//h1[@ng-bind = '::$ctrl.article.title']")
	private WebElement selectedArticleTitleInDetailPage;
	
	@FindBy(xpath = "//*[@placeholder = 'Write a comment...']")
	private WebElement commentTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonPostComment;
	
	@FindBy(xpath = "//p[@class = 'card-text ng-binding']")
	private List<WebElement> availableComments;
	
	public void clickGlobalFeedTab() {
		CommonUtils.waitForElementToBeClickable(driver, globalFeedTab);
		globalFeedTab.click();
		CommonUtils.waitForElementToBeInvisible(driver, loadingArticleMessage);
		CommonUtils.waitForElementToBeInvisible(driver, noArticleHereMessage);
	}
	
	public void clickFirstFeedTitle() {		
		if(allShownFeedTitles.size() == 0)
			Assert.fail("No Feeds are available to show");
		else {
			CommonUtils.waitForElementToBeVisible(driver, allShownFeedTitles.get(0));
			CommonUtils.waitForElementToBeClickable(driver, allShownFeedTitles.get(0));
			articleTitle = allShownFeedTitles.get(0).getText();
			allShownFeedTitles.get(0).click();
			CommonUtils.waitForElementToBeInvisible(driver, allShownFeedTitles.get(0));
			currentCountOfComments = availableComments.size();
		}
	}
	
	public void verifyArticleIsOpenedForComments() {
		CommonUtils.waitForElementToBeVisible(driver, selectedArticleTitleInDetailPage);
		Assert.assertEquals(articleTitle, selectedArticleTitleInDetailPage.getText());
	}
	
	public void addCommentsInCommentBox(String message) {
		commentTextBox.sendKeys(message);
	}
	
	public void clickPostCommentButton() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		buttonPostComment.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		CommonUtils.waitForElementToBeVisible(driver, commentTextBox);
		Assert.assertEquals(++currentCountOfComments, availableComments.size());
	}
}
