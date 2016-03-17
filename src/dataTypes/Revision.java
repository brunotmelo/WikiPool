package dataTypes;

import java.time.LocalDate;
import java.time.LocalTime;

import org.w3c.dom.Node;

import dataTypes.util.DateFormatter;
import dataTypes.util.TimeFormatter;
import parsers.RevisionNodeParser;

public class Revision {

	private String author;
	private LocalDate changeDate;
	private LocalTime changeTime;
	private String comment;
	
	public Revision(Node revision){
		RevisionNodeParser parser = new RevisionNodeParser(revision);
		this.author = parser.parseAuthor();
		this.changeDate = parser.parseDate();
		this.changeTime = parser.parseTime();
		this.comment = parser.parseComment();
	}
	
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
