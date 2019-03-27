package csvreader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvWriter {
    String csvPath = System.getProperty("user.dir")+"/src/resources/csv/";
    public void CsvWrite(List<WebElement> elements) throws Exception{
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath+"data.csv"));
        List<String> deneme = new ArrayList<>();
        deneme.add(1);
        deneme.add(2);
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("URL", "Response"))) {
            csvPrinter.printRecord(deneme.toArray());
            csvPrinter.flush();
        }
    }
}
