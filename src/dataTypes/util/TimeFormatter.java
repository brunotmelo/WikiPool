package dataTypes.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
	LocalTime time;
	
	public TimeFormatter(LocalTime time){
		this.time = time;
	}
	
	public String format(){
		return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
		
	}
	
	
}
