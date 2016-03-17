package util;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlFileOpener {

	
	public Document openTestXml() throws SAXException, IOException, ParserConfigurationException{
		InputStream sampleFileInputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("obama-wikipedia-response.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		return documentBuilder.parse(sampleFileInputStream);
	}
	
	public String getXmlStringFromExpression(String expression) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		Node awnserNode = getXmlNodeFromExpression(expression);
		String nodeValue = awnserNode.getNodeValue();
		
		return nodeValue;
	}
	
	public Node getXmlNodeFromExpression(String expression) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		Document document = openTestXml();
		XPath xpath = XPathFactory.newInstance().newXPath();
		return (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
	}
	
	
}
