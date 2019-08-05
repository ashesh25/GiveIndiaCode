package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class ExtentReportWithTestNG {
	WebDriver driver = null;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extent;	
	
	@BeforeSuite
	public void setUp() {
		extentHtmlReporter = new ExtentHtmlReporter("exten.html");
		extent = new ExtentReports();
		extent.attachReporter(extentHtmlReporter);
	}
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1() throws IOException {
		ExtentTest test1 = extent.createTest("First Test Case","Google Search");
		 test1.info("Test Case Started");
		 GoogleSearchPageObjects GooglePageObj = new GoogleSearchPageObjects(driver);
			driver.get("https://google.co.in");
			test1.addScreenCaptureFromPath("Screenshot1.png");
			test1.info("Google Home Page Loaded");
			GooglePageObj.enterText("Guru99");
			test1.addScreenCaptureFromPath("Screenshot2.png");
			test1.info("Searched Guru 99");
			GooglePageObj.searchButton();
			test1.addScreenCaptureFromPath("Screenshot3.png");
			test1.info("Clicked on Search Button");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	public void test2() throws IOException {
		ExtentTest test1 = extent.createTest("Second Test Case","Google Search");
		 test1.info("Test Case Started");
		 GoogleSearchPageObjects GooglePageObj = new GoogleSearchPageObjects(driver);
			driver.get("https://google.co.in");
			test1.addScreenCaptureFromPath("Screenshot4.png");
			test1.info("addScreenCaptureFromPath Home Page Loaded");
			GooglePageObj.enterText("JavaTPoint");
			test1.addScreenCaptureFromPath("Screenshot5.png");
			test1.info("Searched Guru 99");
			GooglePageObj.searchButton();
			test1.addScreenCaptureFromPath("Screenshot6.png");
			test1.info("Clicked addScreenCaptureFromPath Search Button");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	} 
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
