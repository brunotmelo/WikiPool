package exceptions;

public class XmlParsingException extends RuntimeException {

	public XmlParsingException(){
		super();
	}

	public XmlParsingException(String cause){
		super(cause);
	}

}
