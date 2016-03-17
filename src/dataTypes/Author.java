package dataTypes;

import java.util.ArrayList;

public class Author {

	//an author has revisions
	private String name;
	private ArrayList<Revision> revisions;
	
	public Author(String name){
		this.name = name;
		revisions = new ArrayList<>();
	}
	
	public String getName(){
		return name;
	}
	
	public int getNoOfRevisions(){
		return revisions.size();
	}

	public void addRevision(Revision revision) {
		revisions.add(revision);
	}
	
	public ArrayList<Revision> getRevisions(){
		return revisions;
	}
}
