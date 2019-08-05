package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class ExtentHtml {
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Google Search","Searching");
		test1.info("TestCase started");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.co.in");
		test1.pass("Google hom page launched");
		GoogleSearchPage.searchBox(driver).sendKeys("Guru99");
		test1.pass("Searched guru99");
		
		GoogleSearchPage.searchBox(driver).sendKeys(Keys.ENTER);
		test1.pass("Clicked on Search button");
		
		test1.info("Test case completed");
		
		extent.flush();
		
	}

}
