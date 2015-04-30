package com.practice.controller.server;



import com.practice.controller.dao.Dao;
import com.practice.controller.dao.ResponseObject;
import com.practice.controller.dao.ToDoItems;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.TEXT_HTML;

/**
 * Created by abhi.pandey on 9/21/14.
 */
@Path( "stuff" )
public class StuffService {

	private Dao<String> dao;

	@Inject
	public StuffService( Dao<String> dao ) {
		this.dao = dao;
	}

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public String getAll() {
		System.out.println( "Requested to get All" );
		String html = "<h2>All stuff</h2><ul>";
		for ( ResponseObject stuff : dao.get("") ) {
			html += "<li>" + stuff + "</li>";
		}
		html += "</ul>";
		return html;
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public String getById( @PathParam( "id" ) String id ) {
		System.out.println( "Requested to get ID = " + id );
		String stuff = dao.getById( id );
		if ( stuff == null ) return notFound();
		else return stuff;
	}

	private String notFound() {
		return "<html><body><div>Not Found</div></body></html>";
	}

}
