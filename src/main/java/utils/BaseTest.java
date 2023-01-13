package utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends Driver {

	public WebDriver driver;
	public BasePage app;

	@Parameters({"browser", "url"})
	@BeforeClass(alwaysRun=true)
	public void setup(String browser, String url) throws MalformedURLException {
		
		driver = initDriver(browser);
		driver.get(url);
		
		app = new BasePage(driver);

	}

	@AfterClass(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.quit();
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus() ) {
			
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture =  poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				Files.copy(picture, new File("screenshots/"+result.getName()+"-"+ timeStamp+ ".png"));
				System.out.println("Picture saved");
			} catch (IOException e) {
				System.out.println("Picture could not be saved");
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
