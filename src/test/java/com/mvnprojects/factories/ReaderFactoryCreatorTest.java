package com.mvnprojects.factories;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReaderFactoryCreatorTest {
    @Test
    public void getLogReaderFactoryTypeTest() {
        ReaderFactoryCreator logReaderFactoryCreator = new ReaderFactoryCreator(new String[]{"--log-path=C:\\Temp", "--log-level=warn"});
        assertEquals("Log", logReaderFactoryCreator.getReaderFactoryType());
    }
    public ReaderFactoryCreatorTest() {
    }

    @Test
    public void capitalizeEmptyStringTest() {
        assertEquals("", ReaderFactoryCreator.capitalize(""));
    }
    @Test
    public void capitalize_sTr_Test() {
        assertEquals("Str", ReaderFactoryCreator.capitalize(" sTr"));
    }
    @Test
    public void capitalizeTrimTest() {
        assertEquals("Dog", ReaderFactoryCreator.capitalize("dog       "));
    }
    @Test
    public void capitalizeLowercaseTest() {
        assertEquals("Cat", ReaderFactoryCreator.capitalize("CAT"));
    }

    @Test
    public void getTxtTest() {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--configuration=newconfig.txt"});
        assertEquals("Txt", rfc.getFileType());
    }
    @Test
    public void getXmlTest() {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--configuration=newconfig.xml"});
        assertEquals("Xml", rfc.getFileType());
    }
    @Test
    public void getIniTest() {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--configuration=newconfig.ini"});
        assertEquals("Ini", rfc.getFileType());
    }
    @Test
    public void getDocxTest() {
        ReaderFactoryCreator configReaderFactoryCreator = new ReaderFactoryCreator(new String[]{"--configuration=newconfig.docx"});
        assertEquals("Docx", configReaderFactoryCreator.getFileType());
    }
    @Test
    public void getConfigurationReaderFactoryTypeTest() {
        ReaderFactoryCreator configReaderFactoryCreator = new ReaderFactoryCreator(new String[]{"--configuration=my_config.xml"});
        assertEquals("Configuration", configReaderFactoryCreator.getReaderFactoryType());
    }
}
