package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "F:\\Flipkart\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;

	}

	public static void loadUrl(String url) {
		driver.get(url);

	}

	public static void max() {
		driver.manage().window().maximize();

	}

	public static String title() {
		String title = driver.getTitle();
		return title;

	}

	public static void Sendkeys(WebElement e, String value) {
		e.sendKeys(value);

	}

	public static void btnclick(WebElement e) {
		e.click();

	}

	public void selectbyValue(WebElement e, String data) {
		Select select = new Select(e);
		select.selectByValue(data);

	}

	public void selectbyVisibletext(WebElement e, String txt) {
		Select select = new Select(e);
		select.selectByVisibleText(txt);

	}

	public void simplealert() {
		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public static String getDatafromExcel(String path, String Sheetname, int rownum, int cellnum) throws IOException {
		File file = new File(path);
		FileInputStream fileinput = new FileInputStream(file);
		Workbook wk = new XSSFWorkbook(fileinput);
		Sheet sheet = wk.getSheet(Sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int celltype = cell.getCellType();
		String value = "";
		if (celltype == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
			value = dateformat.format(dateCellValue);

		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}

		return value;

	}
}
