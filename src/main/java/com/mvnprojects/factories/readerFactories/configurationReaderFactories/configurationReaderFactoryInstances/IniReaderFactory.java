package com.mvnprojects.factories.readerFactories.configurationReaderFactories.configurationReaderFactoryInstances;

import com.mvnprojects.factories.readerFactories.configurationReaderFactories.ConfigurationReaderFactoryAbstract;
import org.ini4j.Ini;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class IniReaderFactory extends ConfigurationReaderFactoryAbstract {
    public IniReaderFactory() throws ParserConfigurationException, IOException, SAXException {
    }

    @Override
    public void parseConfig() {
    }
    @Override
    public void setDocument() {
        Ini ini = new Ini();
    }
}
