package test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Generics.AutomationHelper;

public class Main extends AutomationHelper {
	public static void main(String[] args) {
        try {
            String filePath = "Resources/GoogleMapTestData.xlsx";
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1"); // Change to your sheet name

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Assuming the first row contains headers
                Row  row = sheet.getRow(i);

                // Access cell values and use them as needed
                String cellValue1 = row.getCell(0).getStringCellValue();
                String cellValue2 = row.getCell(3).getStringCellValue();
                String cellValue3 = row.getCell(5).getStringCellValue();


                // Perform actions using cell values (e.g., Selenium actions)
                //System.out.println("Row " + (i + 1) + ": " + cellValue1 + ", " + cellValue2);
                System.out.println(cellValue1);
                System.out.println(cellValue2);
                System.out.println(cellValue3);
                for(int j = 8;j<row.getLastCellNum();j++) {
                	System.out.println(row.getCell(j).getStringCellValue());
                }

                // Add your Selenium code here to interact with the web page using cell values
            }

            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
