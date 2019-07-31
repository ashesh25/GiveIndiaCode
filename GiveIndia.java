package test;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GiveIndia {
	
	private static WebDriver driver= null;
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Selenium");
		WebElement externalLinks = driver.findElement(By.xpath("(//span[contains(text(),'External links')])[2]"));
		if(externalLinks.isDisplayed()) {
			System.out.println("External Links is displayed");
		}
		else
			System.out.println("External link is not available");
			driver.findElement(By.xpath("(//a[@title='Oxygen'])[2]")).click();
			
		WebElement oxygenHeader = driver.findElement(By.xpath("//h1[contains(text(),'Oxygen')]"));
		if(oxygenHeader.isDisplayed()) {
			System.out.println("Clicked on Oxygen Link");
			WebElement featuredArticle = driver.findElement(By.xpath("//img[@alt='This is a featured article. Click here for more information.']"));
			if(featuredArticle.isDisplayed()) {
				System.out.println("Oxygen is a Featured Article");
			}
			else 
				System.out.println("Oxygen is not a featured article");
			
			WebElement propertyTable = driver.findElement(By.xpath("//table[@class='infobox']"));
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage  fullImg = ImageIO.read(screenshotFile);
			Point point = propertyTable.getLocation();
			int propertyTableWidth = propertyTable.getSize().getWidth();
			int propertyTableHeight = propertyTable.getSize().getHeight();
			
			try {
			BufferedImage propertyTableScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
					propertyTableWidth, propertyTableHeight);
			ImageIO.write(propertyTableScreenshot, "png", screenshotFile);
			}
			catch(RasterFormatException e) {
				System.out.println("Height is outside Raster");
			}
				
			
			
			 FileUtils.copyFile(screenshotFile, new File("Screenshot.png"));
			 
			 List pdfLinks = driver.findElements(By.xpath("//cite[@class='citation book']/following::span[contains(text(),'(PDF)')]"));
			 System.out.println("Number of PDF Links : "+pdfLinks.size());
			 
			 driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Pluto");
			 
			for(int i=0;i<2;i++) {
				 driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.ARROW_DOWN);
				 
			}
			 driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.ENTER);
			 WebElement plutoniumHeader = driver.findElement(By.xpath("//h1[contains(text(),'Plutonium')]"));
			 if(plutoniumHeader.isDisplayed()) {
				 System.out.println("Pltonium is the 2nd suggestion");
			 }
			 else
				 System.out.println("Pltonium is not the 2nd suggestion");
			}
		else
			System.out.println("Didn't click on oxygen link");
		
	}

}
