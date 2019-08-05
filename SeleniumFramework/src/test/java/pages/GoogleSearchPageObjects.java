package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	private WebDriver driver = null;
	
	public GoogleSearchPageObjects(WebDriver driver){
		this.driver = driver;
	}
	
	By searchText = By.xpath("//input[@name='q']");
	
	public void enterText(String text) {
		driver.findElement(searchText).sendKeys(text);
	}
	
	public void searchButton() {
		driver.findElement(searchText).sendKeys(Keys.ENTER);
	}
}
