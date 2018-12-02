package main.java.com.open.url.urlshortener.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import main.java.com.open.url.command.URLRedirectCommand;
import main.java.com.open.url.command.error.ErrorData;
import main.java.com.open.url.command.error.UrlShortenerException;
import main.java.com.open.url.command.interfaces.ICommand;
import main.java.com.open.url.pojos.UrlResponse;
import main.java.com.open.url.pojos.UrlRequest;

@Path("/u/{id}")
public class URLRedirectResource {
	@Context
	private HttpServletRequest httpRequest;

	@GET
	public Response redirect(@PathParam("id") String id) {

		StringBuffer sb = httpRequest.getRequestURL();
		ResponseBuilder builder = null;
		UrlRequest req = new UrlRequest();
		ErrorData errorData = null;
		try {
			ICommand command = new URLRedirectCommand();
			req.setUrl(sb.toString());
			UrlResponse url = command.execute(req);
			String output = url.getLongURL();

			URI uri;

			uri = new URI(output);
			builder = Response.temporaryRedirect(uri);

		} catch (URISyntaxException e) {
			errorData = new ErrorData(main.java.com.open.url.command.error.UrlShortenerError.SERVER_ERROR);
			
			e.printStackTrace();
		} catch (UrlShortenerException e) {
			errorData = e.getErrorData();
			
		}
		
		if(errorData != null){
			return Response.status(errorData.getStatus()).build();
					 
		}
		return builder.status(Status.TEMPORARY_REDIRECT).build();
	}
}
