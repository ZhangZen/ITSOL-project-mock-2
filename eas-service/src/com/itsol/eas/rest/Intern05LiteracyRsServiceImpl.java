/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05LiteracyBusinessImpl;
import com.itsol.eas.dto.Intern05LiteracyDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author BuiBaTruong
 */
public class Intern05LiteracyRsServiceImpl implements Intern05LiteracyRsService {

	protected final Logger log = Logger.getLogger(Intern05LiteracyRsService.class);
	@Autowired
	Intern05LiteracyBusinessImpl intern05LiteracyBusinessImpl;

	@Override
	public Response getIntern05Literacy() {
		List<Intern05LiteracyDTO> ls = intern05LiteracyBusinessImpl.getAll();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			DataListDTO data = new DataListDTO();
			data.setData(ls);
			data.setTotal(ls.size());
			data.setSize(ls.size());
			data.setStart(1);
			return Response.ok(data).build();
		}
	}

	@Override
	public Response getIntern05LiteracyById(Long id) {
		Intern05LiteracyDTO obj = (Intern05LiteracyDTO) intern05LiteracyBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}
	
	@Override
	public Response getIntern05LiteracyByName(String name) {
		Intern05LiteracyDTO obj = (Intern05LiteracyDTO) intern05LiteracyBusinessImpl.getOneByName(name);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response updateIntern05Literacy(Intern05LiteracyDTO obj) {
		Long id = intern05LiteracyBusinessImpl.update(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response addIntern05Literacy(Intern05LiteracyDTO obj) {
		Long id = intern05LiteracyBusinessImpl.save(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Literacy(Long id) {
		Intern05LiteracyDTO obj = (Intern05LiteracyDTO) intern05LiteracyBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05LiteracyBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}
}
