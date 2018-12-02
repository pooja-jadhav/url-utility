package main.java.com.open.url.persistence.redis;

import java.time.Duration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClientManager {
	
	private static RedisClientManager instance = new RedisClientManager();
	private static JedisPool config = connect();
	
	public static RedisClientManager getInstance(){
		return instance;
	}
	
	public JedisPool getConnection(){
		return config;
	}
			
	private static JedisPool connect(){
		JedisPool jedisPool = new JedisPool(buildPoolConfig(), "localhost");
		 return jedisPool;
	
	}
	
	private static JedisPoolConfig buildPoolConfig() {
	    final JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(128);
	    poolConfig.setMaxIdle(128);
	    poolConfig.setMinIdle(16);
	    poolConfig.setTestOnBorrow(true);
	    poolConfig.setTestOnReturn(true);
	    poolConfig.setTestWhileIdle(true);
	    poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
	    poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
	    poolConfig.setNumTestsPerEvictionRun(3);
	    poolConfig.setBlockWhenExhausted(true);
	    return poolConfig;
	}

}
