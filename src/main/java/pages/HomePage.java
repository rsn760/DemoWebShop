package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText = "Log in") public WebElement login$;
	@FindBy(linkText = "Register") public WebElement register$;
	@FindBy(partialLinkText = "Shopping cart") public WebElement cart$;
	@FindBy(partialLinkText = "Wishlist") public WebElement wishlist$;
	@FindBy(xpath = "//*[@href='/customer/info']") public WebElement my_account$;
	@FindBy(id = "small-searchterms") public WebElement searchBar$;
	@FindBy(xpath = "//input[@value='Search']") public WebElement searchBtn$;
	@FindBy(xpath = "//*[@id='ui-id-1']/li") public List<WebElement> searchq$;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement item(String item_name) {
		return driver.findElement(By.linkText(item_name));	
	}
	
	public void search_item (String item_name) {
		searchBar$.sendKeys(item_name);
		for (WebElement ele$ : searchq$) {
			String item_title = ele$.getText();
			if(item_title.equalsIgnoreCase(item_name)) {
				ele$.click();
			}
		}
	}
	

}
