package pageobjects;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class BasePage {
	WebDriver driver;
	JavascriptExecutor js; 
	Actions actions;
	WebDriverWait wait;
	int time = 5;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	}
	public void fillText (WebElement el, String text) {
		highlightElement(el, "lightblue");
		el.clear();
		el.sendKeys(text);
	}
	public void sleep (long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}
	public void waitFor(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	public boolean scrollIntoView(WebElement el) {
		try {
			js.executeScript("arguments[0].scrollIntoView({block: \"center\"});", el);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void click(WebElement el) {
		highlightElement(el, "yellow");
		el.click();
	}
	public void assertEquals (String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	public void assertEquals (int actual, int expected) {
		Assert.assertEquals(actual, expected);
	}
	private void highlightElement(WebElement element, String color) {
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 3px solid blue; background-color:" + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);", element);
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + originalStyle + "');},200);", element);
	}
}
