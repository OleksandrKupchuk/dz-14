package config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private final static String configPath = "src/main/resources/config.properties";
    public final static String TOOL_QA_URL = "tool.qa.url";
    public static String getProperty(String name){
        Properties properties = new Properties();

        try{
            InputStream inputStream = Files.newInputStream(Paths.get(configPath));
            properties.load(inputStream);
        }
        catch (IOException ioException){
            throw new RuntimeException(String.format("File not exist in path %s %s", configPath, ioException));
        }

        return properties.getProperty(name);
    }
}