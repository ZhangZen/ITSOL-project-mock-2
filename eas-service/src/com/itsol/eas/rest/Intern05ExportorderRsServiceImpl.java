/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05ExportorderBusinessImpl;
import com.itsol.eas.dto.Intern05ExportorderDTO;

import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DATNQ
 */
public class Intern05ExportorderRsServiceImpl implements Intern05ExportorderRsService {

	protected final Logger log = Logger.getLogger(Intern05ExportorderRsServiceImpl.class);
	@Autowired
	Intern05ExportorderBusinessImpl intern05ExportorderBusinessImpl;

	@Override
	public Response getIntern05Exportorder() {
		List<Intern05ExportorderDTO> ls = intern05ExportorderBusinessImpl.getAll();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {

			return Response.ok(ls).build();
		}
	}

	public Response getById(Long id) {
		Intern05ExportorderDTO obj = (Intern05ExportorderDTO) intern05ExportorderBusinessImpl.getById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	// @Override
	// public Response getByPrName(String name) {
	// List<Intern05ExportorderDTO> obj =
	// intern05ExportorderBusinessImpl.getByPrName(name);
	// if (obj == null) {
	// return Response.status(Response.Status.BAD_REQUEST).build();
	// } else {
	// return Response.ok(obj).build();
	// }
	// }
	//
	// @Override
	// public Response getByEmName(String name) {
	// List<Intern05ExportorderDTO> obj =
	// intern05ExportorderBusinessImpl.getByEmName(name);
	// if (obj == null) {
	// return Response.status(Response.Status.BAD_REQUEST).build();
	// } else {
	// return Response.ok(obj).build();
	// }
	// }
	//
	// @Override
	// public Response getByCreateDate(String date) {
	// List<Intern05ExportorderDTO> obj =
	// intern05ExportorderBusinessImpl.getByCreateDate(date);
	// if (obj == null) {
	// return Response.status(Response.Status.BAD_REQUEST).build();
	// } else {
	// return Response.ok(obj).build();
	// }
	// }

	@Override
	public Response updateIntern05Exportorder(Intern05ExportorderDTO obj) {
		Long id = intern05ExportorderBusinessImpl.update(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response addIntern05Exportorder(Intern05ExportorderDTO obj) {
		Long id = intern05ExportorderBusinessImpl.save(obj);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Exportorder(Long id) {
		Intern05ExportorderDTO obj = (Intern05ExportorderDTO) intern05ExportorderBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05ExportorderBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}

	@Override
	public Response getAllEX() {
		List<Intern05ExportorderDTO> ls = intern05ExportorderBusinessImpl.getAllEX();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {

			return Response.ok(ls).build();
		}
	}

	@Override
	public Response doSearch(Intern05ExportorderDTO searchObj) {
		List<Intern05ExportorderDTO> obj = intern05ExportorderBusinessImpl.doSearch(searchObj);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response getAllPrcategory() {
		List<Intern05ExportorderDTO> ls = intern05ExportorderBusinessImpl.getPrcategory();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {

			return Response.ok(ls).build();
		}
	}

	@Override
	public Response getAllPrCa() {
		List<Intern05ExportorderDTO> ls = intern05ExportorderBusinessImpl.getAllPrCategory();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {

			return Response.ok(ls).build();
		}
	}

	@Override
	public Response getEmployee() {
		List<Intern05ExportorderDTO> ls = intern05ExportorderBusinessImpl.getEmployee();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {

			return Response.ok(ls).build();
		}
	}

	@Override
	public Response getProductListByPrcId(Long prcId) {
		List<Intern05ExportorderDTO> ls = intern05ExportorderBusinessImpl.getByPrcId(prcId);
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {

			return Response.ok(ls).build();
		}
	}

	@Override
	public Response getPrcListByPrId(Long prId) {
		Intern05ExportorderDTO obj = (Intern05ExportorderDTO) intern05ExportorderBusinessImpl.getByPrId(prId);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

}
