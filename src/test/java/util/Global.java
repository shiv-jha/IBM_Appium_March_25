package util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Global {
	
	public static String username = "";
	public static String accesskey = "";
	public static final String URL = "https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub";
	//public static final String URL = "http://localhost:4723/wd/hub";

	public static DesiredCapabilities createConfig(String platformType,String AppPath) {
		
		//Read Data from Excel
		//Map<String, String> dataset = ReadData.fecth();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		if(platformType.equals("ios")) {
			capabilities.setCapability("platformName", "ios"); 
			capabilities.setCapability("app",AppPath);
			capabilities.setCapability("project", "Test_project");
			capabilities.setCapability("build", "1.3");
			capabilities.setCapability("appium:platformVersion", "16.0");
			capabilities.setCapability("appium:deviceName", "iPhone 13");
			capabilities.setCapability("bstack:options", bstackOptions);
			
		}
		else {
			
			//launch test in local emulator
			//capabilities.setCapability("appium:appPackage ", "com.wdiodemoapp");
			//capabilities.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
			//capabilities.setCapability("app", "C:\\work\\training_2025\\appium-java-examples\\src\\test\\resources\\app\\webdriverio-app.apk");
			//capabilities.setCapability("appium:deviceName", "emulator-5554");
			
			
			capabilities.setCapability("platformName", "android"); //dataset.get("PlatformName")
			capabilities.setCapability("app", AppPath);
			capabilities.setCapability("project", "Test_project"); //dataset.get("Project")
			capabilities.setCapability("build", "1.5");
			capabilities.setCapability("appium:platformVersion", "12.0");
			capabilities.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
			capabilities.setCapability("bstack:options", bstackOptions);
		}
		return capabilities;
		
	}
	public static Point getElementCenter(WebElement element) {
		 	Point location = element.getLocation();
	        Dimension size = element.getSize();
	        return new Point(location.getX() + (size.getWidth() / 2), location.getY() + (size.getHeight() / 2));
	    }
}


