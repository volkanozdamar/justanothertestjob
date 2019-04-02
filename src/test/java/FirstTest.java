
import csvreader.CsvReader;
import csvreader.CsvWriter;
import object_repository.MainPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import testbase.TestBase;
import com.google.common.annotations.VisibleForTesting;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;

import java.io.File;

public class FirstTest extends TestBase{
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = dockerBrowser();
        driver.manage().window().fullscreen();

    }

    @Test(description = "First Test")
    public void myTest() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.writeLinks();
    }
    @AfterTest
    public void afterTest(){
        Logger.info("Test Close");
        driver.quit();

    }
    @AfterMethod
    public void afterTest(ITestResult result) throws Exception{
        if (ITestResult.FAILURE == result.getStatus()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/src/resources/screenshots/failure.png"));
            Logger.info("Test Failure,Screenshot Saved");
        }
        Logger.info("Test Done Completely");
        Logger.info("Browser Closed");
    }



}
