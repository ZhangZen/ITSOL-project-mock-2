package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05ExportorderBO;
import com.itsol.eas.dao.Intern05ExportorderDAO;
import com.itsol.eas.dto.Intern05ExportorderDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05ExportorderBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05ExportorderBusinessImpl
		extends BaseFWBusinessImpl<Intern05ExportorderDAO, Intern05ExportorderDTO, Intern05ExportorderBO>
		implements Intern05ExportorderBusiness {

	@Autowired
	private Intern05ExportorderDAO intern05ExportorderDAO;

	public Intern05ExportorderBusinessImpl() {
		tModel = new Intern05ExportorderBO();
		tDAO = intern05ExportorderDAO;
	}

	@Override
	public Intern05ExportorderDAO gettDAO() {
		return intern05ExportorderDAO;
	}

	public List<Intern05ExportorderDTO> getAllEX() {
		return intern05ExportorderDAO.getAllEX();
	}

	public Intern05ExportorderDTO getById(Long id) {
		return intern05ExportorderDAO.getById(id);
	}

	public List<Intern05ExportorderDTO> getPrcategory() {
		return intern05ExportorderDAO.getPrcategory();
	}

	public List<Intern05ExportorderDTO> doSearch(Intern05ExportorderDTO searchObj) {
		return intern05ExportorderDAO.doSearch(searchObj);
	}
	//
	// public List<Intern05ExportorderDTO> getByPrCategory(String name) {
	// return intern05ExportorderDAO.getByPrCategory(name);
	// }
	//
	// public List<Intern05ExportorderDTO> getByEmName(String name) {
	// return intern05ExportorderDAO.getByEmName(name);
	// }
	//
	// public List<Intern05ExportorderDTO> getByCreateDate(String date) {
	// return intern05ExportorderDAO.getByCreateDate(date);
	// }

	public List<Intern05ExportorderDTO> getAllPrCategory() {
		return intern05ExportorderDAO.getPrcategory();
	}

	@Override
	public long count() {
		return intern05ExportorderDAO.count("Intern05ExportorderBO", null);
	}

	public List<Intern05ExportorderDTO> getEmployee() {
		return intern05ExportorderDAO.getEmployee();
	}

	public List<Intern05ExportorderDTO> getByPrcId(Long prcId) {
		return intern05ExportorderDAO.getProductListByPrcId(prcId);
	}

	public Intern05ExportorderDTO getByPrId(Long prId) {
		return intern05ExportorderDAO.getPrcListByPrId(prId);
	}

}
