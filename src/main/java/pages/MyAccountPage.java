package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers{

	//public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	//public By usernameField = By.id("username");
	
	@FindBy(id = "username")public WebElement usernameField;
	//public By passwordField = By.id("password");	
	@FindBy(id = "password")public WebElement passwordField;

	//public By loginButton = By.cssSelector("button[name='login']");
	@FindBy(css = "button[name='login']")public WebElement loginButton;

	//public By loginErrorMsg = By.cssSelector("ul[class='woocommerce-error'] strong");
	@FindBy(css="ul[class='woocommerce-error'] strong") public WebElement loginErrorMsg;
	
	//public By usernameGreetings = By.cssSelector("div[class='woocommerce-MyAccount-content'] strong");
	@FindBy(css="div[class='woocommerce-MyAccount-content'] strong") public WebElement usernameGreetings;

	//public By logoutButton = By.linkText("Log out");
	@FindBy(linkText ="Log out") public WebElement logoutButton;

	
	public void loginInApp(String user, String pass) {
		sendKeys(usernameField, user);
		sendKeys(passwordField, pass);
		click(loginButton);
	}
	
	public boolean loginMsgIsDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
	
}
