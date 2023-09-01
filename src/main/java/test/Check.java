package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {
	 public static void main(String[] args) throws Exception  {
	        // Set the path to your ChromeDriver executable
	       // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
	        
	        // Create a new instance of the ChromeDriver
	       // WebDriver driver = new ChromeDriver();
	        
	        // Load the Excel file
	        File excelFile = new File("Resources/TestData.xlsx");
	        FileInputStream fis = new FileInputStream(excelFile);
	        Workbook workbook = new XSSFWorkbook(fis);

	        // Get the number of sheets in the Excel file
	        int numberOfSheets = workbook.getNumberOfSheets();

	        // Iterate through each sheet
	        for (int i = 0; i < numberOfSheets; i++) {
	            Sheet sheet = workbook.getSheetAt(i);

	            // Get the second row (index 1) from the sheet
	            Row row = sheet.getRow(1);

	            // Iterate through each cell in the row
	            for (int j = 0; j < row.getLastCellNum(); j++) {
	                Cell cell = row.getCell(j);
	                System.out.print(cell.getStringCellValue() + "\t");
	            }
	            System.out.println(); // Move to the next line for the next sheet
	        }

	        // Close the workbook and the WebDriver
	        //workbook.close();
	        //driver.quit();
	    }


}
