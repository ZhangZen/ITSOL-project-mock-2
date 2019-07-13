/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05PositionBusinessImpl;
import com.itsol.eas.dto.Intern05PositionDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author BuiBaTruong
 */
public class Intern05PositionRsServiceImpl implements Intern05PositionRsService {

	protected final Logger log = Logger.getLogger(Intern05PositionRsService.class);
	@Autowired
	Intern05PositionBusinessImpl intern05PositionBusinessImpl;

	@Override
	public Response getIntern05Position() {
		List<Intern05PositionDTO> ls = intern05PositionBusinessImpl.getAll();
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
	public Response getIntern05PositionById(Long id) {
		Intern05PositionDTO obj = (Intern05PositionDTO) intern05PositionBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}
	
	@Override
	public Response getIntern05PositionByName(String name) {
		Intern05PositionDTO obj = (Intern05PositionDTO) intern05PositionBusinessImpl.getOneByName(name);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response updateIntern05Position(Intern05PositionDTO obj) {
		Long id = intern05PositionBusinessImpl.update(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response addIntern05Position(Intern05PositionDTO obj) {
		Long id = intern05PositionBusinessImpl.save(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Position(Long id) {
		Intern05PositionDTO obj = (Intern05PositionDTO) intern05PositionBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05PositionBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}
}
