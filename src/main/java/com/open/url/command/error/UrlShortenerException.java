package main.java.com.open.url.command.error;

public class UrlShortenerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 15098954L;
	private ErrorData errorData;
	
	public UrlShortenerException(ErrorData data){
		errorData = data;
	}
	
	public ErrorData getErrorData(){
		return errorData;
	}
	
	
	
}
