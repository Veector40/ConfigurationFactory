package com.mvnprojects.factories.readerFactories.logReaderFactories.logReaderFactoryInstances;

import com.mvnprojects.factories.readerFactories.ReaderFactoryInterface;
import java.lang.reflect.InvocationTargetException;
import static com.mvnprojects.factories.ReaderFactoryCreator.args;


public class LogReaderFactory implements ReaderFactoryInterface {
    public LogReaderFactory() {}

    @Override
    public void parseConfig() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        getLogDetails();
        setConfiguration();
    }
    public void getLogDetails() {
        for(String arg: args) {
            String configAttribute = arg.substring(6, arg.indexOf("="));
            String configAttributeValue = arg.substring(arg.indexOf("=") + 1);
            configDetails.put(configAttribute, configAttributeValue);
        }
    }
}