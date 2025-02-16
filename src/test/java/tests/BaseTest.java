package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonLib.Base;
import commonLib.ExtentListener;
import commonLib.GetProperties;
import commonLib.Utilities;
import pages.EmailFriend_Page;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;


public class BaseTest {
	WebDriver driver;
	GetProperties prop;
	
	//pages
	Utilities utils;
	LoginPage loginPage;
	HomePage homePage;
	ItemPage itemPage;
	EmailFriend_Page emailPage;

	@BeforeMethod
	@Parameters({ "browser"})
	public void setup(@Optional("chrome") String browser) throws Exception {
		driver = new Base(browser).get_driver();
		
		utils = new Utilities(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		itemPage = new ItemPage(driver);
		emailPage = new EmailFriend_Page(driver);
		
		prop = new GetProperties("src/test/resources/properties/config.properties");
		driver.get(prop.get_property("url"));
		
	}

	@AfterMethod
	public void tear_down() {
		if (driver != null) {
			driver.quit();
		}
	}

}
