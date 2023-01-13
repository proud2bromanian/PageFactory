package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MenuPage extends SeleniumWrappers {

	//public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	//public By myAccountLink = By.linkText("My account");
	@FindBy(linkText = "My account") public WebElement myAccountLink;
	
	@FindBy(css="div[class*='top_panel_icon'] button[type='submit']") public WebElement searchButton;
	
	@FindBy(css="div[class*='top_panel_icon'] input[class='search_field']") public WebElement searchField;
	
	//@FindBy(css="h6 a[href='https://keybooks.ro/shop/the-wicked-king/']") public WebElement popupSearchedBook;
	
	@FindBy(xpath="//div[contains(@class ,'widget_area')][contains(@style, 'display: block;')]") public WebElement popupResultsArea;
	public  WebElement searchResult(String searchedBook) {
		
		
		return driver.findElement(By.xpath("//h6/a[contains(text(),'" +searchedBook  + "')]"));
	}
}
