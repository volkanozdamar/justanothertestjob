
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

public class FirstTest extends MainTest{

    @Test(description = "Firefox Test")
    public void myTest() throws Exception {
        MainPage mainPage = new MainPage(driver);
        mainPage.writeLinks();
    }



}
