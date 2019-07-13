/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05LiteracyBO;
import com.itsol.eas.dto.Intern05LiteracyDTO;
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
@Repository("intern05LiteracyDAO")
@SuppressWarnings("unchecked")
public class Intern05LiteracyDAO extends BaseFWDAOImpl<Intern05LiteracyBO, Long> {

	public Intern05LiteracyDAO() {
		this.model = new Intern05LiteracyBO();
	}

	public Intern05LiteracyDAO(Session session) {
		this.session = session;
	}

	public List<Intern05LiteracyDTO> getAll() {
		StringBuilder sql = new StringBuilder("SELECT 										");
		sql.append("								LI.LI_ID liId, 							");
		sql.append("								LI.LI_NAME liName 						");
		sql.append("  						   FROM 										");
		sql.append("  								INTERN05_LITERACY LI 					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("liId", new LongType());
		query.addScalar("liName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05LiteracyDTO.class));
		return query.list();
	}

	public Intern05LiteracyDTO getOneByName(String name) {
		StringBuilder sql = new StringBuilder("SELECT 										");
		sql.append("								LI.LI_ID liId, 							");
		sql.append("								LI.LI_NAME liName 						");
		sql.append("  						   FROM 										");
		sql.append("  								INTERN05_LITERACY LI 					");
		sql.append("  						   WHERE										");
		sql.append("  								LI.LI_NAME = :name	 					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("liId", new LongType());
		query.addScalar("liName", new StringType());

		query.setParameter("name", name);

		query.setResultTransformer(Transformers.aliasToBean(Intern05LiteracyDTO.class));
		return (Intern05LiteracyDTO) query.uniqueResult();
	}

}
