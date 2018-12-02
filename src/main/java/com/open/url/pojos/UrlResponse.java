package main.java.com.open.url.pojos;

public class UrlResponse {

	private String longURL;
	private String shortURL;
	private long timesamp; 
	
	public long getTimesamp() {
		return timesamp;
	}
	public void setTimesamp(long timesamp) {
		this.timesamp = timesamp;
	}
	public String getLongURL() {
		return longURL;
	}
	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	
	
}
