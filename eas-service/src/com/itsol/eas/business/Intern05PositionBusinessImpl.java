package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05PositionBO;
import com.itsol.eas.dao.Intern05PositionDAO;
import com.itsol.eas.dto.Intern05PositionDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05PositionBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05PositionBusinessImpl
		extends BaseFWBusinessImpl<Intern05PositionDAO, Intern05PositionDTO, Intern05PositionBO>
		implements Intern05PositionBusiness {

	@Autowired
	private Intern05PositionDAO intern05PositionDAO;

	public Intern05PositionBusinessImpl() {
		tModel = new Intern05PositionBO();
		tDAO = intern05PositionDAO;
	}

	@Override
	public Intern05PositionDAO gettDAO() {
		return intern05PositionDAO;
	}

	@Override
	public long count() {
		return intern05PositionDAO.count("Intern05PositionBO", null);
	}

	@Override
	public List<Intern05PositionDTO> getAll() {
		return intern05PositionDAO.getAll();
	}

	public Intern05PositionDTO getOneByName(String name) {
		return intern05PositionDAO.getOneByName(name);
	}

}
