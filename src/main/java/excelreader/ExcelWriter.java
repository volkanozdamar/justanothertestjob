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
        // Create Connection.............
        InputStream inp = new FileInputStream(excelPath);
        // Access excel file.....
        Workbook wb = WorkbookFactory.create(inp);
        // Get the SheetNumber index start with 0.
        Sheet sheet = wb.getSheet(sheetName);
        // Get the last row number of the current sheet.
        int num = sheet.getLastRowNum();
        // Increase the last row number with 1.
        Row row = sheet.createRow(++num);
        // Create a new cell and set the value or data.
        row.createCell(collNum).setCellValue(data);
        // Now this Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(excelPath);
        // Write the data
        wb.write(fileOut);
        // close the connection
        fileOut.close();
    }
}