package tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MenuPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class SearchBookTest extends BaseTest {
	

	@Parameters({"book"})
	@Test(priority=1)
	public void searchBook(String book) throws MalformedURLException {
		MenuPage menu = new MenuPage(driver);
		app.menu.click(app.menu.searchButton);
		app.menu.sendKeys(app.menu.searchField, book);
		menu.waitForElementToBeVisible(app.menu.popupResultsArea);
		menu.click(menu.searchResult("The Wicked King"));
		
		
		assertEquals(app.bookPage.categoryTag.getText(), "New releases");		
		assertEquals(app.bookPage.productId.getText(), "1709");
		
		//System.out.println(app.bookPage.substringPicturesNameFromUrl());
		assertEquals(app.bookPage.substringPicturesNameFromUrl().get(0), "TheWickedKing1.png");
		assertEquals(app.bookPage.substringPicturesNameFromUrl().get(1), "TheWickedKing2.png");
		assertEquals(app.bookPage.substringPicturesNameFromUrl().get(2), "TheWickedKing3.png");
		assertEquals(app.bookPage.substringPicturesNameFromUrl().get(3), "TheWickedKing4.png");
	}
}
