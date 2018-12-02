package main.java.com.open.url.urlshortener.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import main.java.com.open.url.command.URLShortenerCommand;
import main.java.com.open.url.command.error.ErrorData;
import main.java.com.open.url.command.error.UrlShortenerError;
import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.command.interfaces.ICommand;
import main.java.com.open.url.pojos.UrlRequest;
import main.java.com.open.url.pojos.UrlResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Path("/url")
public class URLResource {
	
	  @POST
	  @Consumes("application/json")
	  @Produces("application/json")
	  public Response shortifyURL(UrlRequest request) {
		
		ICommand command = new URLShortenerCommand();
		String response = null;
		ErrorData errorData = null;
		
		try {
		String s = request.getUrl();
		request.setUrl(s);
		UrlResponse url = command.execute(request);
		ObjectMapper objectMapper = new ObjectMapper();
		
		response = objectMapper.writeValueAsString(url);
		} catch (JsonGenerationException e) {
			errorData = new ErrorData(UrlShortenerError.SERVER_ERROR, "HIGH", 500);
		} catch (JsonMappingException e) {
			errorData = new ErrorData(UrlShortenerError.SERVER_ERROR, "HIGH", 500);
		} catch (IOException e) {
			errorData = new ErrorData(UrlShortenerError.SERVER_ERROR, "HIGH", 500);
		}
		catch (UrlShortenerException e) {
			errorData = e.getErrorData();
		}
		
		if(errorData != null){
			return Response.status(errorData.getStatus()).entity(response).build();
					 
		}
		return Response.status(200).entity(response).build();
	  }
	  
	  
	 
	  
	  

}
