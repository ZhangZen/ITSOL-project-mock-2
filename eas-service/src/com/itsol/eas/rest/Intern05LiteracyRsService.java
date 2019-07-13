/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05LiteracyDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author BuiBaTruong
 */
public interface Intern05LiteracyRsService {

	@GET
	@Path("/intern05Literacy/getAll")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05Literacy();

	@GET
	@Path("/intern05Literacy/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05LiteracyById(@PathParam("id") Long id);
	
	@GET
	@Path("/intern05Literacy/searchByName/{name}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05LiteracyByName(@PathParam("name") String name);

	@PUT
	@Path("/intern05Literacy/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateIntern05Literacy(Intern05LiteracyDTO obj);

	@POST
	@Path("/intern05Literacy/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addIntern05Literacy(Intern05LiteracyDTO obj);

	@DELETE
	@Path("/intern05Literacy/{id}/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteIntern05Literacy(@PathParam("id") Long id);
}
