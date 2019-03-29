import com.google.common.annotations.VisibleForTesting;
import executor.PageScrool;
import object_repository.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.tinylog.Logger;
import testbase.TestBase;
import waithelper.WaitHelper;

import java.util.concurrent.TimeUnit;

public class SecondTest extends MainTest {

    long start = System.currentTimeMillis();
    @Test(description = "Firefox Test")
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


}
