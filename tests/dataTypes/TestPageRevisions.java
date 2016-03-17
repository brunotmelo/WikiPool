package dataTypes;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import util.XmlFileOpener;

public class TestPageRevisions {

	private static final String EXPECTED_REDIRECTED_FROM = "Obama";
	private static final Object EXPECTED_PAGE_TITLE = "Barack Obama";
	private static final int EXPECTED_NO_OF_AUTHORS = 20;
	private static final int EXPECTED_NO_OF_REVISIONS = 30;
	private PageRevisions page;
	
	@Before
	public void openXml() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException{
		XmlFileOpener opener = new XmlFileOpener();
		Document document = opener.openTestXml();
		page = new PageRevisions(document);
	}
	
	@Test
	public void testRedirected(){
		String redirectedFrom = page.getRedirectedFrom();
		Assert.assertEquals(EXPECTED_REDIRECTED_FROM, redirectedFrom);
	}
	
	@Test
	public void testGetTitle(){
		String title = page.getPageTitle();
		Assert.assertEquals(EXPECTED_PAGE_TITLE, title);
	}
	
	@Test
	public void testAuthorsSize(){
		ArrayList<Author> authors = page.getAuthors();
		Assert.assertEquals(EXPECTED_NO_OF_AUTHORS, authors.size());
	}	
	
	@Test
	public void testNoOfRevisions(){
		ArrayList<Revision> revisions = page.getAllRevisions();
		Assert.assertEquals(EXPECTED_NO_OF_REVISIONS, revisions.size());
	}
}
