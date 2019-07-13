package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05ProductBO;
import com.itsol.eas.dto.Intern05ProductDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository("intern05ProductDAO")
public class Intern05ProductDAO extends BaseFWDAOImpl<Intern05ProductBO, Long> {

	public Intern05ProductDAO() {
		this.model = new Intern05ProductBO();
	}

	public Intern05ProductDAO(Session session) {
		this.session = session;
	}

	public Intern05ProductDTO getOneById(Long id) {
		Intern05ProductDTO intern05ProductDTO = new Intern05ProductDTO();
		try {
			StringBuilder sqlBuffer = new StringBuilder("SELECT" + " PR.PR_ID prId" + ",PR.PR_NAME prName"
					+ ",PR.PRICE price" + ",PR.QUANTITY quantity" + ",PR.PR_UNIT prUnit"
					+ ",PR.DISCOUNT_RATE discountRate" + ",PR.PR_DESCRIPTION prDescription"
					+ ",PR.PR_DIGITALPRODUCT prDigitalproduct" + ",PR.PRODUCT_CATEGORY_ID productCategoryId"

					+ " FROM INTERN05_PRODUCT PR" + " WHERE PR.PR_ID = :prId");

			SQLQuery query = getSession().createSQLQuery(sqlBuffer.toString());
			query.addScalar("prId", new LongType());
			query.addScalar("prName", new StringType());
			query.addScalar("price", new FloatType());
			query.addScalar("quantity", new LongType());
			query.addScalar("prUnit", new StringType());
			query.addScalar("discountRate", new FloatType());
			query.addScalar("prDescription", new StringType());
			query.addScalar("prDigitalproduct", new StringType());
			query.addScalar("productCategoryId", new LongType());

			query.setParameter("prId", id);

			query.setResultTransformer(Transformers.aliasToBean(Intern05ProductDTO.class));
			intern05ProductDTO = (Intern05ProductDTO) query.uniqueResult();
			return intern05ProductDTO;
		} catch (Exception e) {

			return intern05ProductDTO;
		}
	}
}
