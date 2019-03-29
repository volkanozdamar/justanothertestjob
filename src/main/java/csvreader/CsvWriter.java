package csvreader;

import au.com.bytecode.opencsv.CSVWriter;
import httpclient.LinkStatus;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvWriter {
    String csvPath = System.getProperty("user.dir")+"/src/resources/csv/";
    LinkStatus linkStatus = new LinkStatus();
    String longToString;
    String linkOfElement;
    long finish;
    public void writeLinksAndResponse(List<WebElement> elements, String filename) throws Exception{
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath+filename));
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("URL", "Response"))) {
                for(WebElement element:elements) {
                    linkOfElement = element.getAttribute("href");
                    csvPrinter.printRecord(linkOfElement,linkStatus.makerequest(linkOfElement));
                }
                csvPrinter.flush();
            }
    }

    public void writeLinksAndTime(List<WebElement> elements,Long start,String filename) throws Exception{
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath+filename));
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("URL", "Response"))) {
            for(WebElement element:elements) {
                linkOfElement = element.getAttribute("href");
                System.out.println(linkOfElement);
                finish = System.currentTimeMillis();
                longToString = Long.toString(finish-start/1000);
                System.out.println(longToString);
                System.out.print(linkOfElement);
                System.out.println(longToString);
                csvPrinter.printRecord(linkOfElement,longToString);
            }
            csvPrinter.flush();
        }
    }

}
