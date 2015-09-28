package exceptions;

public class WikipediaConnectionException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public WikipediaConnectionException(){
		super();
	}
	
	public WikipediaConnectionException(String cause){
		super(cause);
	}
}
