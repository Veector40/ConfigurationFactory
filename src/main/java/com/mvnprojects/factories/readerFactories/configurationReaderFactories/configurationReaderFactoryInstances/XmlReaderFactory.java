package com.mvnprojects.factories.readerFactories.configurationReaderFactories.configurationReaderFactoryInstances;

import com.mvnprojects.factories.readerFactories.configurationReaderFactories.ConfigurationReaderFactoryAbstract;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class XmlReaderFactory extends ConfigurationReaderFactoryAbstract {
    private Document doc = null;

    public XmlReaderFactory() throws ParserConfigurationException, IOException, SAXException {}


    @Override
    public void parseConfig() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, ParserConfigurationException, SAXException {
        setDocument();
        NodeList configList = doc.getElementsByTagName("configuration");
        if(isElementNode(configList, 0)) {
            NodeList logDetails = getChildNodes(configList.item(0));
            for(int i = 0; i < logDetails.getLength(); i++) {
                Node logDetailNode = logDetails.item(i);
                if(isElementNode(logDetails, i)) {
                    NodeList configDetailsNodes = getChildNodes(logDetailNode);

                    for(int j = 0; j < configDetailsNodes.getLength(); j++) {
                        Node configDetailNode = configDetailsNodes.item(j);
                            if(isElementNode(configDetailsNodes, j)) {
                            String nodeName = configDetailNode.getNodeName();
                            String nodeValue = configDetailNode.getTextContent();
                            configDetails.put(nodeName, nodeValue);
                        }
                    }
                }
            }
        }
        setConfiguration();
    }
    public Boolean isElementNode(NodeList nodeList, int itemNumber) {
        return nodeList.item(itemNumber).getNodeType() == Node.ELEMENT_NODE;
    }

    public NodeList getChildNodes(Node nodeParent) {
        return nodeParent.getChildNodes();
    }
    @Override
    public void setDocument() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();
        doc = builder.parse(getFileName());
    }
}
