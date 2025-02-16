package tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLib.ExtentListener;
import commonLib.GetExcel;
import commonLib.Utilities;
import pages.HomePage;
import pages.LoginPage;


public class Login_Test extends BaseTest{
	
	@DataProvider
	public Object[][] loginData(Method method) throws Exception {
		return new GetExcel().get_xl_data("src/test/resources/testData/RFunctional_testData.xlsx", method.getName());
	}
	
	@Test(dataProvider = "loginData")
	public void login_tests (String title, String email, String password) throws Exception {
		System.out.println(">> "+title);
		homePage.login$.click();
		loginPage.login(prop.get_property("email"), prop.get_property("password"));
		ExtentListener.eTest().info("User clicked on Login button");
		
		assertTrue(homePage.my_account$.isDisplayed(), "'My Account' is not visible");
		ExtentListener.eTest().info("User login successful");
	}
	

}