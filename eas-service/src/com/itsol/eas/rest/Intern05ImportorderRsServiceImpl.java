/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05ImportorderBusinessImpl;
import com.itsol.eas.dto.Intern05ImportorderDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DATNQ
 */
public class Intern05ImportorderRsServiceImpl implements Intern05ImportorderRsService {

	protected final Logger log = Logger.getLogger(Intern05ImportorderRsServiceImpl.class);
	@Autowired
	Intern05ImportorderBusinessImpl intern05ImportorderBusinessImpl;

	@Override
	public Response getAll() {
		List<Intern05ImportorderDTO> ls = intern05ImportorderBusinessImpl.getAll();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(ls).build();
		}
	}

	@Override
	public Response updateIntern05Importorder(Intern05ImportorderDTO obj) {
		Long id = intern05ImportorderBusinessImpl.update(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response addIntern05Importorder(Intern05ImportorderDTO obj) {
		Long id = intern05ImportorderBusinessImpl.save(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Importorder(Long id) {
		Intern05ImportorderDTO obj = (Intern05ImportorderDTO) intern05ImportorderBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05ImportorderBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response getById(Long id) {
		Intern05ImportorderDTO obj = (Intern05ImportorderDTO) intern05ImportorderBusinessImpl.getById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response getAllSupplier() {
		List<Intern05ImportorderDTO> ls = intern05ImportorderBusinessImpl.getAllSupplier();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(ls).build();
		}
	}

	@Override
	public Response doSearch(Intern05ImportorderDTO searchObj) {
		List<Intern05ImportorderDTO> obj = intern05ImportorderBusinessImpl.doSearch(searchObj);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

}
