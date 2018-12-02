package test.java.com.open.url.persistence;

import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.persistence.URLDataAccessor;
import main.java.com.open.url.pojos.UrlResponse;

import org.junit.Assert;

public class URLDataAccessorTest {
	
	//@Test
	public void setTest(){
		URLDataAccessor dataAcc = new URLDataAccessor();
		UrlResponse u = new UrlResponse();
		u.setLongURL("http://www.goog.com/3909090g/48gjdkj942");
		u.setShortURL("http://localhost:8080/urlShortener/342jiojfj");
		u.setTimesamp(System.currentTimeMillis());
		try {
			dataAcc.save(u);
		} catch (UrlShortenerException e) {
			Assert.assertEquals(e==null, true);
		}
		
	}
	
	//@Test
	public void getTest(){
		URLDataAccessor dataAcc = new URLDataAccessor();
		try {
			dataAcc.get("http://localhost:8080/urlShortener/342jiojfj");
		} catch (UrlShortenerException e) {
			Assert.assertEquals(e==null, true);
		}
		
	}

}
