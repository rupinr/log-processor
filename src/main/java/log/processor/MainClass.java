package log.processor;

import file.reader.FileReader;
import log.aggregate.AggregationProcessor;
import log.extractor.model.LogEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws IOException {
        List<LogEntry> logEntryList = new ArrayList<>();
        FileReader.readFile("test.log",logEntryList);
        AggregationProcessor.aggregate(logEntryList);

        AggregationProcessor.serviceCallCounter.keySet().forEach(
                serviceName -> {
                    System.out.println(serviceName + " has been called "+ AggregationProcessor.serviceCallCounter.get(serviceName)/2 +" times");
                    System.out.println("Max Execution Time is "+ AggregationProcessor.maxExecutionTime.get(serviceName)+"\n");
                }
        );
    }
}
