package Generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.html5.Location;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AutomationHelper {
	public static JsonNode parseJson(String file) {
		File jsonFile = new File(file);

		JsonNode jsonNode = null;
		try {
			jsonNode = new ObjectMapper().readTree(jsonFile);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonNode;
	}

	public static String readPropertiesFileValue(String file, String key) {
		Properties properties = new Properties();

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return properties.getProperty(key);
	}

	public void sleep(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[][] readFromExcel() {

		FileInputStream fis;
		Object[][] objArr = null;
		try {
			fis = new FileInputStream("Resources/GoogleMapTestData.xlsx");

			try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
				Sheet st = wb.getSheet("Sheet1");

				objArr = new Object[st.getLastRowNum()][st.getRow(1).getLastCellNum()];
				for (int i = 1; i <= st.getLastRowNum(); i++) {
					for (int j = 0; j <= st.getRow(i).getLastCellNum() - 1; j++) {
						objArr[i-1][j] = st.getRow(i).getCell(j).getStringCellValue();
						System.out.println(objArr[i-1][j]);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objArr;
	}
	
	public Map<String,ArrayList<ArrayList<String>>> arrangeDataByExcelSheet(){
        try {
            FileInputStream fileInputStream = new FileInputStream("Resources/GoogleMapTestData.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            
            int setCounter = 1;
            int numberOfSheets = workbook.getNumberOfSheets();
            Map<String,ArrayList<ArrayList<String>>> mp = new LinkedHashMap<>();
            ArrayList<ArrayList<String>> arrList = null;
            for (int rowNumber = 1; ; rowNumber++) {
                boolean allEmpty = true;
                arrList = new ArrayList<ArrayList<String>>();
                for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {
                    Sheet sheet = workbook.getSheetAt(sheetIndex);
                    Row row = sheet.getRow(rowNumber);
                    if (row != null) {
                    	ArrayList< String> tmpList = new ArrayList<>();
                    	for (int i = 0;i<=row.getLastCellNum();i++) {
	                        Cell cell = row.getCell(i); // Assuming you want the first cell of each row
	                        if (cell != null) {
	                            allEmpty = false;
	                            tmpList.add(cell.toString());
	                        }
                    	}
                    	arrList.add(tmpList);
                    }
                }
                mp.put("Set"+setCounter, arrList);
                setCounter++;
                if (allEmpty) {
                    break; 
                }
            }
            
            fileInputStream.close();
            workbook.close();
            
            System.out.println(mp);
    		return mp;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	 public Object[][] readFromExcelBySheet() {

			FileInputStream fis;
			Object[][] objArr = null;
			try {
				fis = new FileInputStream("Resources/TestData.xlsx");

				try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
					int r = 1;
					int stSize = wb.getNumberOfSheets();
					for(int i=1;i<=stSize;i++) {
						System.out.println("value of i========="+i);
						System.out.println(wb.getNumberOfSheets());
					
					Sheet st = wb.getSheetAt(i-1);
					System.out.println(st.getSheetName());
					objArr = new Object[st.getLastRowNum()][st.getRow(r).getLastCellNum()];
					
						for (int j = 0; j <= st.getRow(r).getLastCellNum() - 1; j++) {
							objArr[r-1][j] = st.getRow(r).getCell(j).getStringCellValue();
							System.out.println(objArr[r-1][j]);
						}
						if(i == stSize ) {
							if(r != st.getLastRowNum()) {
								r++;
								i = 0;
							}
						}
						System.out.println("===========================================");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		}
			return objArr;
	 }
   public Object[][]readXlBySheet(){
	   FileInputStream fis;
	   Object[][] objArray = null;
	   try {
		fis = new FileInputStream("Resources/TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int r = 1;
		int stSize = wb.getNumberOfSheets();
		for(int i=1;i<=stSize;i++) {
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return objArray;
   }
   public void toReadTheFirstColoumOfExcel() {
	   FileInputStream fis;
	try {
		fis = new FileInputStream("Resources/TestDataOfGoogleMap");
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
		    Cell cell = row.getCell(0); // Index 1 represents the first column
		    if (cell != null) {
		        String cellValue = cell.toString();
		        System.out.println("Cell Value: " + cellValue);
		        // Do something with the cell value
		    }
		}
		workbook.close();
		fis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
  }
   public void getExcelSheet(String path_to_excel_file) {
	   FileInputStream excelFile;
	try {
		excelFile = new FileInputStream(new File(path_to_excel_file));
		 Workbook workbook = new XSSFWorkbook(excelFile);
		 Sheet sheet = workbook.getSheetAt(0);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
   }
   public  String[] read1stColoumnOfExcelData(String filePath, String sheetName) throws IOException {
       FileInputStream fis = new FileInputStream(filePath);
       Workbook workbook = new XSSFWorkbook(fis);
       Sheet sheet = workbook.getSheet(sheetName);

       int rowCount = sheet.getLastRowNum();
       String[] data = new String[rowCount];

       for (int i = 1; i <= rowCount; i++) {
           Row row = sheet.getRow(i);
           Cell cell = row.getCell(0); // Assuming the first column contains the data
           data[i - 1] = cell.getStringCellValue();
       }

       workbook.close();
       fis.close();

       return data;
   }
   public  String[] read2ndColoumnOfExcelData(String filePath, String sheetName) throws IOException {
       FileInputStream fis = new FileInputStream(filePath);
       Workbook workbook = new XSSFWorkbook(fis);
       Sheet sheet = workbook.getSheet(sheetName);

       int rowCount = sheet.getLastRowNum();
       String[] data = new String[rowCount];

       for (int i = 1; i <= rowCount; i++) {
           Row row = sheet.getRow(i);
           Cell cell = row.getCell(1); // Assuming the first column contains the data
           data[i - 1] = cell.getStringCellValue();
       }

       workbook.close();
       fis.close();

       return data;
   }
   public  String[] read3rdColoumnOfExcelData(String filePath, String sheetName) throws IOException {
       FileInputStream fis = new FileInputStream(filePath);
       Workbook workbook = new XSSFWorkbook(fis);
       Sheet sheet = workbook.getSheet(sheetName);

       int rowCount = sheet.getLastRowNum();
       String[] data = new String[rowCount];

       for (int i = 1; i <= rowCount; i++) {
           Row row = sheet.getRow(i);
           Cell cell = row.getCell(2); // Assuming the first column contains the data
           data[i - 1] = cell.getStringCellValue();
       }

       workbook.close();
       fis.close();

       return data;
   }
   public int generateRndmNumber(int min , int max) {
//  	 min =  1; // Minimum value
//       max =  100; // Maximum value
//       int randomInRange =  (int) ((Math.random() * (max - min + 1)) + min);
//       System.out.println("Random Number in Range: " + randomInRange);
//       return randomInRange;
       
        min = 20;
        max = 40;

       // Create an instance of Random
       Random random = new Random();

       // Generate a random number within the specified range
       int randomNumber = random.nextInt((max - min) + 1) + min;

       System.out.println("Random Number between " + min + " and " + max + ": " + randomNumber);
       
       return randomNumber;
   }
   public static Sheet getExcelSheet(String filePath, String sheetName)  {
       FileInputStream fileInputStream = null;
       Workbook workbook = null;
       Sheet sheet = null;
       try {
           fileInputStream = new FileInputStream(filePath);
           workbook = new XSSFWorkbook(fileInputStream);

           // Get the sheet by name
            sheet = workbook.getSheet(sheetName);

           return sheet;
       }catch (IOException e) {
           e.printStackTrace(); 
       }
	return sheet;
   }
  public void closeExcelSheet(String file_path,String sheetName) {
	  
  } 
     
  
   
   
   
}	 

