package util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;

public class IosBase extends Global{
	public static String app_path ="bs://2a69658f881beabc507178073a6db66b64df8002";
	public static IOSDriver driver;

	
	public IosBase()  {
		DesiredCapabilities capabilities =Global.createConfig("ios",app_path);
		try {
			driver = new IOSDriver(new URL(URL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
}
