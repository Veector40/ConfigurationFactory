package com.mvnprojects;

import static org.junit.Assert.assertTrue;

import com.mvnprojects.factories.ReaderFactoryCreator;
//import com.mvnprojects.factories.readerFactories.configurationReaderFactories.configurationReaderFactoryInstances.IniReaderFactory;
import com.mvnprojects.factories.readerFactories.configurationReaderFactories.configurationReaderFactoryInstances.XmlReaderFactory;
import com.mvnprojects.factories.readerFactories.logReaderFactories.logReaderFactoryInstances.LogReaderFactory;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AppTest {
    @Test
    public void shouldCreateXmlReaderFactoryTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReaderFactoryCreator crfc = new ReaderFactoryCreator(new String[]{"--configuration=src\\test\\resources\\my_config.xml"});
        assertTrue(crfc.createReaderFactory() instanceof XmlReaderFactory);
    }
//    @Test
//    public void shouldCreateIniReaderFactoryTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        ReaderFactoryCreator crfc = new ReaderFactoryCreator(new String[]{"--configuration=my_config.ini"});
//        assertTrue(crfc.createReaderFactory() instanceof IniReaderFactory);
//    }
    @Test
    public void shouldCreateLogReaderFactoryTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReaderFactoryCreator lrfc = new ReaderFactoryCreator(new String[]{"--log-path=C:\\Temp", "--log-level=warn"});
        assertTrue(lrfc.createReaderFactory() instanceof LogReaderFactory);
    }
    @Test(expected = java.lang.ClassNotFoundException.class)
    public void factoryDoesNotExistTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReaderFactoryCreator dummyrfc = new ReaderFactoryCreator(new String[]{"--configuration=my_config.nesuzdavafabrikazaradimen"});
        assertTrue(dummyrfc.createReaderFactory() instanceof LogReaderFactory);
    }
    @Test(expected = java.lang.NoSuchMethodException.class)
    public void invalidConfigLogReaderFactoryTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException {
        ReaderFactoryCreator lrfc = new ReaderFactoryCreator(new String[]{"--log-patica=C:\\Temp", "--log-levelel=warn"});
        lrfc.createReaderFactory().getConfiguration();
    }
}
