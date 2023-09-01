package test;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	
		  
	    // Main driver method
	    public static void main(String[] args) {
	    	Test t = new Test();
	    	t.readFromExcel();
	    }
	    
	    
	    public Object[][] readFromExcel() {

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
	 

}
