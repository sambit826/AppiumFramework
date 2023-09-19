		package test;
		
		import java.io.File;
		import java.io.FileInputStream;
		import java.io.FileNotFoundException;
		import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
		import org.apache.poi.ss.usermodel.Row;
		import org.apache.poi.ss.usermodel.Sheet;
		import org.apache.poi.ss.usermodel.Workbook;
		import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import Generics.SeleniumHelper;
import base.BaseTest;
import drivers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.SupportsContextSwitching;
import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;
		
		public class Check extends BaseTest {
			
			@Test
			 public  void googleMapTestcase() throws Exception  {
				  try {
			            String filePath = "Resources/GoogleMapTestData.xlsx";
			            FileInputStream fis = new FileInputStream(filePath);
			            Workbook workbook = new XSSFWorkbook(fis);
			            Sheet sheet = workbook.getSheet("Sheet1"); // Change to your sheet name
			            
			            //DriverManager.initiateDriver();
			    		///driver = DriverManager.getDriver();
		
			            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Assuming the first row contains headers
			                Row row = sheet.getRow(i);
			                
			                DriverManager.initiateDriver();
				    		driver = DriverManager.getDriver();
				    		SeleniumHelper.driver = driver;
				    		initiatePages();
		
			                // Access cell values and use them as needed
			                String keywordCell3 = row.getCell(3).getStringCellValue();
			                System.out.println(keywordCell3);
			                String cellValue5 = row.getCell(5).getStringCellValue();
			                int cellValue4 = (int) row.getCell(4).getNumericCellValue();
			                Double cellValue1 = row.getCell(1).getNumericCellValue();
			                Double cellValue2 = row.getCell(2).getNumericCellValue();
			                int cellValue7 =  (int) row.getCell(7).getNumericCellValue();
			                int cellValue6 = (int) row.getCell(6).getNumericCellValue();			                
		//	               String value = String.valueOf(row.getCell(4));
		//	    		    int ie = (int)value;
			                
		
			                // Perform actions using cell values (e.g., Selenium actions)
			               //System.out.println("Row " + (i + 1) + ": " + cellValue1 + ", " + cellValue2);
			               // changeLocation(Double.valueOf(cellValue4),Float.valueOf(args.get(1)),0);
			                sleep(3);
			                changeLocation(cellValue1,cellValue2, 0);
			                System.out.println(cellValue1+"...."+cellValue2);
			                googleMapPage.sendingTextToSearchBox(keywordCell3);
			                System.out.println(keywordCell3);
			        		sleep(5);
			        		moveToShopName(driver, cellValue5,cellValue4 );
			        		System.out.println(cellValue5+cellValue4);
			        		sleep(2);
			        		googleMapPage.clickOnShopUrl();
			        		//pressKeyboardKey(AndroidKey.APP_SWITCH);
//			        		googleMapPage.backToPreviousRecentTask();
//			        		googleMapPage.clickOnSearchBtn();
			        		sleep(5);
			        	 for( int j = 8; j <=row.getLastCellNum()-1 ; j++ ) {
			        		 
			        		 //scrollTillTime(20 / 60);
			        		// sleep(3);
			        		 //scrollTillTimeWithTouchAction(20 / 60, driver);
			        		 //chromeBrowserPage.scrollPageTillTimeInMinutes(0.3);
			        		 //scrollInTime(20);
			        		 //scrollForTime(generateRndmNumber(cellValue6, cellValue7));
			        		 scrollForTimeInTouchAction(driver,generateRndmNumber(cellValue6, cellValue7));
			        		 System.out.println(cellValue6+"+"+cellValue7+"="+generateRndmNumber(cellValue6, cellValue7));
			        		 sleep(5);
			        		 scrollInTouchActionToTheTop(driver);
			        		 googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
			        		 System.out.println((row.getCell(j).getStringCellValue()));  
			        		 //switchToViewPage();
//			        		 String originalContext = ((SupportsContextSwitching) driver).getContext();
//
//			                 // Switch to the Chrome browser app
//			                 Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
//			                 for (String contextHandle : contextHandles) {
//			                     if (contextHandle.contains("WEBVIEW")) {
//			                         ((SupportsContextSwitching) driver).context(contextHandle);
//			                         break;
//			                     }
//			                 }
//			                 ///((SupportsContextSwitching) driver).context(originalContext);
//			                 ((SupportsContextSwitching) driver).get((row.getCell(j).getStringCellValue()));
//			        		 HashMap<String, String> argsSwitch = new HashMap<>();
//			        	        argsSwitch.put("targetPackage", "com.android.chrome");
//			        	        ((JavascriptExecutor) driver).executeScript("mobile: shell", argsSwitch);
//                                     
//			        	        // Now you are in the Chrome browser app
//			        	        // You can navigate to a URL in Chrome or perform other actions
//
//			        	        // Switch back to the Google Maps app (if needed)
////			        	        argsSwitch.put("targetPackage", "com.google.android.apps.maps");
////			        	        ((JavascriptExecutor) driver).executeScript("mobile: shell", argsSwitch);
//			        	        driver.get((row.getCell(j).getStringCellValue()));
			                 
			        		 System.out.println(j);
			        		// driver.get(row.getCell(j).getStringCellValue());
			        		 //googleMapPage.sendTextToUrlSearchBox((row.getCell(j).getStringCellValue()));
			        		/// driver.navigate().to((row.getCell(j).getStringCellValue())); 
			        	 }
//			        	 pressKeyboardKey(AndroidKey.APP_SWITCH);
//			        	 googleMapPage.backToPreviousRecentTask();
//			        	 googleMapPage.clickOnSearchBtn();
//			        	 sleep(5);
			        	 toogleFlightMode();
		        		 System.out.println("Network Resetting");
		        		 toogleFlightMode();
			        	 driver.quit();
			        		
			        		
		
			                // Add your Selenium code here to interact with the web page using cell values
			            }
			           workbook.close();
			           fis.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }	  
		//	        File excelFile = new File("Resources/TestData.xlsx");
		//	        FileInputStream fis = new FileInputStream(excelFile);
		//	        Workbook workbook = new XSSFWorkbook(fis);
		//
		//	        // Get the number of sheets in the Excel file
		//	        int numberOfSheets = workbook.getNumberOfSheets();
		//
		//	        // Iterate through each sheet
		//	        for (int i = 0; i < numberOfSheets; i++) {
		//	            Sheet sheet = workbook.getSheetAt(i);
		//
		//	            // Get the second row (index 1) from the sheet
		//	            Row row = sheet.getRow(1);
		//
		//	            // Iterate through each cell in the row
		//	            for (int j = 0; j < row.getLastCellNum(); j++) {
		//	                Cell cell = row.getCell(j);
		//	                System.out.print(cell.getStringCellValue() + "\t");
		//	            }
		//	            System.out.println(); // Move to the next line for the next sheet
		//	        }
		//
		//	        // Close the workbook and the WebDriver
		//	        //workbook.close();
		//	        //driver.quit();
				  //driver.close();
			    }
			
		//	public void testGoogleTestCase() throws Exception {
		//		Check check = new Check();
		//		check.googleMapTestcase();
		//		
		//	}
		
		
		}
