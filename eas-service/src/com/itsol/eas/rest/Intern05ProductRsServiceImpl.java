package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05ProductBusinessImpl;
import com.itsol.eas.dto.Intern05ProductDTO;

import java.util.List;

import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Intern05ProductRsServiceImpl implements Intern05ProductRsService {

    protected final Logger log = Logger.getLogger(Intern05ProductRsServiceImpl.class);
    @Autowired
    Intern05ProductBusinessImpl intern05ProductBusinessImpl;

    @Override
    public Response getIntern05ProductById(Long id) {
        Intern05ProductDTO obj = (Intern05ProductDTO) intern05ProductBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(obj).build();
        }
    }

    public Response updateIntern05Product(List<Intern05ProductDTO> listObj) {
    	Long id = null;
    	for(Intern05ProductDTO obj :listObj ) {
    		id = intern05ProductBusinessImpl.update(obj);
    		System.out.println("update san pham");
    	}        
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok().build();
        }

    }
}
