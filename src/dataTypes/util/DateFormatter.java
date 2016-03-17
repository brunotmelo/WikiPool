package dataTypes.util;

import java.time.LocalDate;

public class DateFormatter {

	LocalDate date;
	
	public DateFormatter(LocalDate date){
		this.date = date;
	}
	
	public String format(){
		int month =  date.getMonthValue();
		int day = date.getDayOfMonth();
		int year = date.getYear();
		
		return month + " " + day + " " + year;
	}
}
