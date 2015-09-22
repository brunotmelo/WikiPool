package dataTypes;


import java.time.LocalDate;



import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class TestRevision {

	//Test null revision
	private final String EXPECTED_AUTHOR= "Bruno";
	private final String EXPECTED_COMMENT= "Changed to test the program";
	
	private final String EXPECTED_FORMATTED_DATE = "8 31 2015";
	private final int EXPECTED_YEAR = 2015;
	private final int EXPECTED_MONTH = 8;
	private final int EXPECTED_DAY = 31;
	
	private final String EXPECTED_FORMATTED_TIME = "21:38:35";
	private final int EXPECTED_HOURS = 21;
	private final int EXPECTED_MINUTES = 38;
	private final int EXPECTED_SECONDS = 35;
	
	@Test
	public void testGetFormattedDate() {
		LocalDate date = LocalDate.of(EXPECTED_YEAR, EXPECTED_MONTH, EXPECTED_DAY);
		Revision revision = new Revision("",date,null,"");
		String revisionDate = revision.getFormattedDate();
		
		Assert.assertEquals(EXPECTED_FORMATTED_DATE, revisionDate);		
	}

	@Test
	public void testGetFormattedTime(){
		LocalTime time = LocalTime.of(EXPECTED_HOURS, EXPECTED_MINUTES, EXPECTED_SECONDS);
		Revision revision = new Revision("",null,time,"");
	}
	
	@Test
	public void testGetters(){
		Revision first = new Revision(EXPECTED_AUTHOR,null,EXPECTED_COMMENT);	
		assertExpectedAuthorAndComment(first);
	}
	
	private void assertExpectedAuthorAndComment(Revision revision){
		Assert.assertEquals(EXPECTED_AUTHOR,revision.getAuthor());
		Assert.assertEquals(EXPECTED_COMMENT, revision.getComment());
	}
	
}
