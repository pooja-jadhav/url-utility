package main.java.com.open.url.persistence;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import main.java.com.open.url.command.error.ErrorData;
import main.java.com.open.url.command.error.UrlShortenerError;
import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.persistence.interfaces.IDataUrlAccessor;
import main.java.com.open.url.persistence.redis.RedisClientManager;
import main.java.com.open.url.pojos.UrlResponse;

public class URLDataAccessor implements IDataUrlAccessor {

	@Override
	public void save(UrlResponse url) throws UrlShortenerException{
		try{
		JedisPool pool = RedisClientManager.getInstance().getConnection();
		Jedis jedis = pool.getResource();
		
		jedis.hset(url.getShortURL(), "longUrl", url.getLongURL());
		jedis.hset(url.getShortURL(), "lastmodified", String.valueOf(System.currentTimeMillis()));
		jedis.bgsave();
		}
		catch(Exception e){
			UrlShortenerException exception = new UrlShortenerException(new ErrorData(UrlShortenerError.SERVER_ERROR, "HIGH", 500));
			throw exception;
		}
		
	}

	@Override
	public UrlResponse get (String s) throws UrlShortenerException{
		UrlResponse  url = new UrlResponse();
		try{
		JedisPool pool = RedisClientManager.getInstance().getConnection();
		Jedis jedis = pool.getResource();;
		
		String longUrl = jedis.hget(s, "longUrl");
		url.setLongURL(longUrl);
		url.setShortURL(s);
		}
		catch(Exception e){
			UrlShortenerException exception = new UrlShortenerException(new ErrorData(UrlShortenerError.SERVER_ERROR, "HIGH", 500));
			throw exception;
		}
		
		return url;
	}

}
