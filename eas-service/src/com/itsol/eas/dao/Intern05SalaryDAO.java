/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.dto.Intern05SalaryDTO;
import com.itsol.eas.bo.Intern05SalaryBO;
import com.viettel.service.base.dao.BaseFWDAOImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

/**
 * @author BuiBaTruong
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("intern05SalaryDAO")
public class Intern05SalaryDAO extends BaseFWDAOImpl<Intern05SalaryBO, Long> {

	public Intern05SalaryDAO() {
		this.model = new Intern05SalaryBO();
	}

	public Intern05SalaryDAO(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Intern05SalaryDTO> getAll() {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								SA.SA_LEVEL saLevel,									");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowancecoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_SALARY SA	 									");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("saLevel", new LongType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowancecoefficient", new FloatType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05SalaryDTO.class));
		return query.list();
	}

	public Intern05SalaryDTO getOneById(Long saLevel) {
		StringBuilder sql = new StringBuilder("SELECT 														");
		sql.append("								SA.SA_LEVEL saLevel,									");
		sql.append("								SA.SA_BASIC saBasic,									");
		sql.append("								SA.SA_COEFFICIENT saCoefficient,						");
		sql.append("								SA.SA_ALLOWANCECOEFFICIENT saAllowancecoefficient		");
		sql.append("  						   FROM 														");
		sql.append("  								INTERN05_SALARY SA	 									");
		sql.append("  						   WHERE					 									");
		sql.append("  						   		SA.SA_LEVEL = :saLevel 									");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("saLevel", new LongType());
		query.addScalar("saBasic", new FloatType());
		query.addScalar("saCoefficient", new FloatType());
		query.addScalar("saAllowancecoefficient", new FloatType());

		query.setParameter("saLevel", saLevel);

		query.setResultTransformer(Transformers.aliasToBean(Intern05SalaryDTO.class));
		return (Intern05SalaryDTO) query.uniqueResult();
	}

}
