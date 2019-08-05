package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	private static WebElement element;
		
	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='q']"));
		return element;
	}
	
	
	

}
