package object_repository;

import csvreader.CsvWriter;
import excelreader.ExcelWriter;
import httpclient.LinkStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WebDriver driver;
    String boutiqueLink;


    CsvWriter csvWriter;


    public MainPage(WebDriver driver){
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    LinkStatus linkStatus = new LinkStatus();
    @FindBy(className = "butik-img-size")
    List<WebElement> boutiques;

    @FindBy(xpath = "div[@class='butik-small-image']/a")
    List<WebElement> littleBoutiqueImage;

    List<String> data = new ArrayList<>();
    public void littleBoutiqueImages(long start) throws Exception{
        csvWriter = new CsvWriter();
        csvWriter.writeLinksAndTime(littleBoutiqueImage,start,"secondTest.csv");
    }


    public void writeLinks() throws Exception{
        csvWriter = new CsvWriter();
        csvWriter.writeLinksAndResponse(boutiques,"firstTest.csv");
    }




}
