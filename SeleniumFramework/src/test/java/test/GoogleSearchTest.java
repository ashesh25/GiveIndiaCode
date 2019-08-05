package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	static WebDriver driver = null;
	
	public static void main(String args[]) {
		googleSearch();
	}
	
	public static void googleSearch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.co.in");
		GoogleSearchPage.searchBox(driver).sendKeys("Guru99");
		GoogleSearchPage.searchBox(driver).sendKeys(Keys.ENTER);
	}
}
