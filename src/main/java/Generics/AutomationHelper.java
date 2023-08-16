package Generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
			fis = new FileInputStream("Resources/TestData.xlsx");

			try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
				Sheet st = wb.getSheet("Sheet2");

				objArr = new Object[st.getLastRowNum()][st.getRow(1).getLastCellNum()];
				for (int i = 1; i <= st.getLastRowNum(); i++) {
					for (int j = 0; j <= st.getRow(i).getLastCellNum() - 1; j++) {
						objArr[i-1][j] = st.getRow(i).getCell(j).getStringCellValue();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objArr;
	}
}
