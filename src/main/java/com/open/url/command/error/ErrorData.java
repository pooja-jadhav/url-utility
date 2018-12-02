package main.java.com.open.url.command.error;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ErrorData {

    private Integer errorId;
    private String severity;
    private String message;
    private Integer status;
    private String correctiveAction;
    
    public ErrorData(){
    	
    }

    public ErrorData (UrlShortenerError error, String severity, Integer status){
    	this(error);
    	this.severity = severity;
    	this.status = status;
    }
    
    public ErrorData (UrlShortenerError error){
    	errorId = error.getId();
    	message = error.getMessage();
    	this.correctiveAction = error.getAction();
    }
    
    public Integer getStatus() {
		return status;
	}

	public String getCorrectiveAction() {
		return correctiveAction;
	}

	public void setCorrectiveAction(String correctiveAction) {
		this.correctiveAction = correctiveAction;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}