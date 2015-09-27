package dataTypes;


import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class TestDate {
	
	private final int EXPECTED_YEAR = 2015;
	private final int EXPECTED_MONTH = 8;
	private final int EXPECTED_DAY = 31;
	
	@Test
	public void testConstruction(){
		LocalDate date = LocalDate.of(EXPECTED_YEAR, EXPECTED_MONTH, EXPECTED_DAY);
		assertExpectedDate(date);
	}
	
	private void assertExpectedDate(LocalDate date){
		Assert.assertEquals(EXPECTED_YEAR, date.getYear());
		Assert.assertEquals(EXPECTED_MONTH,date.getMonthValue());
		Assert.assertEquals(EXPECTED_DAY, date.getDayOfMonth());
	}
	
}
