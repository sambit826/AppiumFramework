package test;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
        // Define the range (inclusive) - min and max values
        int min = 20;
        int max = 40;

        // Create an instance of Random
        Random random = new Random();

        // Generate a random number within the specified range
        int randomNumber = random.nextInt((max - min) + 1) + min;

        System.out.println("Random Number between " + min + " and " + max + ": " + randomNumber);
    }
	//@tes
	//public void 
		  
////	    // Main driver method
////	    public static void main(String[] args) {
////	    	Test t = new Test();
////	    	t.readFromExcel();
////	    }
////	    
////	    
////	    public Object[][] readFromExcel() {
////
////			FileInputStream fis;
////			Object[][] objArr = null;
////			try {
////				fis = new FileInputStream("Resources/TestData.xlsx");
////
////				try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
////					int r = 1;
////					int stSize = wb.getNumberOfSheets();
////					for(int i=1;i<=stSize;i++) {
////						System.out.println("value of i========="+i);
////						System.out.println(wb.getNumberOfSheets());
////					
////					Sheet st = wb.getSheetAt(i-1);
////					
////					System.out.println(st.getSheetName());
////					objArr = new Object[st.getLastRowNum()][st.getRow(r).getLastCellNum()];
////					
////						for (int j = 0; j <= st.getRow(r).getLastCellNum() - 1; j++) {
////							objArr[r-1][j] = st.getRow(r).getCell(j).getStringCellValue();
////							System.out.println(objArr[r-1][j]);
////						}
////						if(i == stSize ) {
////							if(r != st.getLastRowNum()) {
////								r++;
////								i = 0;
////							}
////						}
////						System.out.println("===========================================");
////					}
////				}
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			return objArr;
////		}
////	
//	 public void toReadTheFirstColoumOfExcel() {
//		   FileInputStream fis;
//		try {
//			fis = new FileInputStream("Resources/TestDataOfGoogleMap.xlsx");
//			Workbook workbook = new XSSFWorkbook(fis);
//			Sheet sheet = workbook.getSheetAt(0);
//			 int rowCount = sheet.getPhysicalNumberOfRows();
//
//		        // Iterate through the rows starting from the second row (index 1)
//		        for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
//		            Row row = sheet.getRow(rowIndex);
//		            if (row != null) {
//		                Cell cell = row.getCell(0); // Index 0 represents the first column
//		                if (cell != null) {
//		                    String cellValue = cell.toString();
//		                    System.out.println("Cell Value: " + cellValue);
//		                    // Do something with the cell value
//		                }
//		            }
//		        }
//			workbook.close();
//			fis.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//		   
//	  } 
//	  public static void main(String[]args) {
//		  Test test = new Test();
//		  test.toReadTheFirstColoumOfExcel();
//		 
//		  
//	  } 
//
}
