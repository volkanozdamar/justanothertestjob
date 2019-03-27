package excelreader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.List;

public class ExcelWriter {
    public static void write(String fileName,String sheetName, String data,int collNum) throws IOException {
        String excelPath = System.getProperty("user.dir")+"/src/resources/excel/"+fileName;
        InputStream inp = new FileInputStream(excelPath);

        Workbook wb = WorkbookFactory.create(inp);

        Sheet sheet = wb.getSheet(sheetName);

        int num = sheet.getLastRowNum();

        Row row = sheet.createRow(++num);

        row.createCell(collNum).setCellValue(data);

        FileOutputStream fileOut = new FileOutputStream(excelPath);

        wb.write(fileOut);

        fileOut.close();
    }
}