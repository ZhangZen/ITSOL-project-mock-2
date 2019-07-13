/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05DepartmentBO;
import com.itsol.eas.dto.Intern05DepartmentDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

/**
 * @author BuiBaTruong
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("intern05DepartmentDAO")
public class Intern05DepartmentDAO extends BaseFWDAOImpl<Intern05DepartmentBO, Long> {

	public Intern05DepartmentDAO() {
		this.model = new Intern05DepartmentBO();
	}

	public Intern05DepartmentDAO(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Intern05DepartmentDTO> getAll() {
		StringBuilder sql = new StringBuilder("SELECT 										");
		sql.append("								DE.DE_ID deId, 							");
		sql.append("								DE.DE_NAME deName, 						");
		sql.append("								DE.DE_PHONE dePhone						");
		sql.append("  						   FROM 										");
		sql.append("  								INTERN05_DEPARTMENT DE 					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("deId", new LongType());
		query.addScalar("deName", new StringType());
		query.addScalar("dePhone", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05DepartmentDTO.class));
		return query.list();
	}

	public Intern05DepartmentDTO getOneByName(String name) {
		StringBuilder sql = new StringBuilder("SELECT 										");
		sql.append("								DE.DE_ID deId, 							");
		sql.append("								DE.DE_NAME deName, 						");
		sql.append("								DE.DE_PHONE dePhone						");
		sql.append("  						   FROM 										");
		sql.append("  								INTERN05_DEPARTMENT DE 					");
		sql.append("  						   WHERE DE.DE_NAME = :name						");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("deId", new LongType());
		query.addScalar("deName", new StringType());
		query.addScalar("dePhone", new StringType());
		query.setParameter("name", name);

		query.setResultTransformer(Transformers.aliasToBean(Intern05DepartmentDTO.class));
		return (Intern05DepartmentDTO) query.uniqueResult();
	}

}
