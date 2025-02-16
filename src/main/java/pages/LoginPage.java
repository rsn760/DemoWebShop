package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Web elements
	@FindBy(id = "Email") public WebElement email$;
	@FindBy(name = "Password") public WebElement pwd$;
	@FindBy(id = "RememberMe") public WebElement remMe_check$;
	@FindBy(xpath = "//a[text()='Forgot password?']") public WebElement forgot_pwd$;
	@FindBy(xpath = "//*[@value='Log in']") public WebElement login_btn$;
	@FindBy(xpath = "//*[@class='validation-summary-errors']") public WebElement error$;
	
	
	//actions
	public void login(String email, String password) {
		email$.sendKeys(email);
		pwd$.sendKeys(password);
		login_btn$.click();
	}

}
