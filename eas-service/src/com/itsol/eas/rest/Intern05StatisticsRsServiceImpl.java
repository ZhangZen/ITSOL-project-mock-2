package com.itsol.eas.rest;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.itsol.eas.business.Intern05StatisticsBusinessImpl;
import com.itsol.eas.dto.Intern05StatisticsDTO;

public class Intern05StatisticsRsServiceImpl implements Intern05StatisticsRsService {

	@Autowired
	private Intern05StatisticsBusinessImpl intern05StatisticsBusinessImpl;

	@Override
	public Response getAllSta() {
		List<Intern05StatisticsDTO> ls = intern05StatisticsBusinessImpl.getAll();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(ls).build();
		}
	}

	@Override
	public Response getByImId(Long imId) {
		Intern05StatisticsDTO ls = intern05StatisticsBusinessImpl.getByImId(imId);
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(ls).build();
		}
	}

	@Override
	public Response doSearch(Intern05StatisticsDTO searchObj) {
		List<Intern05StatisticsDTO> ls = intern05StatisticsBusinessImpl.doSearch(searchObj);
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(ls).build();
		}
	}

	@Override
	public Response getAllProduct() {
		List<Intern05StatisticsDTO> ls = intern05StatisticsBusinessImpl.getAllProduct();
		if (ls == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(ls).build();
		}
	}

}
