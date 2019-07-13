package com.itsol.eas.rest;

import com.itsol.eas.dto.Intern05InvoiceDetailDTO;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Intern05InvoiceDetailRsService {
	//get invoicedetail by invoiceId
    @GET
    @Path("/intern05InvoiceDetail/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getInvoiceDetailByInvoiceId(@PathParam("id") Long id);

    
    @POST
    @Path("/intern05InvoiceDetail/")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addIntern05InvoiceDetail(List<Intern05InvoiceDetailDTO> listObj);
   
}
