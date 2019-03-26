package object_repository;

import excelreader.ExcelReader;
import excelreader.ExcelWriter;
import httpclient.LinkStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    LinkStatus linkStatus = new LinkStatus();
    @FindBy(className = "butik-img-size")
    List<WebElement> boutiques;

    ExcelWriter excelWriter = new ExcelWriter();


}
