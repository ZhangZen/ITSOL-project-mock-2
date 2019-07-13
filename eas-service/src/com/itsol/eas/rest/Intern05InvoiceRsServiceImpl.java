package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05InvoiceBusinessImpl;
import com.itsol.eas.dto.Intern05InvoiceDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Intern05InvoiceRsServiceImpl implements Intern05InvoiceRsService {

    protected final Logger log = Logger.getLogger(Intern05InvoiceRsServiceImpl.class);
    
    @Autowired
    Intern05InvoiceBusinessImpl intern05InvoiceBusinessImpl;

    @Override
    public Response getIntern05Invoice() {
    	List<Intern05InvoiceDTO> ls = intern05InvoiceBusinessImpl.getAllInvoice();
        if (ls == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
        	return Response.ok(ls).build();
        }
    }
  
    
    //search
    @Override
    public Response doSearch(Intern05InvoiceDTO obj) {
    	log.info("log ");
    	List<Intern05InvoiceDTO> ls = intern05InvoiceBusinessImpl.doSearch(obj);
        if (ls == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
        	return Response.ok(ls).build();
        }
    }
    
    @Override
    public Response addIntern05Invoice(Intern05InvoiceDTO obj) {
        Long id = intern05InvoiceBusinessImpl.save(obj);
        //System.out.println("invoiceIdaaaaaaaaaaaaaaaaa "+id);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(id).build();
        }
    }
}
