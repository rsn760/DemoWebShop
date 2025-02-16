package commonLib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class Utilities {
	static WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public void select_element(List<WebElement> elements$, String ele_text) {
		for (WebElement ele$ : elements$) {
			String ele_name = ele$.getText();
			if (ele_name.equalsIgnoreCase(ele_text)) {
				ele$.click();
				break;
			}
		}
	}
	
	public void select_elements(List<WebElement> elements$, String ele_text) {
		for (WebElement ele$ : elements$) {
			ele$.click();
		}
	}
	
	public List<String> get_elements_text(List<WebElement> elements$) {
		List<String> elements_names = new ArrayList<String>();
		
		for (WebElement ele$ : elements$) {
			String ele_name = ele$.getText();
			elements_names.add(ele_name);
		}
		return elements_names;
	}
	
	public static String take_screenshot(String file_name) throws Exception {
		TakesScreenshot capture = (TakesScreenshot) driver;
		File temp_path = capture.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp_path, new File(file_name));
		return file_name;
	}
	
	public void select_by_text (WebElement select_element, String option_text) {
		Select select = new Select(select_element);
		select.selectByVisibleText(option_text);
	}
	
	public void select_by_value (WebElement select_element, String value) {
		Select select = new Select(select_element);
		select.selectByValue(value);
	}
	
	public void wait_for_element_to_be_visible(WebElement ele$, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(ele$));
	}
	
	public static Map<String, String> get_browser_details() {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		Map<String, String> browser_details = new HashMap<>();
		
		browser_details.put("browserName", caps.getBrowserName());
		browser_details.put("browserVersion", caps.getBrowserVersion());
		return browser_details;
		
	} 

}
