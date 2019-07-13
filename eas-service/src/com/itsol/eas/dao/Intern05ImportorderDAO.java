/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05ImportorderBO;
import com.itsol.eas.dto.Intern05ImportorderDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.FloatType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

/**
 * @author DATNQ
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("intern05ImportorderDAO")
public class Intern05ImportorderDAO extends BaseFWDAOImpl<Intern05ImportorderBO, Long> {

	public Intern05ImportorderDAO() {
		this.model = new Intern05ImportorderBO();
	}

	public Intern05ImportorderDAO(Session session) {
		this.session = session;
	}

	public List<Intern05ImportorderDTO> getAllIm() {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("IM.IM_ID 							imId,");
		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME 		prCategory,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_ID 			prCategoryId,");
		stringBuilder.append("SU.SU_NAME 						suName,");
		stringBuilder.append("SU.SU_ID 							suId,");
		stringBuilder.append("IM.CREATE_DATE 					createDate,");
		stringBuilder.append("IM.QUANTITY 						quantity,");
		stringBuilder.append("IM.UNIT 							unit,");
		stringBuilder.append("IM.UNIT_PRICE 					unitPrice,");
		stringBuilder.append("(IM.UNIT_PRICE * IM.QUANTITY) 	money,");
		stringBuilder.append("EM.EM_ID  						emId,");
		stringBuilder.append("EM.EM_FIRSTNAME  					firstName,");
		stringBuilder.append("EM.EM_LASTNAME  					lastName,");
		stringBuilder.append("IM.NOTE 							note");

		stringBuilder.append(" FROM INTERN05_IMPORTORDER 	IM ");
		stringBuilder.append(" JOIN INTERN05_EMPLOYEE 		EM 		ON IM.EM_ID = EM.EM_ID");
		stringBuilder.append(" JOIN INTERN05_PRODUCT 		PR 		ON IM.PR_ID = PR.PR_ID");
		stringBuilder.append(" JOIN INTERN05_SUPPLIER 		SU 		ON IM.SU_ID = SU.SU_ID");
		stringBuilder.append(" JOIN INTERN05_PRCATEGORY 	PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		stringBuilder.append(" ORDER BY IM.IM_ID ");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("imId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("createDate", new DateType());
		query.addScalar("quantity", new LongType());
		query.addScalar("unit", new StringType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("money", new FloatType());
		query.addScalar("emId", new LongType());
		query.addScalar("firstName", new StringType());
		query.addScalar("lastName", new StringType());
		query.addScalar("note", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05ImportorderDTO.class));

		return query.list();
	}

	public List<Intern05ImportorderDTO> getAllSu() {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("SU_ID 	suId,");
		stringBuilder.append("SU_NAME 	suName");
		stringBuilder.append(" FROM INTERN05_SUPPLIER ");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05ImportorderDTO.class));

		return query.list();
	}
	
	public Intern05ImportorderDTO getById(Long id) {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("IM.IM_ID 							imId,");
		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME 		prCategory,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_ID 			prCategoryId,");
		stringBuilder.append("SU.SU_NAME 						suName,");
		stringBuilder.append("SU.SU_ID 							suId,");
		stringBuilder.append("IM.CREATE_DATE 					createDate,");
		stringBuilder.append("IM.QUANTITY 						quantity,");
		stringBuilder.append("IM.UNIT 							unit,");
		stringBuilder.append("IM.UNIT_PRICE 					unitPrice,");
		stringBuilder.append("(IM.UNIT_PRICE * IM.QUANTITY) 	money,");
		stringBuilder.append("EM.EM_ID  						emId,");
		stringBuilder.append("EM.EM_FIRSTNAME  					firstName,");
		stringBuilder.append("EM.EM_LASTNAME  					lastName,");
		stringBuilder.append("IM.NOTE 							note");

		stringBuilder.append(" FROM INTERN05_IMPORTORDER 	IM ");
		stringBuilder.append(" JOIN INTERN05_EMPLOYEE 		EM 		ON IM.EM_ID = EM.EM_ID");
		stringBuilder.append(" JOIN INTERN05_PRODUCT 		PR 		ON IM.PR_ID = PR.PR_ID");
		stringBuilder.append(" JOIN INTERN05_SUPPLIER 		SU 		ON IM.SU_ID = SU.SU_ID");
		stringBuilder.append(" JOIN INTERN05_PRCATEGORY 	PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		stringBuilder.append(" WHERE IM.IM_ID = :id");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("imId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("createDate", new DateType());
		query.addScalar("quantity", new LongType());
		query.addScalar("unit", new StringType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("money", new FloatType());
		query.addScalar("emId", new LongType());
		query.addScalar("firstName", new StringType());
		query.addScalar("lastName", new StringType());
		query.addScalar("note", new StringType());


		query.setParameter("id", id);

		query.setResultTransformer(Transformers.aliasToBean(Intern05ImportorderDTO.class));

		return (Intern05ImportorderDTO) query.uniqueResult();
	}
	
	
public List<Intern05ImportorderDTO> doSearch (Intern05ImportorderDTO searchObj) {
		
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("IM.IM_ID 							imId,");
		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME 		prCategory,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_ID 			prCategoryId,");
		stringBuilder.append("SU.SU_NAME 						suName,");
		stringBuilder.append("SU.SU_ID 							suId,");
		stringBuilder.append("IM.CREATE_DATE 					createDate,");
		stringBuilder.append("IM.QUANTITY 						quantity,");
		stringBuilder.append("IM.UNIT 							unit,");
		stringBuilder.append("IM.UNIT_PRICE 					unitPrice,");
		stringBuilder.append("(IM.UNIT_PRICE * IM.QUANTITY) 	money,");
		stringBuilder.append("EM.EM_ID  						emId,");
		stringBuilder.append("EM.EM_FIRSTNAME  					firstName,");
		stringBuilder.append("EM.EM_LASTNAME  					lastName,");
		stringBuilder.append("IM.NOTE 							note");
		
		stringBuilder.append(" FROM INTERN05_IMPORTORDER 	IM ");
		stringBuilder.append(" JOIN INTERN05_EMPLOYEE 		EM 		ON IM.EM_ID = EM.EM_ID");
		stringBuilder.append(" JOIN INTERN05_PRODUCT 		PR 		ON IM.PR_ID = PR.PR_ID");
		stringBuilder.append(" JOIN INTERN05_SUPPLIER 		SU 		ON IM.SU_ID = SU.SU_ID");
		stringBuilder.append(" JOIN INTERN05_PRCATEGORY 	PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		stringBuilder.append(" WHERE 1 = 1");
		
		if((searchObj.getImId()) != null){
			stringBuilder.append(" AND IM.IM_ID = :id");
		}
		
		if((searchObj.getPrId()) != null){
			stringBuilder.append(" AND PR.PR_ID = :prId");
		}
		
		if((searchObj.getPrCategoryId()) != null){
			stringBuilder.append(" AND PRC.PRODUCT_CATEGORY_ID = :prCategoryId");
		}
		
		if((searchObj.getSuId()) != null){
			stringBuilder.append(" AND SU.SU_ID = :suId");
		}
		
		if((searchObj.getEmId()) != null){
			stringBuilder.append(" AND EM.EM_ID = :emId");
		}
		
		if(StringUtils.isNotEmpty(searchObj.getFirstName())){
			stringBuilder.append(" AND UPPER(EM.EM_FIRSTNAME) LIKE UPPER (:firstName)");
		}
		
		if(StringUtils.isNotEmpty(searchObj.getLastName())){
			stringBuilder.append(" AND UPPER(EM.EM_LASTNAME) LIKE UPPER (:lastName)");
		}
		
		if(searchObj.getCreateDateFrom() != null){
			stringBuilder.append(" AND IM.CREATE_DATE >= :dateFrom");
		}
		
		if(searchObj.getCreateDateTo() != null){
			stringBuilder.append(" AND IM.CREATE_DATE <= :dateTo");
		}

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("imId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("createDate", new DateType());
		query.addScalar("quantity", new LongType());
		query.addScalar("unit", new StringType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("money", new FloatType());
		query.addScalar("emId", new LongType());
		query.addScalar("firstName", new StringType());
		query.addScalar("lastName", new StringType());
		query.addScalar("note", new StringType());
		
		
		if((searchObj.getImId()) != null){
			query.setParameter("id", searchObj.getImId());
		}
		
		if((searchObj.getPrId()) != null){
			query.setParameter("prId", searchObj.getPrId());
		}
		
		if((searchObj.getPrCategoryId()) != null){
			query.setParameter("prCategoryId", searchObj.getPrCategoryId());
		}
		
		if((searchObj.getSuId()) != null){
			query.setParameter("suId", searchObj.getSuId());
		}
		
		if((searchObj.getEmId()) != null){
			query.setParameter("emId", searchObj.getEmId());
		}
		
		if(StringUtils.isNotEmpty(searchObj.getFirstName())){
			query.setParameter("firstName", "%" + searchObj.getFirstName() + "%");
		}
		
		if(StringUtils.isNotEmpty(searchObj.getLastName())){
			query.setParameter("lastName", "%" + searchObj.getLastName() + "%");
		}
		
		if(searchObj.getCreateDateFrom() != null){
			query.setParameter("dateFrom", searchObj.getCreateDateFrom() );
		}
		
		if(searchObj.getCreateDateTo() != null){
			query.setParameter("dateTo",searchObj.getCreateDateTo());
		}
		
		query.setResultTransformer(Transformers.aliasToBean(Intern05ImportorderDTO.class));

		return query.list();
	}
	
}
