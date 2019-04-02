import com.google.common.annotations.VisibleForTesting;
import executor.PageScrool;
import object_repository.MainPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;
import testbase.TestBase;
import waithelper.WaitHelper;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SecondTest extends TestBase {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = dockerBrowser();
        driver.manage().window().fullscreen();

    }

    long start = System.currentTimeMillis();
    @Test(description = "Second Test")
    public void myTest() throws Exception {
        MainPage mainPage = new MainPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.className("site-footer"));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        new WaitHelper(driver).waitForElement(Element,100000000);
        mainPage.littleBoutiqueImages(start);

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
