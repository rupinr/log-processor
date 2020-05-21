package log.extractor.model;

public class LogEntry {

    final private String timeStamp;
    final private Stage stage;
    final private String serviceName;
    final private long uniqueId;

    public LogEntry(String timeStamp, Stage stage, String serviceName, long uniqueId) {
        this.timeStamp = timeStamp;
        this.stage = stage;
        this.serviceName = serviceName;
        this.uniqueId = uniqueId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Stage getStage() {
        return stage;
    }


    public String getServiceName() {
        return serviceName;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "timeStamp=" + timeStamp  +
                ", stage=" + stage +
                ", serviceName=" + serviceName +
                ", uniqueId=" + uniqueId +
                '}';
    }
}

