package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
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
	
	  @Parameters({"deviceName", "udid"}) 
      @Test
      public void testGoogleMapTestCase(String deviceName, String udid) throws Exception {
     
    	  startTime = System.currentTimeMillis();
	      long timeLimitMillis = 24 * 60 * 60 * 1000;
	      while (isWithinMaxExecutionTime()) {
	    	  int executionCount = 0;
	            int passCount = 0;
	            int failCount = 0;
	            System.out.println(deviceName+udid);
	            

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
    	  Sheet sheet = getExcelSheet("Resources/GoogleMapTestData.xlsx", "Sheet1");
    	  for (int i = 1; i <sheet.getLastRowNum()-1; i++) {
    		 
    		        beforeMethod( deviceName,  udid);
    		        
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
 
                    
                    
                    //Network Reset
                    toogleFlightMode();
           	        sleep(2);
           	        System.out.println("Network Resetting");
           	        toogleFlightMode();
           	        
           	     //Change Location
                    changeLocation(generateRandomLatitudeFormP_AToPoint_B(pointALatitude, pointBLatitude),generateRandomLatitudeFormP_AToPoint_B(pointALongitude, pointBLongitude), 0);
                    sleep(2);
                    
           	        //keyword search
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    googleMapPage.clickOnSearchBoxSendText(keyWord);
                    System.out.println("KeyWord..."+keyWord);
                   // googleMapPage.checkInternetIsWorking();
                    
                    //Sorting with distance
                    //googleMapPage.chnageToDistance();
                    
                    //Scroll to find shop name
                    googleMapPage.moveToShopName(driver, shopName,scrollCount );
                    System.out.println("Shop Name --"+shopName+"Scroll Count--"+scrollCount);
                    System.out.println("Shop Name Found- "+shopName);
                    
                    //Navigate to Shop GMB
        	        googleMapPage.clickOnShopUrl();
        	        System.out.println("Navigate to Shop GMB");
        	        
        	        //Navigate different pages from xls file
        	        for(int j = 9; j <=row.getLastCellNum()-1 ; j++) {
        	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	        	sleep(2);
        	        	//chromeBrowserPage.scrollForTimeInTouchActionn(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        	//scrollForDurationInSeconds(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        	scrollForTimeInTouchAction(driver,generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        	//scrollForTime(generateRndmNumber(scrollTimeStart, scrollTimeEnd));
	        		    scrollInTouchActionToTheTop(driver);
	        		    sleep(2);
	        		    googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
	        		    System.out.println((row.getCell(j).getStringCellValue()));
	        		    System.out.println(j);
	        		    
	        		    //Scroll the pages
	        		    scrollInTouchActionToTheTop(driver);
	        		    
	        		    
        	     }
        	        
        	       // scrollInTouchActionToTheTop(driver);   
        	       sleep(1);
        	       
        	       //Close all the tabs
        	     chromeBrowserPage.closeAllTabInBrowser();
        	     System.out.println("All tabs clear");
        	     
        	     //Close all Apps
        	     chromeBrowserPage.closeAllApps();
        	     System.out.println("Closed all app");
        	     
        	     //Network Reset
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
      
