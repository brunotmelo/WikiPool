package dataTypes;

import java.util.ArrayList;

import org.w3c.dom.Document;

import parsers.PageParser;

public class PageRevisions {

	private ArrayList<Author> revisionAuthors;
	private ArrayList<Revision> allRevisions;
	private String pageTitle;
	private boolean isRedirect;
	private String redirectedFrom;
	
	
	//normally the pagerevisions will receive an xml
	//there will be a class that will create revisions
	public PageRevisions(Document page){
		PageParser reader = new PageParser(page);
		revisionAuthors = reader.parseRevisionsIntoAuthorsAndOrder();
		pageTitle = reader.parseTitle();
		isRedirect = reader.parseIsRedirected();
		if(isRedirect){
			redirectedFrom = reader.parseRedirectedFrom();
		}
	}
	
	public String getRedirectedFrom(){
		return redirectedFrom;
	}
	
	public ArrayList<Author> getAuthors(){
		return revisionAuthors;
	}
	
	//send authors to the graph

	public String getPageTitle() {
		return pageTitle;
	}
	
	public ArrayList<Revision> getAllRevisions(){
		ArrayList<Revision> revisions = new ArrayList<Revision>();
		for(int i =0; i< revisionAuthors.size(); i++){
			Author current = revisionAuthors.get(i);
			revisions.addAll(current.getRevisions());
		}
		
		return revisions;
	}
	
	
	
}
