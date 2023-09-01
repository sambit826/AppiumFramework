package test;
import org.testng.annotations.Test;
import base.BaseTest;

public class VtechysPageTestCase extends BaseTest {

	@Test(dataProvider = "readDataBySheet")
	public void testExcel(String... args) {
		double scrollDuration = Double.valueOf(Integer.parseInt(args[1]));
		chromeBrowserPage.openChromeBrowser();

		for (int i = 2; i <= args.length - 1; i++) {
			System.out.println("Navigating to page: " + args[i]);
			driver.get(args[i]);
			sleep(5);
			scrollTillTime(scrollDuration / 60);
		}
		toogleFlightMode();
		sleep(5);
		toogleFlightMode();
	}

}
