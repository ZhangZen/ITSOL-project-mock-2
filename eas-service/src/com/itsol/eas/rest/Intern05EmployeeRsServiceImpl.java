/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.rest;

import com.itsol.eas.business.Intern05EmployeeBusinessImpl;
import com.itsol.eas.dto.Intern05EmployeeDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author BuiBaTruong
 */
public class Intern05EmployeeRsServiceImpl implements Intern05EmployeeRsService {

	protected final Logger log = Logger.getLogger(Intern05EmployeeRsService.class);
	@Autowired
	Intern05EmployeeBusinessImpl intern05EmployeeBusinessImpl;

	@Override
	public Response getIntern05Employee() {
		List<Intern05EmployeeDTO> ls = intern05EmployeeBusinessImpl.getAll();
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
	public Response getIntern05CitiesName() {
		List<String> ls = intern05EmployeeBusinessImpl.getAllCitiesName();
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

	// @Override
	// public Response getIntern05CitiesNameString() {
	// String ls = intern05EmployeeBusinessImpl.getAllCitiesNameString();
	// if (ls == null) {
	// return Response.status(Response.Status.BAD_REQUEST).build();
	// } else {
	// return Response.ok(ls).build();
	// }
	// }

	@Override
	public Response getIntern05EthnicName() {
		List<String> ls = intern05EmployeeBusinessImpl.getAllEthnicName();
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
	public Response getIntern05EmployeeById(Long id) {
		Intern05EmployeeDTO obj = (Intern05EmployeeDTO) intern05EmployeeBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}
	}

	@Override
	public Response getIntern05EmployeeByName(String name) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByName(name);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response getIntern05EmployeeByHometown(String hometown) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByHometown(hometown);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response getIntern05EmployeeByDepartment(String department) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByDepartment(department);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response getIntern05EmployeeByPosition(String position) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByPosition(position);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response getIntern05EmployeeByLiteracy(String literacy) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByLiteracy(literacy);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response getIntern05EmployeeBySalaryRate(Float salaryRate) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getBySalaryRate(salaryRate);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}

	}

	@Override
	public Response getIntern05EmployeeByBirthday(String birthday) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByBirthday(birthday);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response getIntern05EmployeeByStartedDate(String startedDate) {
		List<Intern05EmployeeDTO> list = intern05EmployeeBusinessImpl.getByStartedDate(startedDate);
		if (list == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(list).build();
		}
	}

	@Override
	public Response updateIntern05Employee(Intern05EmployeeDTO employee) {
		Long id = intern05EmployeeBusinessImpl.update(employee);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok().build();
		}

	}

	@Override
	public Response searchIntern05Employee(Intern05EmployeeDTO employee) {
		List<Intern05EmployeeDTO> obj = intern05EmployeeBusinessImpl.search(employee);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(obj).build();
		}

	}

	@Override
	public Response addIntern05Employee(Intern05EmployeeDTO employee) {
		Long id = intern05EmployeeBusinessImpl.save(employee);
		if (id == 0l) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(Response.Status.CREATED).build();
		}
	}

	@Override
	public Response deleteIntern05Employee(Long id) {
		Intern05EmployeeDTO obj = (Intern05EmployeeDTO) intern05EmployeeBusinessImpl.getOneById(id);
		if (obj == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			intern05EmployeeBusinessImpl.delete(obj);
			return Response.ok(Response.Status.NO_CONTENT).build();
		}
	}
}
