package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05ProductDTO;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Intern05ProductRsService {
	
    @GET
    @Path("/intern05Product/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getIntern05ProductById(@PathParam("id") Long id);

    @PUT
    @Path("/intern05Product/")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateIntern05Product(List<Intern05ProductDTO> listObj);
    
}
