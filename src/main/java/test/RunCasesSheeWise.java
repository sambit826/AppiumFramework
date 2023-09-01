package test;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;
import base.BaseTest;
public class RunCasesSheeWise extends BaseTest {
	
	public void testExcel(ArrayList<String> args) {
		
		double scrollDuration = Double.valueOf(Integer.parseInt(args.get(1)));
		chromeBrowserPage.openChromeBrowser();
		for (int i = 2; i <= args.size() - 1; i++) {
			System.out.println("Navigating to page: " + args.get(i));
			driver.get(args.get(i));
			sleep(5);
			scrollTillTime(scrollDuration / 60);
		}

	}
	
	@Test
	public void runCase() {
		 Map<String, ArrayList<ArrayList<String>>> arrangeDataByExcelSheet = arrangeDataByExcelSheet();
		for(String arg: arrangeDataByExcelSheet.keySet()) {
			for(ArrayList<String> caseArgs :arrangeDataByExcelSheet.get(arg) ) {
				testExcel(caseArgs);
			}
			toogleFlightMode();
			sleep(5);
			toogleFlightMode();
		}
	
	}

}
