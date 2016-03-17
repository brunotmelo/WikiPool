package dataTypes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.Assert;
import org.junit.Test;

public class TestParseTimestamp {

	private final String TIME_STAMP = "2015-09-14T21:38:35Z";
	private final String EXPECTED_DATE = "2015-09-14";
	private final String EXPECTED_TIME = "21:38:35";
	
	
	@Test
	public void testParseDate(){
		Instant instant = Instant.parse(TIME_STAMP);
		// use ZoneId.systemDefault(); for system localization
		LocalDate date = instant.atZone(ZoneId.of("UTC")).toLocalDate();
		
		Assert.assertEquals(EXPECTED_DATE, date.toString());
		
	}
	
	@Test
	public void testParseTime(){
		Instant instant = Instant.parse(TIME_STAMP);
		LocalTime time = instant.atZone(ZoneId.of("UTC")).toLocalTime();
		
		Assert.assertEquals(EXPECTED_TIME, time.toString());
	}
	
	
	
	
}
