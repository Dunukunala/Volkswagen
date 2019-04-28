package dataProviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    Properties properties = new Properties();

    {
        try {
            FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "/src/test/configs/Configuration.properties.properties");
            properties.load(fn);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getReportConfigPath() {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties.properties file for the Key:reportConfigPath");

    }
}