package parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import exceptions.XmlParsingException;

public class XmlParser {
	
	private Document xmlDocument;
	
	public XmlParser(Document xmlDocument){
		this.xmlDocument = xmlDocument;
	}
	
	public String getPageTitle(){
		String titleExpression = "/api/query/pages/page/@title";
		try{
			return getXmlStringFromExpression(titleExpression);
		}catch(Exception e){
			throw new XmlParsingException();
		}
	}
	
	public boolean isRedirect(){
		try{
			return existsRedirectedNode();
		}catch(Exception e){
			throw new XmlParsingException();
		}
	}
	
	private boolean existsRedirectedNode() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		String redirectedFromExpression = "/api/query/redirects/r/@from";
		boolean existsRedirectedNode = getXmlNodeFromExpression(redirectedFromExpression) != null;
		return existsRedirectedNode;
	}
	
	public String getRedirectedFrom(){
		String redirectedFromExpression = "/api/query/redirects/r/@from";
		try{
			return getXmlStringFromExpression(redirectedFromExpression);
		}catch(Exception e){
			throw new XmlParsingException();
		}
	}
	
	public Node getRevisions(){
		String revisionsExpression = "/api/query/pages/page/revisions";
		try{
			return getXmlNodeFromExpression(revisionsExpression);
		}catch(Exception e){
			throw new XmlParsingException();
		}
	}
	
	private String getXmlStringFromExpression(String expression) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		Node awnserNode = getXmlNodeFromExpression(expression);
		String nodeValue = awnserNode.getNodeValue();
		return nodeValue;
	}
	
	private Node getXmlNodeFromExpression(String expression) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		XPath xpath = XPathFactory.newInstance().newXPath();
		return (Node) xpath.evaluate(expression, xmlDocument, XPathConstants.NODE);
	}
}
