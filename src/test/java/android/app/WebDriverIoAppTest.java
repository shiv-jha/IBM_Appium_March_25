package android.app;

import static org.junit.Assert.*;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.FormFill;
import pages.Login;
import pages.Swipe;
import util.AndroidBase;
import util.Global;

public class WebDriverIoAppTest extends AndroidBase {
	
	@Test
	public void signUpVerification() {
		Login.openLoginMenu();
		Login.signUp();
	}

	@Test
	public void formFillVerification() {
		FormFill.openFormFillMenu();
		FormFill.fillCompleteForm();
	}

	@Test()
	public void swipeVerification() {
		Swipe.swipeMenu();
		Swipe.verifySwipe();
	}
	
	//Read data from excel using Apache poi

}
