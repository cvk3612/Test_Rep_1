package testDataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunner01 {
	
	@DataProvider
	public Object[][] dataSetTest(){
		Object[][] data = new Object[4][2];
		
		data[0][0] = "data1";
		data[0][1] = "path1";
		
		data[1][0] = "data2";
		data[1][1] = "path2";
		
		data[2][0] = "data3";
		data[2][1] = "path3";
		
		data[3][0] = "data4";
		data[3][1] = "path4";
		
		return data;
	}
	
	@Test(dataProvider = "newDataSet")
	public void myTestMethod(String data, String path) {
		System.out.println(data+" : "+path);
	}
	
	@DataProvider
	public Object[][] newDataSet() throws Exception{
		Object [][] newData;
		String filepath = "F:\\MylockedfolderF\\OR\\TestSheet.xlsx";
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
	    Workbook wb = new XSSFWorkbook(fis);
	    Sheet sh = wb.getSheet("Sheet1");
	    
	    int lastRow = sh.getLastRowNum();
	    int startRow = 1;
	    int lastCell = sh.getRow(0).getLastCellNum();
	    
	    newData = new Object [lastRow][lastCell];
	    
	    for(int i = startRow; i<=lastRow; i++) {
	    	Row row = sh.getRow(i);
	    	String dataCellVal = row.getCell(0).getStringCellValue();
	    	String pathCellVal = row.getCell(1).getStringCellValue();
	    	
	    	newData[i][0] = dataCellVal;
	    	newData[i][1] = pathCellVal;
	    	
	    }
	    
	    return newData;
	}

}
