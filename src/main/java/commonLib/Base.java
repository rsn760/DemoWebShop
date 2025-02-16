package commonLib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	protected WebDriver driver;
	
	public Base(String browser) throws Exception {
		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
		
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		default:
			throw new Exception("Browser undefined");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public WebDriver get_driver() {
		return driver;
	}
 
	public void sleep() throws Exception {
		Thread.sleep(3000);
	}
	
	public void get_current_url() {
		driver.getCurrentUrl();
	}
	
}
