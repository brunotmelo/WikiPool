package parsers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.w3c.dom.Node;

public class RevisionNodeParser {
	
	private Node revision;
	
	public RevisionNodeParser(Node revision){
		this.revision = revision;
	}
	
	public String parseAuthor(){
		return revision.getAttributes().getNamedItem("user").getNodeValue();
	}
	
	public String parseComment(){
		try{
			return revision.getAttributes().getNamedItem("comment").getNodeValue();
		}catch(NullPointerException e){
			return null;
		}

	}
	
	public LocalDate parseDate(){
		Instant dateInstant = getTimeStampInstant();
		// use ZoneId.systemDefault(); for system localization
		return dateInstant.atZone(ZoneId.of("UTC")).toLocalDate();
	}
	
	public LocalTime parseTime(){
		Instant timeInstant = getTimeStampInstant();
		return timeInstant.atZone(ZoneId.of("UTC")).toLocalTime();
	}
	
	private Instant getTimeStampInstant(){
		String timestamp = revision.getAttributes().getNamedItem("timestamp").getNodeValue();
		return Instant.parse(timestamp);
	}
	

	
	
}
