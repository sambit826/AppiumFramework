package drivers;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Generics.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Vysor implements DriverInterface {
	URL url = null;
	DesiredCapabilities capabilities = null;
	@Override
	public void configureCapabilities() {
		String buildFilePath = Config.configMap.get("buildFile");
		File file = new File(buildFilePath);
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", Config.configMap.get("deviceName"));
        capabilities.setCapability("platformName", Config.configMap.get("platform").toLowerCase());
        capabilities.setCapability("app", file.getAbsolutePath());
       // System.out.println(file.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", true); 
        capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        try {
        	url = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }		
	

	@Override
	public WebDriver createDriver() {
		if(Config.configMap.get("platform").toLowerCase().equals("android"))
			return new AndroidDriver(url, capabilities);
		return new IOSDriver(url, capabilities);	
	}

}
 