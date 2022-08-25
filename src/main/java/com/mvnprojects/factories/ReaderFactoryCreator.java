package com.mvnprojects.factories;

import com.mvnprojects.configurationHolder.Configuration;
import com.mvnprojects.factories.readerFactories.ReaderFactoryInterface;

import java.lang.reflect.InvocationTargetException;

public class ReaderFactoryCreator {
    public static String[] args;
    private final String factoryToBeCreated;
    private static final Class<?> configHolderClass;

    static {
        try {
            configHolderClass = Class.forName("com.mvnprojects.configurationHolder.Configuration");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected static Configuration configInstance;

    static {
        try {
            configInstance = (Configuration) configHolderClass.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Configuration getConfigurationInstance() {
        return configInstance;
    }

    public static Class<?> getConfigurationHolderClass() {
        return configHolderClass;
    }

    public ReaderFactoryCreator(String[] args) {
        ReaderFactoryCreator.args = args;
        factoryToBeCreated = getReaderFactoryType();
    }
    public String[] getArgs() {
        return args;
    }
    public String getReaderFactoryType() {
        return capitalize(args[0].substring(2)
                .split("-")[0]
                .split("=")[0]);
    }
    public ReaderFactoryInterface createReaderFactory() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> readerFactoryClass = null;
        if(factoryToBeCreated.equals("Configuration")) {
            readerFactoryClass = Class.forName("com.mvnprojects.factories.readerFactories." +
                    "configurationReaderFactories.configurationReaderFactoryInstances." +
                    getFileType() +
                    "ReaderFactory");
        } else if(factoryToBeCreated.equals("Log")) {
            readerFactoryClass = Class.forName("com.mvnprojects.factories.readerFactories." +
                    "logReaderFactories.logReaderFactoryInstances." +
                    factoryToBeCreated +
                    "ReaderFactory");
        }
        assert readerFactoryClass != null;
        if(!ReaderFactoryInterface.class.isAssignableFrom(readerFactoryClass)) {
            throw new IllegalArgumentException("Class " + readerFactoryClass + " exists but does not implement Figure");
        }
        return generateReaderFactory((Class<ReaderFactoryInterface>) readerFactoryClass);
    }
    public ReaderFactoryInterface generateReaderFactory(Class<ReaderFactoryInterface> className) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return className.getConstructor().newInstance();
    }

    public static String capitalize(String str) {
        str = str.trim();
        if(str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    public String getFileType() {
        String[] fileNameParts = args[0].split("\\.");
        return capitalize(fileNameParts[fileNameParts.length-1]);
    }
}

