package log.extractor;

import log.extractor.model.LogEntry;
import log.extractor.model.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {


    public static LogEntry parseLog(String logLine) {
        String[] serviceName =  getServiceName(logLine).split(":");
        return new LogEntry(
                getTimeStamp(logLine),
                getStage(logLine),
                serviceName[0],
                Long.parseLong(serviceName[1]));
    }

    private static String getTimeStamp(String logLine) {
        return logLine.substring(0,23);
    }

    private static Stage getStage(String logLine) {
        return logLine.contains("entry with") ? Stage.ENTRY:  Stage.EXIT;
    }

    private static String getServiceName(String logLine) {
        Pattern pattern =  Pattern.compile("\\((.*?)\\)");
        Matcher matcher= pattern.matcher(logLine);
        String serviceName = null;
        while (matcher.find()) {
            serviceName=  matcher.group(1);
        }
        return serviceName;
    }
}
