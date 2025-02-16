package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLib.ExtentListener;
import commonLib.GetExcel;

public class EmailFriend_Tests extends BaseTest{
	
	@DataProvider
	public Object[][] itemsData(Method method) throws Exception {
		return new GetExcel().get_xl_data("src/test/resources/testData/RFunctional_testData.xlsx", method.getName());
	}
	
	@Test(dataProvider = "itemsData")
	public void email_friend_tests (String title, String itemName, String frndEmail, String msg) throws InterruptedException {
		System.out.println(">> "+title +"-" + itemName);
		
		homePage.login$.click();
		
		loginPage.login(prop.get_property("email"), prop.get_property("password"));
		
		assertTrue(homePage.my_account$.isDisplayed(), "User doesn't login");
		
		homePage.search_item(itemName);
		
		assertTrue(itemPage.item_path$.isDisplayed(), "Item path is not visible.");
		assertTrue(itemPage.item_name$.isDisplayed(), "Item name is not visible.");
		
		itemPage.email_a_frnd$.click();
		Thread.sleep(4000);
	}

}
