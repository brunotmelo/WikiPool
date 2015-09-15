package org.bt.xpath;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;









import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class testFunctionality {

	InputStream xmlStream;

	@Ignore
	public void OpenFile() throws FileNotFoundException{
		File xmlFile = new File("tests/org/bt/xpath/obama-wikipedia-response.xml");
	    xmlStream = new FileInputStream(xmlFile);
	}
	
	@Test
	public void testGetTitle() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.parse(new File("tests/org/bt/xpath/obama-wikipedia-response.xml"));
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		String expression = "/api/query/pages/page/@title";
		Node widgetNode = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
		
		String articleTitle = widgetNode.toString();
		System.out.println(articleTitle);
		assertTrue(articleTitle.equals("title=\"Barack Obama\""));
	}
	
	
	
}
