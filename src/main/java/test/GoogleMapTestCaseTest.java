package test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class GoogleMapTestCaseTest extends BaseTest {
	  Row row;
	  String keyWord;
	  String shopName;
	  int scrollCount;
	  double pointALatitude;
	  double pointALongitude;
	  double pointBLatitude;
	  double pointBLongitude;
	  int scrollTimeStart;
	  int scrollTimeEnd;
	  long startTime;
//	  long elapsedTime;
	  int exicutionCount;
	  int passedExicutionCount;
	  int failedExicutionCount;
	  //long timeLimitMillis = 4 * 60 * 60 * 1000;
	  int maxExecutionMinutes = 120;
	  int resetNetworkCount;
	  int rowCount;
	
	 
      @Test
      public void testGoogleMapTestCase() throws Exception {
     
    	  startTime = System.currentTimeMillis();
	      long timeLimitMillis = 24 * 60 * 60 * 1000;
	      while (isWithinMaxExecutionTime()) {
	    	  int executionCount = 0;
	            int passCount = 0;
	            int failCount = 0;

	    	  exicutionCount++;
//    	  startTime = System.currentTimeMillis();
//    	  while(true) {
//    		  elapsedTime = System.currentTimeMillis()-startTime;
//    		  
//    		  if(elapsedTime >= timeLimitMillis) {
//    			  System.out.println("Completed Exicution");
//    	          System.out.println("Total Exicution ___"+exicutionCount);
//    			  break;
//    		  }  
    	  Sheet sheet = getExcelSheet("Resources/GoogleMapTestData.xlsx", "Sheet2");
    	  for (int i = 1; i <= sheet.getLastRowNum(); i++) {
    		 
    		        beforeMethod();
    		        
                    row = sheet.getRow(i);
                    keyWord = row.getCell(4).getStringCellValue();
                    shopName = row.getCell(6).getStringCellValue();
                    scrollCount = (int) row.getCell(5).getNumericCellValue();
                    pointALatitude = row.getCell(0).getNumericCellValue();
                    pointALongitude = row.getCell(1).getNumericCellValue();
                    pointBLatitude = row.getCell(2).getNumericCellValue();
                    pointBLongitude = row.getCell(3).getNumericCellValue();
                    scrollTimeStart =  (int) row.getCell(7).getNumericCellValue();
                    scrollTimeEnd = (int) row.getCell(8).getNumericCellValue();
 
                    changeLocation(generateRandomLatitudeFormP_AToPoint_B(pointALatitude, pointBLatitude),generateRandomLatitudeFormP_AToPoint_B(pointALongitude, pointBLongitude), 0);
                    googleMapPage.clickOnSearchBoxSendText(keyWord);
                    sleep(2);
                    System.out.println("KeyWord..."+keyWord);
                    googleMapPage.checkInternetIsWorking();
                    //googleMapPage.chnageToDistance();
                    googleMapPage.moveToShopName(driver, shopName,scrollCount );
                    System.out.println("Shop Name --"+shopName+"Scroll Count--"+scrollCount);
        	        googleMapPage.clickOnShopUrl();
        	        
        	        for(int j = 9; j <=row.getLastCellNum()-1 ; j++) {
        	        	
        	        	scrollForTimeInTouchAction(driver,generateRndmNumber(scrollTimeStart, scrollTimeEnd));
	        		    scrollInTouchActionToTheTop(driver);
	        		    googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
	        		    System.out.println((row.getCell(j).getStringCellValue()));
	        		    System.out.println(j);
        	     }
        	    
        	     chromeBrowserPage.closeAllApps();
        	     toogleFlightMode();
        	     sleep(2);
        	     toogleFlightMode();
        	     resetNetworkCount++;
        	     System.out.println("Network Resetting");
        	     
        	     driver.quit();
        	     rowCount++;
        	     System.out.println(rowCount+"Row completed");
	        	 //System.out.println(passedExicutionCount+"---Exicution Passed");
      }
    	  passedExicutionCount++;
    	 
 		
 		 
 		 
 		 System.out.println(resetNetworkCount+"-- TImes Network Resetting");
     	 
    	  System.out.println("Passed Exicution--"+passedExicutionCount);
    	  System.out.println(exicutionCount+"___CompleteExicution");
    }
	      System.out.println("Total Executions: " + exicutionCount);
	        System.out.println("Successful Executions: " + passedExicutionCount);
	        failedExicutionCount = exicutionCount - passedExicutionCount;
	        System.out.println("Failed Executions: " + failedExicutionCount);
  }	
      private boolean isWithinMaxExecutionTime() {
          long currentTime = System.currentTimeMillis();
          long elapsedMinutes = (currentTime - startTime) / (1000 * 60);
          return elapsedMinutes < maxExecutionMinutes;
      }
	
 	                         
    	  
    	  
    	  
}
      
