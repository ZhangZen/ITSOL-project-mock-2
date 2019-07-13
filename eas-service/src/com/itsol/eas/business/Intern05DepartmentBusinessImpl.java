package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05DepartmentBO;
import com.itsol.eas.dao.Intern05DepartmentDAO;
import com.itsol.eas.dto.Intern05DepartmentDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05DepartmentBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05DepartmentBusinessImpl
		extends BaseFWBusinessImpl<Intern05DepartmentDAO, Intern05DepartmentDTO, Intern05DepartmentBO>
		implements Intern05DepartmentBusiness {

	@Autowired
	private Intern05DepartmentDAO intern05DepartmentDAO;

	public Intern05DepartmentBusinessImpl() {
		tModel = new Intern05DepartmentBO();
		tDAO = intern05DepartmentDAO;
	}

	@Override
	public Intern05DepartmentDAO gettDAO() {
		return intern05DepartmentDAO;
	}

	@Override
	public long count() {
		return intern05DepartmentDAO.count("Intern05DepartmentBO", null);
	}

	@Override
	public List<Intern05DepartmentDTO> getAll() {
		return intern05DepartmentDAO.getAll();
	}

	public Intern05DepartmentDTO getOneByName(String name) {
		return intern05DepartmentDAO.getOneByName(name);
	}
}
