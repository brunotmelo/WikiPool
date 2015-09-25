package dataTypes;


import org.junit.Assert;
import org.junit.Test;

public class TestPageRevisions {

	
	@Test
	public void testGetRevisionFIFO(){
		Revisions revisions = new Revisions();
		Revision failRevision = new Revision("",null,null,"");
		Revision expectedRevision = new Revision("bruno",null,null,"");
		
		revisions.addRevision(failRevision);
		revisions.addRevision(expectedRevision);
		revisions.popRevisionFIFO();
		
		assertEqualRevision(expectedRevision, revisions.popRevisionFIFO());
	}
	
	private void assertEqualRevision(Revision expected, Revision tested){
		Assert.assertEquals(expected.getAuthor(), tested.getAuthor());
	}
	
	
	
	
}
