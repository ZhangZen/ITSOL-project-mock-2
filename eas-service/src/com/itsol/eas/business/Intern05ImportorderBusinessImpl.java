package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05ImportorderBO;
import com.itsol.eas.dao.Intern05ImportorderDAO;
import com.itsol.eas.dto.Intern05ImportorderDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05ImportorderBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05ImportorderBusinessImpl
		extends BaseFWBusinessImpl<Intern05ImportorderDAO, Intern05ImportorderDTO, Intern05ImportorderBO>
		implements Intern05ImportorderBusiness {

	@Autowired
	private Intern05ImportorderDAO intern05ImportorderDAO;

	public Intern05ImportorderBusinessImpl() {
		tModel = new Intern05ImportorderBO();
		tDAO = intern05ImportorderDAO;
	}

	@Override
	public Intern05ImportorderDAO gettDAO() {
		return intern05ImportorderDAO;
	}

	public List<Intern05ImportorderDTO> getAll() {
		return intern05ImportorderDAO.getAllIm();
	}

	public Intern05ImportorderDTO getById(Long id) {
		return intern05ImportorderDAO.getById(id);
	}

	public List<Intern05ImportorderDTO> doSearch(Intern05ImportorderDTO searchObj) {
		return intern05ImportorderDAO.doSearch(searchObj);
	}
	//
	// public List<Intern05ImportorderDTO> getByEmName(String emName) {
	// return intern05ImportorderDAO.getByEmName(emName);
	// }
	//
	// public List<Intern05ImportorderDTO> getBySuName(String suName) {
	// return intern05ImportorderDAO.getBySuName(suName);
	// }
	//
	// public List<Intern05ImportorderDTO> getByCreateDate(String date) {
	// return intern05ImportorderDAO.getByCreateDate(date);
	// }
	//

	@Override
	public long count() {
		return intern05ImportorderDAO.count("Intern05ImportorderBO", null);
	}

	public List<Intern05ImportorderDTO> getAllSupplier() {
		return intern05ImportorderDAO.getAllSu();
	}

}
