/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05SalaryBusinessImpl;
import com.itsol.eas.dto.Intern05SalaryDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;

import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author BuiBaTruong
 */
public class Intern05SalaryRsServiceImpl implements Intern05SalaryRsService {

	protected final Logger log = Logger.getLogger(Intern05SalaryRsService.class);
	@Autowired
	Intern05SalaryBusinessImpl intern05SalaryBusinessImpl;

	@Override
	public Response getIntern05Salary() {
		List<Intern05SalaryDTO> ls = intern05SalaryBusinessImpl.getAll();
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
	public Response getIntern05SalaryById(Long saLevel) {
		Intern05SalaryDTO obj = (Intern05SalaryDTO) intern05SalaryBusinessImpl.getOneById(saLevel);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response updateIntern05Salary(Intern05SalaryDTO obj) {
		Long id = intern05SalaryBusinessImpl.update(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response addIntern05Salary(Intern05SalaryDTO obj) {
		Long id = intern05SalaryBusinessImpl.save(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Salary(Long id) {
		Intern05SalaryDTO obj = (Intern05SalaryDTO) intern05SalaryBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05SalaryBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}

}
