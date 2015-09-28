package parsers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import exceptions.WikipediaConnectionException;

public class WikipediaUrlCreator {

	private String url;
	
	public String createUrlFrom(String searchTerm){
		url = new String();
		addQueryAction();
		addProprieties();
		addFormat();
		addRevisionProprieties();
		addRevisionLimit();
		addPageTitle(searchTerm);
		addShowRedirects();		
		return url;			
	}
	
	private void addQueryAction(){
		url += "https://en.wikipedia.org/w/api.php?action=query";
	}
	
	private void addProprieties(){
		url += "&prop=revisions";
	}
	
	private void addFormat(){
		url += "&format=xml";
	}
	
	private void addRevisionProprieties(){
		url += "&rvprop=timestamp%7Ccomment%7Cuser";
	}
	
	private void addRevisionLimit(){
		url += "&rvlimit=30";
	}
	
	private void addPageTitle(String searchTerm){
		try {
			url += "&titles="+ URLEncoder.encode(searchTerm,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new WikipediaConnectionException();
		}
	}
	
	private void addShowRedirects(){
		url += "&redirects=";
	}
	
}
