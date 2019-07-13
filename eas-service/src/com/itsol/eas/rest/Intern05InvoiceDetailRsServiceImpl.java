package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05InvoiceDetailBusinessImpl;
import com.itsol.eas.dto.Intern05InvoiceDetailDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Intern05InvoiceDetailRsServiceImpl implements Intern05InvoiceDetailRsService {

    protected final Logger log = Logger.getLogger(Intern05InvoiceDetailRsServiceImpl.class);
    @Autowired
    Intern05InvoiceDetailBusinessImpl intern05InvoiceDetailBusinessImpl;

    @Override
    public Response getInvoiceDetailByInvoiceId(Long invoiceId) {
        List<Intern05InvoiceDetailDTO> ls = intern05InvoiceDetailBusinessImpl.getInvoiceDetailByInvoiceId(invoiceId);
        if (ls == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {           
            return Response.ok(ls).build();
        }
    }
  
    public Response addIntern05InvoiceDetail(List<Intern05InvoiceDetailDTO> listObj) {
    	Long id = null;
    	for(Intern05InvoiceDetailDTO obj:listObj) {
    		id = intern05InvoiceDetailBusinessImpl.save(obj);
    		System.out.println(" them chi tiet hoa don");
    	}
        
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(Response.Status.CREATED).build();
        }
    }

//	public Response addIntern05InvoiceDetail(Intern05InvoiceDetailDTO obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
   
}
