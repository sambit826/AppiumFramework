package test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class TC_1_GoogleMapTestDataForChicagoInjuryLawyer_33 extends BaseTest {
	Row row;
	  String keyWord;
	  String shopName;
	  int scrollCount;
	  double shopLatitude;
	  double shopLongitude;
	  double pointBLatitude;
	  int miles;
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
	  String url;
	
	  @Parameters({"deviceName", "udid"}) 
      @Test
      public void testGoogleMapTestCase(String deviceName, String udid) throws Exception {
     
//    	  startTime = System.currentTimeMillis();
//	      //long timeLimitMillis = 24 * 60 * 60 * 1000;
//    	  double timeLimitMillis =  (1.5 * 60 * 60 * 1000);
//	      while (isWithinMaxExecutionTime()) {
	    	  int executionCount = 0;
	            int passCount = 0;
	            int failCount = 0;
	            System.out.println(deviceName+udid);
	            //startAppium();
	            //sleep(5);
	            

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
    	  Sheet sheet = getExcelSheet("Resources/GoogleMapTestDataForChicagoInjuryLawyer-33.xlsx", "Sheet2");
    	  System.out.println("Sheet = "+sheet);
    	  System.out.println("sheet2");
    	  for (int i = 1; i <=sheet.getLastRowNum(); i++) {
    		  
    		  		//startAppiumServer();
    		  		//executeCommand("appium server  -p 4723 -a 127.0.0.1 -pa /wd/hub");
    		        
    		        beforeMethod( deviceName,  udid);
    		        System.out.println("Google Map");
    		        
    		        
    		        
    		        row = sheet.getRow(i);
                    keyWord = row.getCell(3).getStringCellValue();
                    shopName = row.getCell(5).getStringCellValue();
                    scrollCount = (int) row.getCell(4).getNumericCellValue();
                    shopLatitude = row.getCell(0).getNumericCellValue();
                    shopLongitude = row.getCell(1).getNumericCellValue();
                    //pointBLatitude = row.getCell(2).getNumericCellValue();
                    miles = (int) row.getCell(2).getNumericCellValue();
                    scrollTimeStart =  (int) row.getCell(6).getNumericCellValue();
                    scrollTimeEnd = (int) row.getCell(7).getNumericCellValue();
                    try {
                    url = row.getCell(8).getStringCellValue();
                    }catch (Exception e) {
						// TODO: handle exception
                    	e.printStackTrace();
					}
 
                    
                    
                    //Network Reset
                    toogleFlightMode();
         
           	     //Change Location
                   double[] randomLocation = generateRandomLocation(shopLatitude, shopLongitude, miles);
                    
                    
                    changeLocation(randomLocation[0], randomLocation[1], 0);
                    
           	        //keyword search
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    
                    googleMapPage.clickOnSearchBoxSendText(keyWord);
                    System.out.println("KeyWord..."+keyWord);
                    
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                   // googleMapPage.checkInternetIsWorking();
                    
                    //Sorting with distance
                    //googleMapPage.chnageToDistance();
                    sleep(1);
                    //Scroll to find shop name
                    googleMapPage.moveToShopName(driver, shopName,scrollCount );
                    System.out.println("Shop Name --"+shopName+"Scroll Count--"+scrollCount);
                   
                    
                    //Navigate to Shop GMB
        	        googleMapPage.clickOnShopUrl();
        	        System.out.println("Navigate to Shop GMB");
        	        
        	        chromeBrowserPage.scrollForTimeInTouchAction(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        
        	    try {
        	      if(url!=null) {
        	        
        	        //Navigate different pages from xls file
        	        for(int j = 8; j <=row.getLastCellNum()-1 ; j++) {
        	   
        	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	        	//sleep(1);
        	        	chromeBrowserPage.scrollForTimeInTouchAction(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        	//scrollForDurationInSeconds(driver, generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        	//scrollForTimeInTouchAction(driver,generateRndmNumber(scrollTimeStart, scrollTimeEnd));
        	        	//scrollForTime(generateRndmNumber(scrollTimeStart, scrollTimeEnd));
	        		    scrollInTouchActionToTheTop(driver);
	        		    //sleep(2);
	        		 // if((row.getCell(j).getStringCellValue())!=null) {
	        		    googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
	        		    System.out.println((row.getCell(j).getStringCellValue()));
	        		    System.out.println(j);
	        		    
	        		    //Scroll the pages
	        		    
	        		  }
        	        }
        	    }catch (Exception e) {
					// TODO: handle exception
        	    	System.out.println(e.getStackTrace());
				}
	        		    
	        		    
        	     
        	        
        	       // scrollInTouchActionToTheTop(driver);   
        	       sleep(1);
        	       
        	       scrollInTouchActionToTheTop(driver);
        	       
        	       //Close all the tabs
        	     chromeBrowserPage.closeAllTabInBrowser();
        	     System.out.println("All tabs clear");
        	     
        	     //Close all Apps
        	     chromeBrowserPage.closeAllApps();
        	     System.out.println("Closed all app");
        	     
        	     
        	     
        	     //Network Reset
        	     //toogleFlightMode();
        	     //sleep(3);
        	     //toogleFlightMode();
        	    
        	     resetNetworkCount++;
        	     
        	     
        	     driver.quit();
        	     rowCount++;
        	     System.out.println(rowCount+"Row completed");
        	     
	        	
      }
    	  passedExicutionCount++;
    	 
 		
 		 
 		 
 		 System.out.println(resetNetworkCount+"-- TImes Network Resetting");
     	 
    	  System.out.println("Passed Exicution--"+passedExicutionCount);
    	  System.out.println(exicutionCount+"___CompleteExicution");
    }
//	      System.out.println("Total Executions: " + exicutionCount);
//	        System.out.println("Successful Executions: " + passedExicutionCount);
//	        failedExicutionCount = exicutionCount - passedExicutionCount;
//	        System.out.println("Failed Executions: " + failedExicutionCount);
  
//      private boolean isWithinMaxExecutionTime() {
//          long currentTime = System.currentTimeMillis();
//          long elapsedMinutes = (currentTime - startTime) / (1000 * 60);
//          return elapsedMinutes < maxExecutionMinutes;
//      }
	
 	                         
    	  
    	  
    	  
}
      
