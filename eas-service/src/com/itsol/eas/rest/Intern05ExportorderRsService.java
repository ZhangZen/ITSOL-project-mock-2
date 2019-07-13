/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05ExportorderDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author DATNQ
 */
public interface Intern05ExportorderRsService {

	@GET
	@Path("/intern05Exportorder")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getIntern05Exportorder();

	@GET
	@Path("/getAllEX")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllEX();

	@GET
	@Path("/getAllPrCa")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllPrCa();

	@GET
	@Path("/getAllPrcategory")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getAllPrcategory();

	@GET
	@Path("/getEmployee")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployee();

	@GET
	@Path("/findById/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getById(@PathParam("id") Long id);

	@GET
	@Path("/getProductListByPrcId/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getProductListByPrcId(@PathParam("id") Long prcId);

	@GET
	@Path("/getPrcListByPrId/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getPrcListByPrId(@PathParam("id") Long prId);

	@POST
	@Path("/doSearch")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response doSearch(Intern05ExportorderDTO searchObj);

	// @GET
	// @Path("/findByPrCategory/{prCategory}")
	// @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// public Response getByPrCategory(@PathParam("prCategory") String name);
	//
	// @GET
	// @Path("/findByEmName/{emName}")
	// @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// public Response getByEmName(@PathParam("emName") String name);

	// @GET
	// @Path("/findByCreateDate/{date}")
	// @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// public Response getByCreateDate(@PathParam("date") String date);

	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateIntern05Exportorder(Intern05ExportorderDTO obj);

	@POST
	@Path("/Create")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addIntern05Exportorder(Intern05ExportorderDTO obj);

	@DELETE
	@Path("/delete/{id}/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteIntern05Exportorder(@PathParam("id") Long id);
}
