package test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import base.BaseTest;

public class GoogleMapTestCaseTest extends BaseTest {
	  Row row;
	  String keyWord;
	  String shopName;
	  int scrollCount;
	  Double latitude;
	  Double langitude;
	  int scrollTimeStart;
	  int scrollTimeEnd;
	  
      @Test
      public void testGoogleMapTestCase() throws Exception {
    	while(true) { 
    	  Sheet sheet = getExcelSheet("Resources/GoogleMapTestData.xlsx", "Sheet1");
    	  for (int i = 1; i <= sheet.getLastRowNum(); i++) {
    		  
    		        beforeMethod();
    		        
                    row = sheet.getRow(i);
                    keyWord = row.getCell(3).getStringCellValue();
                    shopName = row.getCell(5).getStringCellValue();
                    scrollCount = (int) row.getCell(4).getNumericCellValue();
                    latitude = row.getCell(1).getNumericCellValue();
                    langitude = row.getCell(2).getNumericCellValue();
                    scrollTimeStart =  (int) row.getCell(7).getNumericCellValue();
                    scrollTimeEnd = (int) row.getCell(6).getNumericCellValue();
 
                    changeLocation(latitude,langitude, 0);
                    System.out.println("Latitude..."+latitude+"  Longitude...-"+langitude);
                    googleMapPage.clickOnSearchBoxSendText(keyWord);
                    System.out.println("KeyWord..."+keyWord);
        	        moveToShopName(driver, shopName,scrollCount );
                    System.out.println("Shop Name --"+shopName+"Scroll Count--"+scrollCount);
        	        googleMapPage.clickOnShopUrl();
        	        
        	        for(int j = 8; j <=row.getLastCellNum()-1 ; j++) {
        	        	
        	        	scrollForTimeInTouchAction(driver,generateRndmNumber(scrollTimeStart, scrollTimeEnd));
	        		    scrollInTouchActionToTheTop(driver);
	        		    googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
	        		    System.out.println(j);
        	     }
        	     chromeBrowserPage.closeAllApps();
        	     toogleFlightMode();
        		 System.out.println("Network Resetting");
        		 toogleFlightMode();
	        	 driver.quit();    
      }
    }	  
   }	  
    	  
    	  
    	  
}
      
