package log.processor;

import file.reader.FileReader;
import log.extractor.model.LogEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws IOException {
        List<LogEntry> logEntryList = new ArrayList<>();
        FileReader.readFile("test.log",logEntryList);
        logEntryList.forEach(System.out::println);
    }
}
