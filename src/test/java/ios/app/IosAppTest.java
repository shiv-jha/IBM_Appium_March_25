//package ios.app;
//
//import static org.junit.Assert.*;
//
//import java.net.URL;
//import java.time.Duration;
//import java.util.HashMap;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.ios.IOSDriver;
//import util.Global;
//import util.IosBase;
//
//public class IosAppTest extends IosBase {
//
//	@Test
//	public void testProductNamePriceAndCart() {
//		WebElement product=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"store item\"`][1]"));
//		String productNameandPrice= product.getAttribute("label");
//
//		//Logic to separated product name and price
//		String[] spliteedValue = productNameandPrice.split(" \\$");
//		String productName=spliteedValue[0];
//
//		String productPrice="";
//		String[] productPriceSplitted=spliteedValue[1].split(" ");
//		productPrice="$"+productPriceSplitted[0];
//	
//		//Verify product name 
//		driver.findElement(AppiumBy.accessibilityId("Sauce Labs Backpack")).click();
//		String productNameNextPage=driver.findElement(AppiumBy.accessibilityId("Sauce Labs Backpack")).getAttribute("label");
//		assertEquals("product name mismatch", productName,productNameNextPage);
//		
//		//Verify product price 
//		String productPriceNextPage=driver.findElement(AppiumBy.accessibilityId("product price")).getAttribute("value");
//		assertEquals("product price mismatch", productPrice,productPriceNextPage);
//		
//		//Verify Add to cart functionality
//		driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
//		String cartQty=driver.findElement(AppiumBy.accessibilityId("tab bar option cart")).getAttribute("label");
//		assertEquals("quantity in cart mismatch", "1",cartQty);
//	
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		driver.quit();
//	}
//
//}
