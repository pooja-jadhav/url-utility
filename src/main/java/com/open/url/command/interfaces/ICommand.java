package main.java.com.open.url.command.interfaces;

import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.pojos.UrlResponse;
import main.java.com.open.url.pojos.UrlRequest;

public interface ICommand {
	
	public UrlResponse execute (UrlRequest s) throws UrlShortenerException;
	
	public void normalize(UrlRequest s) throws UrlShortenerException;
	
	public void accessData(UrlResponse url) throws UrlShortenerException;
	
	

}
