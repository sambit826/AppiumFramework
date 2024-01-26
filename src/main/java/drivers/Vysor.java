package drivers;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Generics.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Vysor implements DriverInterface {
	URL url = null;
	DesiredCapabilities capabilities = null;
	
	public void configureCapabilities(String deviceName, String udid) {
		String buildFilePath = Config.configMap.get("buildFile");
		File file = new File(buildFilePath);
        capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", Config.configMap.get("deviceName"));
        capabilities.setCapability("deviceName", Config.configMap.get("deviceName"));
        capabilities.setCapability("platformName", deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
//        capabilities.setCapability("app", file.getAbsolutePath());
       // System.out.println(file.getAbsolutePath());
        //capabilities.setCapability("systemPort", "4723");
        capabilities.setCapability("autoGrantPermissions", true); 
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");
//        capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
//        if(AppName == "chrome") {
//        capabilities.setCapability("appPackage", "com.android.chrome");
//        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
//        }
//        else if(AppName == "map") {
//        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
//        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");
//        }
        capabilities.setCapability("automationName", "UiAutomator2");
        if(udid.equals("72266245408932")) {
        	 try {
             	url = new URL("http://localhost:4723/wd/hub");
             	System.out.println("PORT 4723");
             } catch (Exception e) {
                 e.printStackTrace();
             }
        }
        
        else {
        	try {
             	url = new URL("http://localhost:4726/wd/hub");
             	System.out.println("PORT 4726");
             } catch (Exception e) {
                 e.printStackTrace();
             }

		}
       
    }		
	

	@Override
	public WebDriver createDriver() {
		if(Config.configMap.get("platform").toLowerCase().equals("android"))
			return new AndroidDriver(url, capabilities);
		return new IOSDriver(url, capabilities);	
	}


	@Override
	public void configureCapabilities() {
		// TODO Auto-generated method stub
		
	}

}
 