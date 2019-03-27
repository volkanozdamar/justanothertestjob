package object_repository;

import excelreader.ExcelReader;
import excelreader.ExcelWriter;
import httpclient.LinkStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainPage {
    WebDriver driver;
    String data;
    String statusCode;
    HttpResponse response;
    HttpGet request;
    HttpClient client;
    public MainPage(WebDriver driver){
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    LinkStatus linkStatus = new LinkStatus();
    @FindBy(className = "butik-img-size")
    List<WebElement> boutiques;

    public void writeLinks() throws Exception{
        for(WebElement boutique:boutiques){
            String data =boutique.getAttribute("href").toString();
            System.out.println(data);
            ExcelWriter.write("Book1.xlsx","Sheet1",data,0);
        }
    }
    public void writeStatusCode() throws ClientProtocolException, IOException {
        client = HttpClientBuilder.create().build();
        for(WebElement boutique : boutiques){
            request  = new HttpGet(boutique.getAttribute("href"));
            response = client.execute(request);
            String data = Integer.toString(response.getStatusLine().getStatusCode());
            ExcelWriter.write("Book1.xlsx","Sheet1",data,1);
            request.abort();
        }

    }



}
