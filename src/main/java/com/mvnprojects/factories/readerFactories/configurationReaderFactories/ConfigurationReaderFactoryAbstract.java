package com.mvnprojects.factories.readerFactories.configurationReaderFactories;

import com.mvnprojects.factories.readerFactories.ReaderFactoryInterface;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.mvnprojects.factories.ReaderFactoryCreator.args;

public abstract class ConfigurationReaderFactoryAbstract implements ReaderFactoryInterface {
    public ConfigurationReaderFactoryAbstract() throws ParserConfigurationException, IOException, SAXException {
        setDocument();
    }
    public String getFileName() {
        return args[0].substring(args[0].indexOf("=") + 1);
    }
    public void setDocument() throws IOException, SAXException, ParserConfigurationException {}
}
