package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BookPage extends SeleniumWrappers {

	public BookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[@class='posted_in']/a") public WebElement categoryTag;
	@FindBy (xpath="//span[@class='product_id']/span") public WebElement productId;
	
	@FindBy(xpath="//div[@class='woocommerce-product-gallery__image']/a") public List <WebElement> galleryListElements;
	
	public List <String> substringPicturesNameFromUrl() throws MalformedURLException {
		
		List<String> galleryLabelsList = new ArrayList<String>();
		for(WebElement element:galleryListElements) {
				String url = element.getAttribute("href");	
			
				URL u = new URL(url);
				String[] arr = url.split(u.getAuthority());			
				
				String[] parts =arr[1].split("\\/");
				String pictureName = parts[5]; 
				galleryLabelsList.add(pictureName);				
					
		}
		Collections.sort(galleryLabelsList);
		return galleryLabelsList;
		
		
	}
	
	
	
	

}
