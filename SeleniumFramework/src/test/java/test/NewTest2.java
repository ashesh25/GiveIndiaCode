package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class NewTest2 {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void pre() {
		System.out.println("Hi there");
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	}
	
  @Test
  public void f2() {
	  System.out.println("Hello");
	
	  GoogleSearchPageObjects GooglePageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://google.co.in");
		GooglePageObj.enterText("Guru99");
		GooglePageObj.searchButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
  
  @AfterTest
  public void post() {
	driver.close();  
  }
}
