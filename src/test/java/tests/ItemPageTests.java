package tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLib.ExtentListener;
import commonLib.GetExcel;

	

public class ItemPageTests extends BaseTest {
	
	@DataProvider
	public Object[][] itemsData(Method method) throws Exception {
		return new GetExcel().get_xl_data("src/test/resources/testData/RFunctional_testData.xlsx", method.getName());
	}
	
	@Test(dataProvider = "itemsData")
	public void item_page_navigation_tests (String title, String itemName) {
		System.out.println(">> "+title +"-" + itemName);
		
		homePage.login$.click();
		loginPage.login(prop.get_property("email"), prop.get_property("password"));
		ExtentListener.eTest().info("User Login successful");
		
		homePage.search_item(itemName);
		ExtentListener.eTest().info("User searched for '"+itemName+"' item");
		
		assertTrue(itemPage.item_path$.isDisplayed(), "Item path is not visible.");
		assertTrue(itemPage.item_name$.isDisplayed(), "Item name is not visible.");
		ExtentListener.eTest().info("User navigated to '"+itemName+"' page");
	}
	
	@Test(dataProvider = "itemsData")
	public void item_details_visibility_tests (String title, String itemName) {
		System.out.println(">> "+title +"-" + itemName);
		homePage.login$.click();
		loginPage.login(prop.get_property("email"), prop.get_property("password"));
		ExtentListener.eTest().info("User Login successful");
		
		homePage.search_item(itemName);
		ExtentListener.eTest().info("User searched for '"+itemName+"' item");
		
		assertTrue(itemPage.item_name$.isDisplayed(), "Item name is not visible.");
		assertTrue(itemPage.item_image$.isDisplayed(), "item image is not visible.");
		
		assertTrue(itemPage.short_desc$.isDisplayed(), "Item short description is not visible.");
		assertTrue(itemPage.availability$.isDisplayed(), "Item availability is not visible.");
		assertTrue(itemPage.item_price$.isDisplayed(), "Item price is not visible.");
		assertTrue(itemPage.item_qty$.isDisplayed(), "Item quatity is not visible.");
		assertTrue(itemPage.add_to_cart$.isDisplayed(), "Item Add to cart button is not visible.");
		assertTrue(itemPage.add_to_compList$.isDisplayed(), "Item Add to compare list button is not visible.");
		assertTrue(itemPage.add_to_wishlist$.isDisplayed(), "Item Add to wishlist button is not visible.");
		assertTrue(itemPage.add_review$.isDisplayed(), "Item Add review button is not visible.");
		ExtentListener.eTest().info("'"+itemName+"' details are visible");
	}

}
