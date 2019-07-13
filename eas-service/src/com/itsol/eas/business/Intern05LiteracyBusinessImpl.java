package com.itsol.eas.business;

import com.itsol.eas.bo.Intern05LiteracyBO;
import com.itsol.eas.dao.Intern05LiteracyDAO;
import com.itsol.eas.dto.Intern05LiteracyDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05LiteracyBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05LiteracyBusinessImpl
		extends BaseFWBusinessImpl<Intern05LiteracyDAO, Intern05LiteracyDTO, Intern05LiteracyBO>
		implements Intern05LiteracyBusiness {

	@Autowired
	private Intern05LiteracyDAO intern05LiteracyDAO;

	public Intern05LiteracyBusinessImpl() {
		tModel = new Intern05LiteracyBO();
		tDAO = intern05LiteracyDAO;
	}

	@Override
	public Intern05LiteracyDAO gettDAO() {
		return intern05LiteracyDAO;
	}

	@Override
	public long count() {
		return intern05LiteracyDAO.count("Intern05LiteracyBO", null);
	}

	@Override
	public List<Intern05LiteracyDTO> getAll() {
		return intern05LiteracyDAO.getAll();
	}

	public Intern05LiteracyDTO getOneByName(String name) {
		return intern05LiteracyDAO.getOneByName(name);
	}
}
