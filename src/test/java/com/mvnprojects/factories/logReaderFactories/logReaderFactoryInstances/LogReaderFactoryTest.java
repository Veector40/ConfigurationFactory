package com.mvnprojects.factories.logReaderFactories.logReaderFactoryInstances;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.mvnprojects.configurationHolder.Configuration;
import com.mvnprojects.factories.ReaderFactoryCreator;
import com.mvnprojects.factories.readerFactories.ReaderFactoryInterface;
import com.mvnprojects.factories.readerFactories.logReaderFactories.logReaderFactoryInstances.LogReaderFactory;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class LogReaderFactoryTest {
    public LogReaderFactoryTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }
    @Test
    public void getsLogDetailsNormalValuesTest() throws ParserConfigurationException, IOException, ClassNotFoundException, InvocationTargetException, SAXException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--log-path=C:\\Temp", "--log-level=WARN"});
//        ReaderFactoryInterface rfi = rfc.createReaderFactory();
//        rfi.setConfiguration();
//        Configuration configuration = rfi.getConfiguration();
        System.out.println(rfc.getArgs()[1]);
//        assertEquals(configuration.getLogPath(), "C:\\Temp");
//        assertEquals(configuration.getLogLevel(), "WARN");
    }
    @Test
    public void getsLogDetailsEmptyValuesTest() throws ParserConfigurationException, IOException, ClassNotFoundException, InvocationTargetException, SAXException, NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--log-path=", "--log-level="});
//        Configuration configuration = rfc.createReaderFactory().getConfiguration();
//        assertEquals(configuration.getLogPath(), "");
//        assertEquals(configuration.getLogLevel(), "");
    }
    @Test(expected = java.lang.StringIndexOutOfBoundsException.class)
    public void getsLogDetailsIncorrectValuesTest() throws ParserConfigurationException, IOException, ClassNotFoundException, InvocationTargetException, SAXException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--log-pathfC:\\Temp", "--log-levelWARN="});
        Configuration configuration = rfc.createReaderFactory().getConfiguration();
        assertEquals(configuration.getLogPath(), "C:\\Temp");
        assertEquals(configuration.getLogLevel(), "WARN");
    }
}
