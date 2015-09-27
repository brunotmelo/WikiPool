package dataTypes;


import java.io.IOException;
import java.time.LocalDate;



import java.time.LocalTime;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import util.XmlFileOpener;

public class TestRevision {

	private final String EXPECTED_AUTHOR= "SMP0328.";
	private final String EXPECTED_COMMENT= "/* Israel */ Chronological order";
	// date and time in the xml
	// 2015-09-14T01:09:00Z
	private final String EXPECTED_FORMATTED_DATE = "9 14 2015";;
	private final String EXPECTED_FORMATTED_TIME = "01:09:00";
	
	private Revision revision;
	
	@Before
	public void createRevision() throws ParserConfigurationException, XPathExpressionException, SAXException, IOException{
		XmlFileOpener fileOpener = new XmlFileOpener();
		String expression = "/api/query/pages/page/revisions";
		Node result =  fileOpener.getXmlNodeFromExpression(expression);
		Node revisionNode = result.getChildNodes().item(1);	
		revision = new Revision(revisionNode);
	}
	
	@Test
	public void testGetFormattedDate() {
		String revisionDate = revision.getFormattedDate();
		Assert.assertEquals(EXPECTED_FORMATTED_DATE, revisionDate);		
	}

	@Test
	public void testGetFormattedTime(){
		String revisionTime = revision.getFormattedTime();
		Assert.assertEquals(EXPECTED_FORMATTED_TIME, revisionTime);
	}
	
	@Test
	public void testGetters(){	
		assertExpectedAuthorAndComment();
	}
	
	//testEmptyComment
	private void assertExpectedAuthorAndComment(){
		Assert.assertEquals(EXPECTED_AUTHOR,revision.getAuthor());
		Assert.assertEquals(EXPECTED_COMMENT, revision.getComment());
	}
	
}
