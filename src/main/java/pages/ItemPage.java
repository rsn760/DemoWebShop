package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
	WebDriver driver;
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Web elements
	@FindBy(xpath = "//*[@class='breadcrumb']/ul") public WebElement item_path$;
	@FindBy(xpath = "//*[@itemprop='name']") public WebElement item_name$;
	@FindBy(xpath = "//*[@itemprop='image']") public WebElement item_image$;
	@FindBy(xpath = "//*[@class='short-description']") public WebElement short_desc$;
	@FindBy(xpath = "//*[@class='stock']") public WebElement availability$;
	@FindBy(xpath = "//*[text()='Add your review']") public WebElement add_review$;
	@FindBy(xpath = "//*[@itemprop='price']") public WebElement item_price$;
	@FindBy(xpath = "//*[@class='qty-input']") public WebElement item_qty$;
	@FindBy(xpath = "//*[@value='Add to cart']") public WebElement add_to_cart$;
	@FindBy(xpath = "//*[@value='Add to wishlist']") public WebElement add_to_wishlist$;
	@FindBy(xpath = "//*[@value='Email a friend']") public WebElement email_a_frnd$;
	@FindBy(xpath = "//*[@value='Add to compare list']") public WebElement add_to_compList$;
	@FindBy(id = "product_attribute_71_9_15") public WebElement material$;
	@FindBy(xpath = "//*[@class='option-list']/li") public WebElement pendant$; 
	@FindBy(xpath = "//*[@class='recipient-name']") public WebElement recipientName$;
	@FindBy(xpath = "//*[@class='recipient-email']") public WebElement recipientEmail$;
	@FindBy(xpath = "//*[@class='sender-name']") public WebElement senderName$;
	@FindBy(xpath = "//*[@class='sender-email']") public WebElement senderEmail$;
	@FindBy(xpath = "//*[@class='message']") public WebElement message$;
	@FindBy(xpath = "//*[text()='Download sample']") public WebElement dwnld_sam$;
	@FindBy(id = "product_attribute_5_7_1") public WebElement size$;
	
	public WebElement color(String color) {
		return driver.findElement(By.xpath("//*[@title='"+color+"']"));
	}
	
	
	//actions
	

}
