
import excelreader.ExcelReader;
import excelreader.ExcelWriter;
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

public class FirstTest extends TestBase{
    @VisibleForTesting
    private WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = runLocal();
        driver.manage().window().fullscreen();
    }
    @Test(description = "Firefox Test")
    public void myTest() throws IOException {
        MainPage mainPage = new MainPage(driver);
        ExcelWriter.write("Book1.xlsx","Sheet1","a",0);
        ExcelWriter.write("Book1.xlsx","Sheet1","b",1);
    }

    @AfterTest
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }



}
