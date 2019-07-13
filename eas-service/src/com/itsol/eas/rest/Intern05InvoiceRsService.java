package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05InvoiceDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Intern05InvoiceRsService {

    @GET
    @Path("/intern05Invoice")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getIntern05Invoice();
       
//    @GET
//    @Path("/intern05Invoice/{id}")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getIntern05InvoiceById(@PathParam("id") Long id);
//    

    @POST
    @Path("/intern05Invoice/search")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response doSearch(Intern05InvoiceDTO obj);
    
    
    @POST
    @Path("/intern05Invoice/")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addIntern05Invoice(Intern05InvoiceDTO obj);

}
