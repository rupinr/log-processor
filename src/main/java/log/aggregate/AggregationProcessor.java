package log.aggregate;

import log.extractor.model.LogEntry;
import log.extractor.model.Stage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AggregationProcessor {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss','SSS");
    public static Map<String, Integer> serviceCallCounter = new HashMap<>();
    public static Map<String, Double> maxExecutionTime = new HashMap<>();

    public static void aggregate(List<LogEntry> logEntries) {
        logEntries.forEach(logEntry -> {
            if (serviceCallCounter.containsKey(logEntry.getServiceName())) {
                serviceCallCounter.put(logEntry.getServiceName(), serviceCallCounter.get(logEntry.getServiceName()) + 1);
            } else {
                serviceCallCounter.put(logEntry.getServiceName(), 1);
            }
            double currentExecutionTime = getExecutionTime(logEntries, logEntry.getServiceName(), logEntry.getUniqueId());
            if (maxExecutionTime.containsKey(logEntry.getServiceName())) {

                if (currentExecutionTime > maxExecutionTime.get(logEntry.getServiceName())) {
                    maxExecutionTime.put(logEntry.getServiceName(), currentExecutionTime);
                }
            } else {
                maxExecutionTime.put(logEntry.getServiceName(), currentExecutionTime);
            }
        });
    }

    private static double getExecutionTime(List<LogEntry> logEntries, String serviceName, long requestId) {
        double runTime = 0;
        LogEntry entry = logEntries.stream()
                .filter(
                        item -> item.getServiceName()
                                .equals(serviceName)
                                && item.getUniqueId() == requestId
                                && item.getStage() == Stage.ENTRY)
                .findFirst().get();

        LogEntry exit = logEntries.stream()
                .filter(
                        item -> item.getServiceName()
                                .equals(serviceName)
                                && item.getUniqueId() == requestId
                                && item.getStage() == Stage.EXIT)
                .findFirst().get();

        try {
            runTime = (dateFormat.parse(exit.getTimeStamp()).getTime() - dateFormat.parse(entry.getTimeStamp()).getTime()) / 1000.0d;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return runTime;
    }
}
