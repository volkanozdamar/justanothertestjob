
import excelreader.ExcelReader;
import object_repository.Login;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class ThirdTest extends TestBase {
    RemoteWebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = dockerBrowser();
        driver.manage().window().fullscreen();

    }
    @Test(description = "Successful Login")
    public void myTest() throws Exception {
        Login login = new Login(driver);
        login.hoverToLoginRegisterButtonContainer();
        login.clickToLoginButton();
        login.waitForPopupLoginMain(20);
        login.fillEmailBox("kapsujasti@desoz.com");
        login.fillPasswordBox("Qwerty123");
        login.submitLogin();
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
