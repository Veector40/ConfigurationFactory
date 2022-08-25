package com.mvnprojects.factories.configurationReaderFactories.configurationReaderFactoryInstances;

import com.mvnprojects.factories.ReaderFactoryCreator;
import com.mvnprojects.factories.readerFactories.configurationReaderFactories.ConfigurationReaderFactoryAbstract;
import com.mvnprojects.factories.readerFactories.configurationReaderFactories.configurationReaderFactoryInstances.XmlReaderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class XmlReaderFactoryTest {

    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();

    public XmlReaderFactoryTest() throws ParserConfigurationException {
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void noChildNodesTest() throws IOException, SAXException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--configuration=src\\test\\resources\\nonodes.xml"});
        XmlReaderFactory xmlrfc = (XmlReaderFactory) (rfc.createReaderFactory());
        NodeList childNodes = builder.parse("src\\test\\resources\\nonodes.xml").getElementsByTagName("configuration").item(0).getChildNodes();
        assertFalse(xmlrfc.isElementNode(childNodes, 1000));
    }
    @Test
    public void isCommentNodeTest() throws IOException, SAXException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--configuration=src\\test\\resources\\commentnode.xml"});
        XmlReaderFactory xmlrfc = (XmlReaderFactory) (rfc.createReaderFactory());
        NodeList childNodes = builder.parse("src\\test\\resources\\commentnode.xml").getElementsByTagName("configuration").item(0).getChildNodes();
        assertFalse(xmlrfc.isElementNode(childNodes, 0)); // expected: 1 for ELEMENT_NODE, actual: 8 for COMMENT_NODE
    }
    @Test
    public void getChildNodesTest() throws IOException, SAXException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException {
        ReaderFactoryCreator rfc = new ReaderFactoryCreator(new String[]{"--configuration=src\\test\\resources\\getchildnodes.xml"});
        XmlReaderFactory xmlrfc = (XmlReaderFactory) (rfc.createReaderFactory());
        Document document = builder.parse("src\\test\\resources\\getchildnodes.xml");
        NodeList childNodes = document.getElementsByTagName("configuration").item(0).getChildNodes();
        assertEquals(childNodes, xmlrfc.getChildNodes(document.getElementsByTagName("configuration").item(0)));
    }
}
