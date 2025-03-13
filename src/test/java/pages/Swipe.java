package pages;
import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import util.AndroidBase;
public class Swipe {
	
	public static By swipeMenu=AppiumBy.accessibilityId("Swipe");

	
	public static void swipeMenu() {
		AndroidBase.getDriver().findElement(swipeMenu).click();
	}
	
	public static void verifySwipe() {
		AndroidBase.getDriver().findElement(AppiumBy.accessibilityId("Swipe")).click(); // clear
		WebElement source = AndroidBase.getDriver().findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[1]"));
		System.out.println(source.getText());
		Point sourceLocation = source.getLocation(); // getting the location of first card

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "mouse"); // fixed set of code for any app

		System.out.println("x cordinate for card" + sourceLocation.x);
		Sequence swipSeq = new Sequence(finger, 0);

		swipSeq.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
				sourceLocation.x, sourceLocation.y)); // moving to first card
		swipSeq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipSeq.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
				sourceLocation.x - (sourceLocation.x * 5), sourceLocation.y));
		swipSeq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		swipSeq.addAction(new Pause(finger, Duration.ofMillis(1000)));
		AndroidBase.getDriver().perform(List.of(swipSeq));
		WebElement newSource = AndroidBase.getDriver()
				.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[1]"));
		System.out.println(newSource.getText());
	}

}
