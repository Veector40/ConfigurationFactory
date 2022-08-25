package com.mvnprojects.factories.readerFactories;

import com.mvnprojects.configurationHolder.Configuration;
import com.mvnprojects.factories.ReaderFactoryCreator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public interface ReaderFactoryInterface {
    HashMap<String, String> configDetails = new HashMap<>();
    void parseConfig() throws ParserConfigurationException, IOException, SAXException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException;
    default Configuration getConfiguration() throws ParserConfigurationException, IOException, ClassNotFoundException, InvocationTargetException, SAXException, NoSuchMethodException, IllegalAccessException, InstantiationException{
        parseConfig();
        return ReaderFactoryCreator.getConfigurationInstance();
    }
    default void setConfiguration() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(String key: configDetails.keySet()) {
            Method getSetMethod = ReaderFactoryCreator.getConfigurationHolderClass().getMethod("setLog"+ ReaderFactoryCreator.capitalize(key), String.class);
            getSetMethod.invoke(ReaderFactoryCreator.getConfigurationInstance(),  configDetails.get(key));
        }
    }
}
