package ios.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosChrome {
	static WebDriver driver;
	static MutableCapabilities capabilities = new MutableCapabilities();
	static HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	static String username = "";
	static String accesskey = "";
	
	public static final String URL = "https://" + username + ":" + accesskey + "@hub-cloud.browserstack.com/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException {
		browserstackOptions.put("platformName", "ios");
		browserstackOptions.put("osVersion", "14.0");
		browserstackOptions.put("browserName", "safari");
		browserstackOptions.put("deviceName", "iPhone 13");
		browserstackOptions.put("realMobile", "true");
		
		capabilities.setCapability("bstack:options", browserstackOptions);
		driver = new RemoteWebDriver(new URL(URL),capabilities);
		driver.get("https://www.saucedemo.com/");
		System.out.println("title before login "+ driver.getTitle());
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button ")).click();
		System.out.println("title after login"+ driver.getTitle());

		driver.quit();
	}

}
