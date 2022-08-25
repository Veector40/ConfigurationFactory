package com.mvnprojects.configurationHolder;

public class Configuration {
    private String logFilePath;
    private String logLevel;
    public void setLogPath(String logFilePath){
        this.logFilePath = logFilePath;
    }
    public void setLogLevel(String logLevel){
        this.logLevel = logLevel;
    }
    public String getLogPath(){
        return logFilePath;
    }
    public String getLogLevel(){
        return logLevel;
    }
}
