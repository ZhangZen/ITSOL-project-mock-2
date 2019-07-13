package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05SalaryBO;
import com.itsol.eas.dao.Intern05SalaryDAO;
import com.itsol.eas.dto.Intern05SalaryDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05SalaryBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05SalaryBusinessImpl extends
		BaseFWBusinessImpl<Intern05SalaryDAO, Intern05SalaryDTO, Intern05SalaryBO> implements Intern05SalaryBusiness {

	@Autowired
	private Intern05SalaryDAO intern05SalaryDAO;

	public Intern05SalaryBusinessImpl() {
		tModel = new Intern05SalaryBO();
		tDAO = intern05SalaryDAO;
	}

	@Override
	public Intern05SalaryDAO gettDAO() {
		return intern05SalaryDAO;
	}

	@Override
	public long count() {
		return intern05SalaryDAO.count("Intern05SalaryBO", null);
	}

	@Override
	public List<Intern05SalaryDTO> getAll() {
		return intern05SalaryDAO.getAll();
	}

	public Intern05SalaryDTO getOneById(Long saLevel) {
		return intern05SalaryDAO.getOneById(saLevel);
	}
}
