package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriend_Page {
	
	WebDriver driver;
	
	public EmailFriend_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	// Web elements
	@FindBy(xpath = "//*[@class='page-title']/h1") public WebElement pageTitle$;
	@FindBy(xpath = "//*[@for='FriendEmail']") public WebElement friendEmailLabel$;
	@FindBy(id = "FriendEmail") public WebElement friendEmailInput$;
	@FindBy(xpath = "//*[@for='YourEmailAddress']") public WebElement yourEmailLabel$;
	@FindBy(id = "YourEmailAddress") public WebElement yourEmailInput$;
	@FindBy(xpath = "//*[@for='PersonalMessage']") public WebElement personalMessageLabel$;
	@FindBy(id = "PersonalMessage") public WebElement personalMessageInput$;
	@FindBy(name = "send-email") public WebElement sendEmailBtn$;
	@FindBy(xpath = "//*[@data-valmsg-for='FriendEmail']") public WebElement friendEmailErrMsg$;
	@FindBy(xpath = "//*[@class='page email-a-friend-page']//div[@class='result']") public WebElement emailSentMsg$;
	
	public void fill_email_form (CharSequence frndEmail, String userEmail, String msg) {
		friendEmailInput$.sendKeys(frndEmail);
		assertEquals(yourEmailInput$.getAttribute("value"), userEmail, "Your Email input field is not containing account email");
		personalMessageInput$.sendKeys(msg);
		sendEmailBtn$.click();
	}
}
