package executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageScrool {
    WebDriver driver;
    public PageScrool(WebDriver driver) {
        this.driver = driver;
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public void scroolPageWithPX(){
        js.executeScript("window.scrollBy(0,1000)");

    }
}
