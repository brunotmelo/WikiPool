package control;

import javax.xml.soap.Node;

import dataTypes.Authors;

public class AuthorsParser {
	
	//will receive a node and do all the work
	private Node revisions;
	private Authors fromRevisions;
	
	public AuthorsParser(Node revisions){
		
	}
	
	
	private void parseNodeIntoAuthors(){
		for(int i=1; i< revisionsLength(); i++){
			
		}
		revisions.getChildNodes().item(1).getAttributes().getNamedItem("user").getNodeValue();
	}
	

	private int revisionsLength(){
		return revisions.getChildNodes().getLength();
	}
	
}
