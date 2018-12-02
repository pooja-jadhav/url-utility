package main.java.com.open.url.command.error;

public final class UrlShortenerError {
	
	
	
	public static final UrlShortenerError INCORRECT_INPUT = new UrlShortenerError(1, "Incorrect Input", "Please change your input and retry");
	public static final UrlShortenerError SERVER_ERROR = new UrlShortenerError(2, "Server Error", "Please try again later");

	private int id;
	private String message;
	private String action;
	
	public UrlShortenerError (int id, String message, String correctiveAction){
		this.id = id;
		this.message = message;
		this.action = correctiveAction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
