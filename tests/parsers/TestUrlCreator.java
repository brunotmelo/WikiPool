package parsers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import network.WikipediaConnection;

public class TestUrlCreator {

	private final String SINGLE_WORD_SEARCH = "obama";
	private final String SINGLE_WORD_URL = "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=xml&rvprop=timestamp%7Ccomment%7Cuser&rvlimit=30&titles=obama&redirects=";

	private final String MULTI_WORD_SEARCH = "Barack Obama";
	private final String MULTI_WORD_URL = "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=xml&rvprop=timestamp%7Ccomment%7Cuser&rvlimit=30&titles=Barack+Obama&redirects=";
	
	
	@Test
	public void testSingleWordCreation(){
		WikipediaUrlCreator creator = new WikipediaUrlCreator();
		String result = creator.createUrlFrom(SINGLE_WORD_SEARCH);
		
		
		Assert.assertEquals(SINGLE_WORD_URL,result);
	}
	
	@Test
	public void testMultiWordCreation() throws IOException, ParserConfigurationException, SAXException{
		WikipediaUrlCreator urlCreator = new WikipediaUrlCreator();
		String url =urlCreator.createUrlFrom(MULTI_WORD_SEARCH);
		
		Assert.assertEquals(MULTI_WORD_URL,url);
	}
	
	
	
}
