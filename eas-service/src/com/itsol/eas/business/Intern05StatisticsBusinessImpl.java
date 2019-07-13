package com.itsol.eas.business;

import com.itsol.eas.dao.Intern05StatisticsDAO;
import com.itsol.eas.dto.Intern05StatisticsDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("intern05StatisticsBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05StatisticsBusinessImpl {

	@Autowired
	private Intern05StatisticsDAO statisticDAO;

	public List<Intern05StatisticsDTO> getAll() {
		return statisticDAO.getAll();
	}

	public List<Intern05StatisticsDTO> doSearch(Intern05StatisticsDTO searchObj) {
		return statisticDAO.doSearch(searchObj);
	}

	public Intern05StatisticsDTO getByImId(Long imId) {
		return statisticDAO.getByImId(imId);
	}

	public List<Intern05StatisticsDTO> getAllProduct() {
		return statisticDAO.getAllProduct();
	}
}
