package dataTypes;

import java.util.ArrayList;

public class Author {

	
	//author has revisions
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
	
	//dangerous method
	/*public Revision popRevisionFIFO(){
		Revision target = revisions.get(0);
		revisions.remove(0);
		
		return target;
	}*/

	public void addRevision(Revision revision) {
		revisions.add(revision);
	}
	
	public ArrayList<Revision> getRevisions(){
		return revisions;
	}
}
