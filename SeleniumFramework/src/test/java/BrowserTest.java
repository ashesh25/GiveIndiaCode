import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
public static void main(String[] args) {
	String projectPath = System.getProperty("user.dir");
	System.out.println("ProjectPath: "+projectPath);
	//System.setProperty("webdriver.chrome.driver",projectPath+"\\Drivers\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	//FirefoxDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.seleniumhq.org");
}
}
