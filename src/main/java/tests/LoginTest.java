package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MenuPage;
import pages.MyAccountPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest {

	@Parameters({"user", "pass"})
	@Test(priority =1)
	public void validLoginTest(String user, String pass) {
		
		MenuPage menu =  new MenuPage(driver);
		MyAccountPage myAccount = new MyAccountPage(driver);
		
		menu.click(menu.myAccountLink);
		myAccount.loginInApp(user, pass);
		boolean successLogin = myAccount.loginMsgIsDisplayed(myAccount.usernameGreetings);
		assertTrue(successLogin);
		myAccount.click(myAccount.logoutButton);
		
	}
	@Parameters({"invalidUser", "invalidPass"})
	@Test(priority =2)
	public void invalidLoginTest(String user, String pass) {
		
		MenuPage menu =  new MenuPage(driver);
		MyAccountPage myAccount = new MyAccountPage(driver);
		
		menu.click(menu.myAccountLink);
		myAccount.loginInApp(user, pass);
		boolean errorLogin = myAccount.loginMsgIsDisplayed(myAccount.loginErrorMsg);
		assertTrue(errorLogin);
		
	}
	
}
