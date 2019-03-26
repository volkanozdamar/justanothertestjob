package excelreader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tinylog.Logger;

import java.io.*;


public class ExcelReader {
    static int rowCount;
    static String excelPath = System.getProperty("user.dir")+"/src/resources/excel/Book1.xlsx";
    static String cellValue;
    static File excelFile = new File(excelPath);
    private static FileInputStream fileInputStream;
    static Cell cell;
    static Row row;
    private ExcelReader() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * Return rowcount for new spreatsheet formats , Microsoft Excel version 2007 and later.
     *
     * @return
     */



    public static int getRowCount(String sheetname) {
        try(XSSFWorkbook workbook = new XSSFWorkbook(excelPath)){
            XSSFSheet sheet = workbook.getSheet(sheetname);
            rowCount = sheet.getPhysicalNumberOfRows();
            Logger.info("Row Count is "+rowCount);
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return rowCount;
    }

    /**
     * Reads new spreatsheet formats , Microsoft Excel version 2007 and later.
     * @param sheetName
     * @param rowNum
     * @param collNum
     * @return
     */
    public static String getRowData(String sheetName,int rowNum,int collNum){
        try(XSSFWorkbook workbook = new XSSFWorkbook(excelPath)){
            XSSFSheet sheet = workbook.getSheet(sheetName);
            cellValue = sheet.getRow(rowNum).getCell(collNum).getStringCellValue();
            Logger.info("Value for "+sheetName+"("+rowNum+","+collNum+") is :"+cellValue);
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return cellValue;
    }
}
