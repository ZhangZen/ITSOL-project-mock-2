/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05PositionBO;
import com.itsol.eas.dto.Intern05PositionDTO;
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
@Repository("intern05PositionDAO")
public class Intern05PositionDAO extends BaseFWDAOImpl<Intern05PositionBO, Long> {

	public Intern05PositionDAO() {
		this.model = new Intern05PositionBO();
	}

	public Intern05PositionDAO(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Intern05PositionDTO> getAll() {
		StringBuilder sql = new StringBuilder("SELECT 										");
		sql.append("								PO.PO_ID poId, 							");
		sql.append("								PO.PO_NAME poName 						");
		sql.append("  						   FROM 										");
		sql.append("  								INTERN05_POSITION PO 					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("poId", new LongType());
		query.addScalar("poName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05PositionDTO.class));
		return query.list();
	}

	public Intern05PositionDTO getOneByName(String name) {
		StringBuilder sql = new StringBuilder("SELECT 										");
		sql.append("								PO.PO_ID poId, 							");
		sql.append("								PO.PO_NAME poName 						");
		sql.append("  						   FROM 										");
		sql.append("  								INTERN05_POSITION PO 					");
		sql.append("  						   WHERE					 					");
		sql.append("  						   		PO.PO_NAME = :name	 					");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("poId", new LongType());
		query.addScalar("poName", new StringType());

		query.setParameter("name", name);

		query.setResultTransformer(Transformers.aliasToBean(Intern05PositionDTO.class));
		return (Intern05PositionDTO) query.uniqueResult();
	}

}
