package org.bt.xpath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import util.XmlFileOpener;


public class testFunctionality {

	InputStream xmlStream;
	
	@Test
	public void testGetTitle() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		String expression = "/api/query/pages/page/@title";
		XmlFileOpener fileOpener = new XmlFileOpener();
		String articleTitle = fileOpener.getXmlStringFromExpression(expression);

		assertTrue(articleTitle.equals("Barack Obama"));
	}
	
	@Test
	public void testGetRedirected() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		String expression = "/api/query/redirects/r/@from";
		XmlFileOpener fileOpener = new XmlFileOpener();
		String redirectedFrom = fileOpener.getXmlStringFromExpression(expression);

		assertTrue(redirectedFrom.equals("Obama"));
	}
	
	@Test
	public void testReadRevisionAuthor() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		String expression = "/api/query/pages/page/revisions";
		XmlFileOpener fileOpener = new XmlFileOpener();
		Node result =  fileOpener.getXmlNodeFromExpression(expression);
		
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
		XmlFileOpener fileOpener = new XmlFileOpener();
		Node result =  fileOpener.getXmlNodeFromExpression(expression);
		assertEquals(30, result.getChildNodes().getLength());
	}
	
	
}
