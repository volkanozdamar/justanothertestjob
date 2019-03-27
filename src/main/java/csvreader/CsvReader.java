package csvreader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

public class CsvReader {
    String[] HEADERS = { "URL", "RESPONSE"};
    String csvPath = System.getProperty("user.dir")+"/src/resources/csv/";
    public void readCSVFile() throws Exception{
        Reader in = new FileReader(csvPath+"data.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            System.out.println(record.get("URL"));
            System.out.println(record.get("RESPONSE"));
        }
    }

}
