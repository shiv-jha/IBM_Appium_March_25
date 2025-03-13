package util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidBase extends Global{
	
	public static String app_path ="bs://0e402e2819b6d55599d24b9e412e7fdffa3a18f7";
	
	private static final ThreadLocal<AndroidDriver> DRIVER   = new ThreadLocal<> ();
	
	@BeforeClass
	public static void AndroidBase()  {
		DesiredCapabilities capabilities = Global.createConfig("android",app_path);
        try {
			setDriver (new AndroidDriver (new URL(URL), capabilities));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        getDriver ().manage ()
        .timeouts ()
        .implicitlyWait (Duration.ofSeconds (30));
	}
	
	 public static AndroidDriver getDriver () {
	        return AndroidBase.DRIVER.get();
	    }

	    public static void quitSession () {
	        if (null != DRIVER.get ()) {
	            getDriver ().quit ();
	            DRIVER.remove ();
	        }
	    }
	    
	    private static void setDriver (final AndroidDriver driver) {
	    	AndroidBase.DRIVER.set (driver);
	    }
	
	 @AfterClass
	 public static void quitAll() {
		 getDriver ().quit ();
	 }

}
