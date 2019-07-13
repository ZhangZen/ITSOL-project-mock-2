/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05PositionDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author BuiBaTruong
 */
public interface Intern05PositionRsService {

	@GET
	@Path("/intern05Position/getAll")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05Position();

	@GET
	@Path("/intern05Position/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05PositionById(@PathParam("id") Long id);
	
	@GET
	@Path("/intern05Position/searchByName/{name}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05PositionByName(@PathParam("name") String name);

	@PUT
	@Path("/intern05Position/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateIntern05Position(Intern05PositionDTO obj);

	@POST
	@Path("/intern05Position/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addIntern05Position(Intern05PositionDTO obj);

	@DELETE
	@Path("/intern05Position/{id}/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteIntern05Position(@PathParam("id") Long id);
}
