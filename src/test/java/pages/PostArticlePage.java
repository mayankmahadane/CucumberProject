package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class PostArticlePage {
	WebDriver driver;
	
	public PostArticlePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#/editor/']")
	private WebElement newArticleHeaderHyperlink;
	
	@FindBy(xpath = "//input[@placeholder='Article Title']")
	private WebElement articleTitle;
	
	@FindBy(xpath = "//input[@ng-model='$ctrl.article.description']")
	private WebElement articleAbout;
	
	@FindBy(xpath = "//textarea[@ng-model='$ctrl.article.body']")
	private WebElement articleText;
	
	@FindBy(xpath = "//input[@ng-model='$ctrl.tagField']")
	private WebElement articleTag;
	
	@FindBy(xpath = "//button[@ng-click='$ctrl.submit()']")
	private WebElement buttonPublishArticle;
	
	@FindBy(xpath = "//h1[@ng-bind=\"::$ctrl.article.title\"]")
	private WebElement publishedArticleTitle;
	
	public void enterArticleTitle(String value) {
		articleTitle.sendKeys(value);
	}
	
	public void enterArticleAbout(String value) {
		articleAbout.sendKeys(value);
	}
	
	public void enterArticleText(String value) {
		articleText.sendKeys(value);
	}
	
	public void enterArticleTag(String value) {
		articleTag.sendKeys(value);
	}
	
	public void clickPublishArticleButton() throws Exception{
		buttonPublishArticle.click();
		CommonUtils.waitForElementToBeInvisible(driver, buttonPublishArticle);
		CommonUtils.waitForElementToBeVisible(driver, publishedArticleTitle);
	}
	
	public void clickNewArticleHyperlink(){
		newArticleHeaderHyperlink.click();
	}
	
	public String getPublishedArticleTitle() {
		return publishedArticleTitle.getText();
	}
}
