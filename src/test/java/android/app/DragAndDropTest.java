package android.app;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import util.AndroidBase;
import util.Global;

import static java.util.Collections.singletonList;

public class DragAndDropTest extends AndroidBase {

	@Test
	public void test() throws MalformedURLException {
		
		//click on drag menu
		getDriver().findElement(AppiumBy.accessibilityId("Drag")).click(); 
		
		dragAndDrop("drag-l1","drop-l1");
		/*dragAndDrop("drag-l2","drop-l2");
		dragAndDrop("drag-l3","drop-l3");
		dragAndDrop("drag-c1","drop-c1");
		dragAndDrop("drag-c2","drop-c2");
		dragAndDrop("drag-c3","drop-c3");
		dragAndDrop("drag-r1","drop-r1");
		dragAndDrop("drag-r2","drop-r2");
		dragAndDrop("drag-r3","drop-r3");*/
	}
	
	private void dragAndDrop(String dragAid, String dropAid) {
		WebElement source = getDriver().findElement(AppiumBy.accessibilityId(dragAid));
		Point sourceLocation = getElementCenter(source); //get center pointer for source
		 
		WebElement destination = getDriver().findElement(AppiumBy.accessibilityId(dropAid));
		Point destinationLocation = getElementCenter(destination); //get center pointer for destination
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "mouse");
		Sequence dragSeq = new Sequence(finger, 1);
		
		dragSeq.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
				sourceLocation.x, sourceLocation.y)); 
		dragSeq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		dragSeq.addAction(new Pause(finger, Duration.ofMillis(1000)));
		dragSeq.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),
				destinationLocation.x, destinationLocation.y)); 
		dragSeq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		getDriver().perform(singletonList(dragSeq));
	}
	
	

}
