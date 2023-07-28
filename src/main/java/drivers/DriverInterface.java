package drivers;

import org.openqa.selenium.WebDriver;

public interface DriverInterface {
	public void configureCapabilities();
	public WebDriver createDriver();

}
