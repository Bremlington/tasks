package Containers.Database;

import Containers.StorageType;

import java.util.Properties;

public class StorageConfig {
    private final Properties configProperties = new Properties();

    public StorageConfig(String user, String password, String host, int port, String database, String timeZone) {
        configProperties.setProperty("user", user);
        configProperties.setProperty("password", password);
        configProperties.setProperty("host", host);
        configProperties.setProperty("port", Integer.toString(port));
        configProperties.setProperty("database", database);
        configProperties.setProperty("timeZone", timeZone);
        setConnectionUrl();
    }

    public StorageConfig(String pathToSavedFiles){
        configProperties.setProperty("pathToSavedFiles", pathToSavedFiles);
    }

    public StorageConfig(StorageType storageType) {
        switch (storageType) {
            case DATABASE:
                configProperties.setProperty("user", "springuser");
                configProperties.setProperty("password", "springuser");
                configProperties.setProperty("host", "localhost");
                configProperties.setProperty("port", "3306");
                configProperties.setProperty("database", "list");
                configProperties.setProperty("timeZone", "UTC");
                setConnectionUrl();
            case FILE:
                configProperties.setProperty("pathToSavedFiles", "");
        }
    }

    public String getConnectionUrl() {
        return configProperties.getProperty("connectionUrl");
    }

    public String getPathToSavedFiles() {
        return configProperties.getProperty("pathToSavedFiles");
    }

    Properties getLoginPassword(){
        Properties properties = new Properties();
        properties.setProperty("user", configProperties.getProperty("user"));
        properties.setProperty("password", configProperties.getProperty("password"));

        return properties;
    }

    private void setConnectionUrl(){
        String host = configProperties.getProperty("host");
        String port = configProperties.getProperty("port");
        String database = configProperties.getProperty("database");
        String timeZone = configProperties.getProperty("timeZone");

        configProperties.setProperty("connectionUrl","jdbc:mysql://"+host+":"+port+"/"+database+"?serverTimezone="+timeZone);
    }
}
