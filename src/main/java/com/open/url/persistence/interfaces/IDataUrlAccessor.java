package main.java.com.open.url.persistence.interfaces;

import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.pojos.UrlResponse;

public interface IDataUrlAccessor {
	
	public void save (UrlResponse url) throws UrlShortenerException;
	
	public UrlResponse get(String s) throws UrlShortenerException;
	
	

}
