package utils;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest {

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//WebElement element =  driver.findElement(locator);
	//element.click();
	
	
	public void sendEnter() {
		
		try {
			Log.info("calling method <sendEnter>");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			
		}catch(Exception e) {
			Log.error(e.getMessage());
		}
		
	}
	
	public List<WebElement> getWebElementList(By locator){	
		return driver.findElements(locator);
		
	}
	
	
/*	public WebElement getWebElement(By locator) {
		waitForElementToBeVisible(locator);
		return driver.findElement(locator);
	}
		*/
	
	public void dragAndDrop(WebElement element, int x, int y) {
		
		try {
			Actions action =  new Actions(driver);
		//	action.dragAndDropBy(element, x, y).perform();	
			action.clickAndHold(element).moveByOffset(x, y).release().perform();
						
		}catch(NoSuchElementException e) {
			new TestException(e.getMessage());	
		}
		
	}
	
	

	public void hoverElement(WebElement element) {
	try {
		//WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}catch(NoSuchElementException e) {
		new TestException(e.getMessage());
	}
		
	}
	
	
	
	
	/**
	 * Custom click method, that waits for element to be clickable before triggering click
	 * @param locator --> webelement locator
	 */
	public void click(WebElement element) {
		
		try {
			waitForElementToBeClickable(element);
			//WebElement element =  driver.findElement(locator);
			Log.info("called method <Click()> on element :" + element.getAttribute("outerHTML"));
			element.click();
		//	getWebElement(locator).click();
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <Click> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
			
		}catch (StaleElementReferenceException e) {
			waitForElementToBeClickable(element);
			//WebElement element =  driver.findElement(locator);
			Log.info("called method <Click()> on element :" + element.getAttribute("outerHTML"));
			element.click();		}
		
	}
	
	
	public void waitForElementToBeClickable(WebElement element) {
		try {
			Log.info("Called method <waitForElementToBeClickable> on element with locator :" + element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToBeClickable> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		try {
			Log.info("Called method <waitForElementToBeVisible> on element with locator :" + element);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));	
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToBeVisible> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public boolean checkElementIsDisplayed(By locator) {
		
		 return driver.findElement(locator).isDisplayed();
	}
	
	
	public void sendKeys(WebElement element, String textToBeSend) {
		try {
			
			waitForElementToBeVisible(element);
			//WebElement element  = driver.findElement(locator);
			Log.info("called clear on method <sendkeys> on element " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("called sendkeys on method <sendkeys> on element " + element.getAttribute("outerHTML"));
			element.sendKeys(textToBeSend);
			
		}catch(NoSuchElementException e) {
			Log.error("Failed method <sendKeys> with error " + e.getMessage());
			throw new TestException(e.getMessage());

		}
		
		
	}
	
	

}
