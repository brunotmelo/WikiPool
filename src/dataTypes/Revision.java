package dataTypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Revision {

	private String author;
	private LocalDate changeDate;
	private LocalTime changeTime;
	private String comment;
	//dates should be dates... only author is a string
	
	public Revision(String author, LocalDate changeDate, LocalTime time, String comment){
		this.author = author;
		this.changeDate = changeDate;
		this.changeTime = time;
		this.comment = comment;
		
	}
	
	public void setDate(LocalDate date){
		this.changeDate = date;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
	
	
	public String getFormattedDate(){
		int month =  changeDate.getMonthValue();
		int day = changeDate.getDayOfMonth();
		int year = changeDate.getYear();
		
		return month + " " + day + " " + year;
		
		
	}
	
	
	
	public String getAuthor(){
		return author;
	}
	
	public int getDay(){
		return changeDate.getDayOfMonth();
	}
	
	public String getComment(){
		return comment;
	}
	
}
