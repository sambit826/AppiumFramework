package drivers;

import Generics.Config;
import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver d) {
		driver.set(d);
	}

	public static void initiateDriver() {
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
		d.configureCapabilities();
		setDriver(d.createDriver());

	}
}
