package test;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;

import static java.lang.Integer.valueOf;

public class GoogleMapTestCase extends BaseTest {
	
	public void testExcel(ArrayList<String> args) throws Exception {
			  
		//int scrollCount  = Integer.parseInt(args.get(1));
		//System.out.println(scrollCount);
		 changeLocation(Float.valueOf(args.get(1)),Float.valueOf(args.get(1)),0);
		float value = Float.valueOf(args.get(1));
		int ie = (int)value;
        
		googleMapPage.sendingTextToSearchBox(args.get(0));
		sleep(5);
		googleMapPage.moveToShopName(driver, args.get(0), ie);
		googleMapPage.clickOnShopUrl();
		sleep(5);
		scrollTillTimeWithTouchAction(0.9, driver);
		googleMapPage.clickWebTvSeriesVdoProductionLink();
		sleep(5);
		scrollInTouchToTheButtom(driver);
		//scrollInTouchAction(driver);
		System.out.println("Srolling");
		sleep(5);
        scrollInTouchActionToTheTop(driver);
        googleMapPage.clickOnHomeBtn();
        sleep(2);
        scrollTillTimeWithTouchAction(0.7, driver);
        
				   
//		for (int i = 0; i <= args.size() - 1; i++) {
//			//System.out.println("Navigating to page: " + args.get(i));
//			googleMapPage.sendingTextToSearchBox(args.get(i));
//			sleep(5);
//			moveToShopName(driver, args.get(i), ie);
//		}
	}
	
	
	@Test
	public void validateNavigationToWebsiteFromGoogleMap1() throws Exception{
		
		Map<String, ArrayList<ArrayList<String>>> arrangeDataByExcelSheet = arrangeDataByExcelSheet();

		for(String arg: arrangeDataByExcelSheet.keySet()) {
			for(ArrayList<String> caseArgs :arrangeDataByExcelSheet.get(arg) )
				testExcel(caseArgs);
			
			
			toogleFlightMode();
			System.out.println("Network Reseting");
			sleep(5);
			toogleFlightMode();
		}
	}
		
		
		
		
			
//	        
	       
//	       // googleMapPage.openTextBox();
//		   System.out.println(excelData1);
//	        for (String keyword : excelData1) {
//	        	System.out.println(keyword);
//	            googleMapPage.sendingTextToSearchBox(keyword);
//	            sleep(5);
//	            
//	            //scrollToShopName(driver,"Corporate video production", 10);
//	            //sleep(5);
////	            for(String scrollTime : excelData3) {
//	            	 moveToShopName(driver,keyword,20);
//	 	            googleMapPage.clickOnShopUrl();
//	            	
//	            //}
//	           
//	            
//	            
//	            
//	           // scrollUntilElementVisible(driver,"Corporate Video Production" );
//	            
////	            scrollInTouchAction(driver);
////	            scrollInTouchAction(driver);
////	            scrollInTouchAction(driver);
//	            //sleep(5);
////	            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='\"Corporate Video Production\"']")).click();
//	           // googleMapPage.clickOnLeftArrow();
	           
}


		
	


