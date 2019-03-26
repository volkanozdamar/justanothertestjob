
import excelreader.ExcelReader;
import object_repository.MainPage;
import org.openqa.selenium.WebDriver;
import testbase.TestBase;
import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.List;

public class SecondTest extends TestBase{
    @VisibleForTesting
    private WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = runLocal();
        driver.manage().window().fullscreen();
    }
    @Test(description = "Firefox Test")
    public void myTest() throws IOException {
        ExcelReader.setExcelPath("data.xlsx");
        System.out.println(ExcelReader.getRowData("Sheet1",0,0));
        ExcelReader.setRowData("Sheet1",0,0,"Change2");
        System.out.println(ExcelReader.getRowData("Sheet1",0,0));
    }

    @AfterTest
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }



}
