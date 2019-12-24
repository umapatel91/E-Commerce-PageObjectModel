package com.mystore.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.mystore.qa.base.TestBase;


public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEET_PATH = "J:\\Uma_Testing\\Project\\E-commerce\\src\\main\\java\\com\\mystore\\qa\\testdata\\EcommerceTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {

		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File trg = new File(currentDir + "/screenshots/" +System.currentTimeMillis()+ ".png");
		FileUtils.copyFile(src, trg);
		
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
				if(sheet.getRow(i+1).getCell(k).getCellType()==CellType.NUMERIC)
				{
					 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
					 Cell cell = sheet.getRow(i+1).getCell(k);
					 String value = formatter.formatCellValue(cell);
				}else if (sheet.getRow(i+1).getCell(k).getCellType()==CellType.STRING) {
					sheet.getRow(i+1).getCell(k).getStringCellValue();
				}
			}
		}
		return data;
	}

}
