package dataTypes.util;

import java.time.LocalTime;

public class TimeFormatter {
	LocalTime time;
	
	public TimeFormatter(LocalTime time){
		this.time = time;
	}
	
	public String format(){
		int hour =  time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		
		return hour + ":" + minute + ":" + second;
	}
	
	
}
