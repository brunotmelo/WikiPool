package exceptions;

public class WikipediaConnectionException extends RuntimeException{
	
	public WikipediaConnectionException(){
		super();
	}
	
	public WikipediaConnectionException(String cause){
		super(cause);
	}
	
}
