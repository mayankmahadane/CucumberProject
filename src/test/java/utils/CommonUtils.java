package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonUtils {
	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(ElementClickInterceptedException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}
}
