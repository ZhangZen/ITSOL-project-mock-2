/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05DepartmentBusinessImpl;
import com.itsol.eas.dto.Intern05DepartmentDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author BuiBaTruong
 */
public class Intern05DepartmentRsServiceImpl implements Intern05DepartmentRsService {

	protected final Logger log = Logger.getLogger(Intern05DepartmentRsService.class);
	@Autowired
	Intern05DepartmentBusinessImpl intern05DepartmentBusinessImpl;

	@Override
	public Response getIntern05Department() {
		List<Intern05DepartmentDTO> ls = intern05DepartmentBusinessImpl.getAll();
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
	public Response getIntern05DepartmentById(Long id) {
		Intern05DepartmentDTO obj = (Intern05DepartmentDTO) intern05DepartmentBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response getIntern05DepartmentByName(String name) {
		Intern05DepartmentDTO obj = (Intern05DepartmentDTO) intern05DepartmentBusinessImpl.getOneByName(name);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response updateIntern05Department(Intern05DepartmentDTO obj) {
		Long id = intern05DepartmentBusinessImpl.update(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response addIntern05Department(Intern05DepartmentDTO obj) {
		Long id = intern05DepartmentBusinessImpl.save(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Department(Long id) {
		Intern05DepartmentDTO obj = (Intern05DepartmentDTO) intern05DepartmentBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05DepartmentBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}
}
