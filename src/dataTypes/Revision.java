package dataTypes;

import java.time.LocalDate;
import java.time.LocalTime;

import dataTypes.util.DateFormatter;
import dataTypes.util.TimeFormatter;

public class Revision {

	private String author;
	private LocalDate changeDate;
	private LocalTime changeTime;
	private String comment;
	
	public Revision(String author, LocalDate changeDate, LocalTime time, String comment){
		this.author = author;
		this.changeDate = changeDate;
		this.changeTime = time;
		this.comment = comment;
	}
	
	//constructor that gets needed xml automatically from document
	
	public String getFormattedDate(){
		DateFormatter df = new DateFormatter(changeDate);
		return df.format();		
	}
	
	public String getFormattedTime(){
		TimeFormatter tf = new TimeFormatter(changeTime);
		return tf.format();	
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getComment(){
		return comment;
	}
	
}
