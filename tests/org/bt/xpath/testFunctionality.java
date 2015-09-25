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
import javax.xml.xpath.XPathExpression;
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
		String expression = "/api/query/pages/page/@title";
		String articleTitle = getXmlStringFromExpression(expression);

		assertTrue(articleTitle.equals("Barack Obama"));
	}
	
	@Test
	public void testGetRedirected() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		String expression = "/api/query/redirects/r/@from";
		String redirectedFrom = getXmlStringFromExpression(expression);

		assertTrue(redirectedFrom.equals("Obama"));
	}
	
	@Test
	public void testReadRevisionAuthor() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		String expression = "/api/query/pages/page/revisions";
		Node result =  getXmlNodeFromExpression(expression);
		
		//result.getFirstChild().getAttributes().item(0).toString();
		//result.getChildNodes().item(1);
		
		String user = result.getChildNodes().item(1).getAttributes().getNamedItem("user").getNodeValue();
		
		//command to get user
		//result.getChildNodes().item(0).getAttributes().getNamedItem("user").getNodeValue();
		
		assertEquals("SMP0328.", user);
	}
	
	@Test
	public void testNumberOfRevisions() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		String expression = "/api/query/pages/page/revisions";
		Node result =  getXmlNodeFromExpression(expression);
		assertEquals(30, result.getChildNodes().getLength());
	}
	
	
	private Document openTestXml() throws SAXException, IOException, ParserConfigurationException{
		InputStream sampleFileInputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("obama-wikipedia-response.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		return  documentBuilder.parse(sampleFileInputStream);
	}
	
	private String getXmlStringFromExpression(String expression) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		Node awnserNode = getXmlNodeFromExpression(expression);
		String nodeValue = awnserNode.getNodeValue();
		
		return nodeValue;
	}
	
	private Node getXmlNodeFromExpression(String expression) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		Document document = openTestXml();
		XPath xpath = XPathFactory.newInstance().newXPath();
		return (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
	}
	
	
}
