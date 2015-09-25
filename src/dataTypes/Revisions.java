package dataTypes;

import java.util.ArrayList;

public class Revisions {

	private ArrayList<Revision> revisions;
	private String PageTitle;
	private boolean redirected;
	
	//normally the pagerevisions will receive an xml
	//there will be a class that will create revisions
	public Revisions(){
		revisions = new ArrayList<>();
	}
	
	public void addRevision(Revision revision){
		revisions.add(revision);
	}
	
	public Revision popRevisionFIFO(){
		//has an index of the first inserted element
		//returns the one with first index and removes it.
		Revision target = revisions.get(0);
		revisions.remove(0);
		
		return target;
		
		
	}
	
	public void orderByMostChanges(){
		
	}
	
	
	
}
