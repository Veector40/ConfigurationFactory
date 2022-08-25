package com.mvnprojects;

import com.mvnprojects.factories.ReaderFactoryCreator;
import com.mvnprojects.factories.readerFactories.ReaderFactoryInterface;

import org.apache.commons.cli.Option;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.cli.Options;


public class App {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(args);
        ReaderFactoryInterface rfi = rfc.createReaderFactory();
        Options options = new Options();
        Option option = new Option("a", false, "aaa");
        options.addOption(option);
        System.out.println(rfi.getConfiguration().getLogPath());
        System.out.println(rfi.getConfiguration().getLogLevel());
    }
}
