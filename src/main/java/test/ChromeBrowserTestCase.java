package test;

import org.testng.annotations.Test;

import Generics.SeleniumHelper;
import base.BaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;

public class ChromeBrowserTestCase extends BaseTest
{
	@Test
    public void openRedditUsingChrome() {
		int i = 1;
		int j = 1;
		
		while(true) {
			try {
				System.out.println("Attempting execution "+j+" Times\n");
				chromeBrowserPage.openRedditUsingChrome();
				chromeBrowserPage.scrollPageTillTimeInMinutes(0.3);
				chromeBrowserPage.clickAnyLinkInRedditPage();
				chromeBrowserPage.clickTranslatePopupCloseBtn();
				toogleFlightMode();
				sleep(5);
				toogleFlightMode();
				chromeBrowserPage.closeAllApps();

			}catch(Exception e) {
				System.out.println("Failed Execution "+ i + " Times");
				i++;
			}
			driver.quit();
			sleep(3);
			beforeMethod();
			j++;
		}

    	
    }
	
}
