package dataTypes;


import java.time.LocalTime;



import org.junit.Assert;
import org.junit.Test;


public class TestTime {
	
	private final int EXPECTED_HOURS = 21;
	private final int EXPECTED_MINUTES = 38;
	private final int EXPECTED_SECONDS = 35;

	@Test
	public void testConstruction() {
		LocalTime time = LocalTime.of(EXPECTED_HOURS, EXPECTED_MINUTES, EXPECTED_SECONDS);
		assertExpectedOutput(time);
	}
	
	private void assertExpectedOutput(LocalTime time){
		Assert.assertEquals(time.getHour(), EXPECTED_HOURS);
		Assert.assertEquals(time.getMinute(), EXPECTED_MINUTES);
		Assert.assertEquals(time.getSecond(), EXPECTED_SECONDS);
	}

}
