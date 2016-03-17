package parsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import dataTypes.Author;
import dataTypes.Revision;

public class PageParser {
	
	private Node revisions;
	private XmlParser xmlParser;
	
	private HashMap<String,Author> authorsHash;
	private ArrayList<Author> authorsOrderedList;
	
	public PageParser(Document pageDocument){
		xmlParser = new XmlParser(pageDocument);
		revisions = xmlParser.getRevisions();
	}
	
	public ArrayList<Author> parseRevisionsIntoAuthorsAndOrder(){
		authorsHash = new HashMap<>();
		for(int i=0; i< parseRevisionsLength(); i++){
			Node revisionNode = revisions.getChildNodes().item(i);
			Revision currentRevision = new Revision(revisionNode);
			insertIntoAuthor(currentRevision);
		}
		sortAuthorsByMostChanges();
		return authorsOrderedList;
	}
	
	private int parseRevisionsLength(){
		return revisions.getChildNodes().getLength();
	}
	
	private void insertIntoAuthor(Revision revision){
		String authorName = revision.getAuthor();
		if(authorsHash.containsKey(authorName)){
			Author current = authorsHash.get(authorName);
			current.addRevision(revision);
		}else{
			Author revisionAuthor = new Author(authorName);
			revisionAuthor.addRevision(revision);
			authorsHash.put(authorName, revisionAuthor);
		}
	}
	
	private void sortAuthorsByMostChanges(){
		authorsOrderedList = new ArrayList<Author>(authorsHash.values());
	    Collections.sort(authorsOrderedList, new Comparator<Author>() {
	        public int compare(Author a1, Author a2) {
	            return a2.getNoOfRevisions() - a1.getNoOfRevisions();
	        }
	    });
	    /* prints authors. Used to debug ordering
	     * for (Author a : authorsOrderedList) {
	        System.out.println(a.getName() + "\t" + a.getNoOfRevisions());
	    }*/
	}
	
	public String parseTitle(){
		return xmlParser.getPageTitle();
	}

	public boolean parseIsRedirected() {
		return xmlParser.isRedirect();
	}

	public String parseRedirectedFrom() {
		return xmlParser.getRedirectedFrom();
	}
}
