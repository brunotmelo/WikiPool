package network;

import org.w3c.dom.Document;

import dataTypes.PageRevisions;
import exceptions.XmlParsingException;

public class WikipediaPooler {

	public PageRevisions getPageRevisions(String searchTerm){
		testValidInput(searchTerm);
		WikipediaConnection connection = new WikipediaConnection(searchTerm);
		Document document = connection.getXmlDocument();
		PageRevisions page = new PageRevisions(document);
		
		return page;
	}
	
	private void testValidInput(String searchTerm){
		if(searchTerm.length()==0){
			throw new XmlParsingException("Empty Search String");
		}
	}
}
