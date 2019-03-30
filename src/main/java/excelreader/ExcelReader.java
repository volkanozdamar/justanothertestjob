package excelreader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tinylog.Logger;

import java.io.*;


public class ExcelReader {
    static int rowCount;
    static String excelPath = System.getProperty("user.dir")+"\\src\\resources\\excel\\";
    static String cellValue;
    static CellType cellType;
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
        try(XSSFWorkbook workbook = new XSSFWorkbook(excelPath+sheetname)){
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
        try(XSSFWorkbook workbook = new XSSFWorkbook(excelPath+sheetName)){

            Logger.info("Reading from "+excelPath+sheetName+" "+rowNum+"-"+collNum);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            cellType = sheet.getRow(rowNum).getCell(collNum).getCellType();
            switch (cellType){
                case _NONE:
                    cellValue = "";
                    break;
                case NUMERIC:
                    cellValue = String.valueOf(sheet.getRow(rowNum).getCell(collNum).getNumericCellValue());
                    break;
                case STRING:
                    cellValue = sheet.getRow(rowNum).getCell(collNum).getStringCellValue();
                    break;
                case FORMULA:
                    break;
                case BLANK:
                    cellValue = "";
                    break;
                case BOOLEAN:
                    break;
                case ERROR:
                    break;
            }

        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return cellValue;
    }
}
