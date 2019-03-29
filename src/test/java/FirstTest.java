
import csvreader.CsvReader;
import csvreader.CsvWriter;
import object_repository.MainPage;
import org.openqa.selenium.WebDriver;
import testbase.TestBase;
import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;

public class FirstTest extends TestBase{
    @VisibleForTesting
    private WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = runLocal();
        driver.manage().window().fullscreen();
    }
    @Test(description = "Firefox Test")
    public void myTest() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.writeLinks();
    }

    @AfterTest
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();
        Logger.info("Browser Closed");
    }


}
