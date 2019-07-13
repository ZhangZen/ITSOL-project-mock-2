package com.itsol.eas.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itsol.eas.dto.Intern05StatisticsDTO;

public interface Intern05StatisticsRsService {

	// @GET
	// @Path("/intern05Statistics")
	// @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// public Response getintern05Statistics();

	@GET
	@Path("/getAllStatistics")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllSta();

	@GET
	@Path("/getAllProduct")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllProduct();

	@GET
	@Path("/getByImId/{imId}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getByImId(@PathParam("imId") Long imId);

	@POST
	@Path("/doSearch")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response doSearch(Intern05StatisticsDTO searchObj);

}