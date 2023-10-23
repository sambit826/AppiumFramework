package drivers;

import Generics.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

public class DriverManager {
	
//	String deviceName = null;
//	String udid = null ;
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver d) {
		driver.set(d);
	}
	
	public static void initiateDriver(String deviceName, String udid) {
		String hub = Config.configMap.get("hub").toLowerCase();
		DriverInterface d = null; 
		switch (hub) {
			case "browserstack": {
				d = new BrowserStack();
				break;
			}
			case "vysor": {
				d = new Vysor();
				break;
			}
		}
//		String deviceName = null;
//		String udid = null ;
		d.configureCapabilities( deviceName,  udid);
		setDriver(d.createDriver());
		

	}
}
