package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;
public class DesiredCapabilitiesTest {
	public static void main(String[] args) {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(caps);
		 GoogleSearchPageObjects GooglePageObj = new GoogleSearchPageObjects(driver);
			driver.get("https://google.co.in");
			GooglePageObj.enterText("Guru99");
			GooglePageObj.searchButton();
	}

}
