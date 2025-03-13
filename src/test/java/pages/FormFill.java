package pages;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import util.AndroidBase;

public class FormFill {

	public static By formFillMenu=AppiumBy.accessibilityId("Forms");

	public static void openFormFillMenu() {
		AndroidBase.getDriver().findElement(formFillMenu).click();
	}
	
	public static void fillCompleteForm() {
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("Forms")).click();
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("text-input")).sendKeys("training");
		String enteredText = AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("input-text-result")).getText();
		System.out.println(enteredText);
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("switch")).click();
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("Dropdown")).click();
		AndroidBase.getDriver().findElement(AppiumBy.xpath(
				"//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"webgetDriver().io is awesome\"]"))
				.click();
		String actualText = AndroidBase.getDriver().findElements(AppiumBy.className("android.widget.EditText")).get(1).getText();
		assertEquals("selected option mismatch", "webgetDriver().io is awesome", actualText);
	}
}
