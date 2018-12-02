package main.java.com.open.url.hash;

public class UrlGenerator {

	private static final String DOMAIN = "http://localhost:8080/urlShortner/";
	private static final String NUGGET = "u/";
	private String hash;
	public UrlGenerator (String hash){
		this.hash = hash;
	}
	
	public String getURL(){
		StringBuilder sb = new StringBuilder();
		sb.append(DOMAIN);
		sb.append(NUGGET);
		sb.append(hash);
		return sb.toString();
	}
}
