package main.java.com.open.url.command;

import main.java.com.open.url.command.error.ErrorData;
import main.java.com.open.url.command.error.UrlShortenerError;
import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.command.interfaces.ICommand;
import main.java.com.open.url.persistence.URLDataAccessor;
import main.java.com.open.url.persistence.interfaces.IDataUrlAccessor;
import main.java.com.open.url.pojos.UrlRequest;
import main.java.com.open.url.pojos.UrlResponse;

public class URLRedirectCommand implements ICommand {

	
	@Override
	public UrlResponse execute(UrlRequest s) throws UrlShortenerException{
		normalize(s);
	
		UrlResponse url = new UrlResponse();
		url.setShortURL(s.getUrl());
		
		accessData(url);

		return url;
	}

	@Override
	public void normalize(UrlRequest s) throws UrlShortenerException{
		if(s == null || s.getUrl() == null || s.getUrl().isEmpty())
		{
			UrlShortenerException exception = new UrlShortenerException(
					new ErrorData(UrlShortenerError.INCORRECT_INPUT, "MEDIUM",
							400));
			throw exception;
		}
		
	}

	@Override
	public void accessData(UrlResponse url) throws UrlShortenerException{
		IDataUrlAccessor accessor = new URLDataAccessor();
		UrlResponse urlNew = accessor.get(url.getShortURL());
		url.setLongURL(urlNew.getLongURL());
	}

}
