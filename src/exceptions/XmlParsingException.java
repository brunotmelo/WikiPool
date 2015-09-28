package exceptions;

public class XmlParsingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public XmlParsingException(){
		super();
	}

	public XmlParsingException(String cause){
		super(cause);
	}
}
