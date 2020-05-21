package file.reader;

import log.extractor.LogParser;
import log.extractor.model.LogEntry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FileReader {


    public static void readFile(String filePath, List<LogEntry> logEntryList) throws IOException {
        FileInputStream fileStream = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            logEntryList.add(LogParser.parseLog(strLine));
        }
        fileStream.close();
    }
}
