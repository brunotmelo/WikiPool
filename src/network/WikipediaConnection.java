package network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class WikipediaConnection {

	//url string example
	//"https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=xml&rvprop=timestamp%7Cuser&rvlimit=30&titles=barack%20obama&redirects=");

	private String urlString;
	private URLConnection connection;
		
	public WikipediaConnection(String urlString) throws IOException{
		this.urlString = urlString;
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("User-Agent",
				"CS222TwoWeekProject/0.1 (http://www.cs.bsu.edu/homepages/pvg/courses/cs222Fa15/#!/two-week-project; btavaresdeme@bsu.edu)");
		connection.connect();
		this.connection = connection;
		
	}

	public Document getXmlDocument() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		return documentBuilder.parse(connection.getInputStream());
	}
	
	
	
	
}
