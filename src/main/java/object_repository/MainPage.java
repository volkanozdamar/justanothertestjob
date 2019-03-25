package object_repository;

import excelreader.ExcelReader;
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

   public void writeResponses(){
       for(WebElement boutique:boutiques){
           System.out.print(linkStatus.makerequest(boutique.getAttribute("href")));
           System.out.println(boutique.getAttribute("href"));
       }
   }

}
