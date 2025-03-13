package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import util.AndroidBase;


public class Login {
	
	public static By loginMenu=AppiumBy.accessibilityId("Login");

	public static void openLoginMenu() {
		AndroidBase.getDriver().findElement(loginMenu).click();
	}
	
	public static void signUp() {
		
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("button-sign-up-container")).click();
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("input-email")).sendKeys("shiv@gmail.com");
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("input-password")).sendKeys("test1234");
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("input-repeat-password")).sendKeys("test1234");
		AndroidBase.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@text='SIGN UP']")).click();
		String alertTitle = AndroidBase.getDriver().findElement(AppiumBy.id("android:id/alertTitle")).getText();
		String alertMessage = AndroidBase.getDriver().findElement(AppiumBy.id("android:id/message")).getText();
		AndroidBase.getDriver().findElement(AppiumBy.id("android:id/button1")).click();
		assertEquals("alert Title Verification failed", "Signed Up!", alertTitle);
		assertEquals("alert message Verification failed", "You successfully signed up!", alertMessage);
	}

}
