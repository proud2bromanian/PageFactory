package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShots {
	
	public void screenshot(WebDriver driver) {
		
		TakesScreenshot poza = (TakesScreenshot)driver;
		File picture= poza.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(picture, new File("screenshots/screen.png"));
		} catch (IOException e) {
			System.out.println("Picture could not be saved!");	
			e.printStackTrace();
		}
		
		
	}
	

}
