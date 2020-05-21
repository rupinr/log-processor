package log.processor;

import file.reader.FileReader;
import log.aggregate.AggregationProcessor;
import log.extractor.model.LogEntry;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws Exception {
        List<LogEntry> logEntryList = new ArrayList<>();
        if (args.length != 1) {
            throw new Exception("Cannot proceed. Path to the log file must be specified");
        }
        FileReader.readFile(args[0], logEntryList);
        AggregationProcessor.aggregate(logEntryList);

        AggregationProcessor.serviceCallCounter.keySet().forEach(
                serviceName -> {
                    System.out.println("\n"+serviceName + " service has been called " + AggregationProcessor.serviceCallCounter.get(serviceName) / 2 + " times");
                    System.out.println("Maximum execution time is " + AggregationProcessor.maxExecutionTime.get(serviceName) + " seconds");
                }
        );
    }
}
