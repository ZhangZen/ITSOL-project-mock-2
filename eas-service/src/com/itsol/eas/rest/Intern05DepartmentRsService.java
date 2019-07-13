/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05DepartmentDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author BuiBaTruong
 */
public interface Intern05DepartmentRsService {

	@GET
	@Path("/intern05Department/getAll")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05Department();

	@GET
	@Path("/intern05Department/searchById/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05DepartmentById(@PathParam("id") Long id);
	
	@GET
	@Path("/intern05Department/searchByName/{name}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05DepartmentByName(@PathParam("name") String name);

	@PUT
	@Path("/intern05Department/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateIntern05Department(Intern05DepartmentDTO obj);

	@POST
	@Path("/intern05Department/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addIntern05Department(Intern05DepartmentDTO obj);

	@DELETE
	@Path("/intern05Department/{id}/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteIntern05Department(@PathParam("id") Long id);
}
