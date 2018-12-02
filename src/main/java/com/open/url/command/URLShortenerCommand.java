package main.java.com.open.url.command;

import main.java.com.open.url.command.error.ErrorData;
import main.java.com.open.url.command.error.UrlShortenerError;
import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.command.interfaces.ICommand;
import main.java.com.open.url.hash.HashManager;
import main.java.com.open.url.hash.UrlGenerator;
import main.java.com.open.url.persistence.URLDataAccessor;
import main.java.com.open.url.persistence.interfaces.IDataUrlAccessor;
import main.java.com.open.url.pojos.UrlResponse;
import main.java.com.open.url.pojos.UrlRequest;

public class URLShortenerCommand implements ICommand {

	public UrlResponse execute(UrlRequest s) throws UrlShortenerException {
		HashManager hashManager = new HashManager();
		normalize(s);

		UrlResponse url = new UrlResponse();
		String ss = hashManager.generateHash();

		UrlGenerator urlGenerator = new UrlGenerator(ss);
		String finalUrl = urlGenerator.getURL();
		url.setShortURL(finalUrl);
		url.setLongURL(s.getUrl());

		accessData(url);
		return url;
	}

	@Override
	public void normalize(UrlRequest s) throws UrlShortenerException {
		if (s == null || s.getUrl() == null || s.getUrl().isEmpty()) {
			UrlShortenerException exception = new UrlShortenerException(
					new ErrorData(UrlShortenerError.INCORRECT_INPUT, "MEDIUM",
							400));
			throw exception;
		}

	}

	@Override
	public void accessData(UrlResponse url) throws UrlShortenerException {
		IDataUrlAccessor accessor = new URLDataAccessor();
		accessor.save(url);

	}

}
