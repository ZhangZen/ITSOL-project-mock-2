/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05ExportorderBO;
import com.itsol.eas.dto.Intern05ExportorderDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import com.viettel.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Repository("intern05ExportorderDAO")
public class Intern05ExportorderDAO extends BaseFWDAOImpl<Intern05ExportorderBO, Long> {

	public Intern05ExportorderDAO() {
		this.model = new Intern05ExportorderBO();
	}

	public Intern05ExportorderDAO(Session session) {
		this.session = session;
	}
	final static String   vnd = "VNĐ";

	public List<Intern05ExportorderDTO> getAllEX() {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("EX.EX_ID 							exId,");
		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME 		prCategory,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_ID 			prCategoryId,");
		stringBuilder.append("EX.CREATE_DATE 					createDate,");
		stringBuilder.append("EX.QUANTITY 						quantity,");
		stringBuilder.append("EX.UNIT 							unit,");
		stringBuilder.append("EX.UNIT_PRICE 					unitPrice,");
		stringBuilder.append("(EX.UNIT_PRICE * EX.QUANTITY) 	money,");
		stringBuilder.append("EM.EM_ID  						emId,");
		stringBuilder.append("EM.EM_FIRSTNAME  					firstName,");
		stringBuilder.append("EM.EM_LASTNAME  					lastName,");
		stringBuilder.append("EX.NOTE 							note");

		stringBuilder.append(" FROM INTERN05_EXPORTORDER 	EX ");
		stringBuilder.append(" JOIN INTERN05_EMPLOYEE 		EM 		ON EX.EM_ID = EM.EM_ID");
		stringBuilder.append(" JOIN INTERN05_PRODUCT 		PR 		ON EX.PR_ID = PR.PR_ID");
		stringBuilder.append(" JOIN INTERN05_PRCATEGORY 	PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		stringBuilder.append(" ORDER BY EX.EX_ID ");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("exId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
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

		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return query.list();
	}
	
	public List<Intern05ExportorderDTO> getPrcategory() {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("PRODUCT_CATEGORY_NAME 	prCategory,");
		stringBuilder.append("PRODUCT_CATEGORY_ID 	prCategoryId");
		stringBuilder.append(" FROM INTERN05_PRCATEGORY ");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("prCategory", new StringType());
		query.addScalar("prCategoryId", new LongType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return query.list();
	}
	
	public List<Intern05ExportorderDTO> getEmployee() {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("EM.EM_ID 	emId ,");
		stringBuilder.append("EM.EM_FIRSTNAME  	firstName,");
		stringBuilder.append("EM.EM_LASTNAME  	lastName ");
		stringBuilder.append(" FROM INTERN05_EMPLOYEE   EM");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("emId", new LongType());
		query.addScalar("firstName", new StringType());
		query.addScalar("lastName", new StringType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return query.list();
	}
	
	public List<Intern05ExportorderDTO> getProductListByPrcId(Long prcId) {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId");
		
		stringBuilder.append(" FROM INTERN05_PRODUCT 			PR ");

		stringBuilder.append(" WHERE PR.PRODUCT_CATEGORY_ID = 		:prcId");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());

		query.setParameter("prcId", prcId);

		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return  query.list();
	}
	
	public Intern05ExportorderDTO getPrcListByPrId(Long prId) {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("PR.PR_NAME 						prName,			");
		stringBuilder.append("PR.PR_ID 							prId,  			");
		stringBuilder.append("PR.PRODUCT_CATEGORY_ID 			prCategoryId,	");
		stringBuilder.append("PR.QUANTITY 						quantity,		");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME			prCategory		");
		
		stringBuilder.append(" FROM INTERN05_PRODUCT 			PR, 			");
		stringBuilder.append(" INTERN05_PRCATEGORY 				PRC 			");

		stringBuilder.append(" WHERE PR.PR_ID = 		:prId");
		stringBuilder.append(" AND PRC.PRODUCT_CATEGORY_ID = PR.PRODUCT_CATEGORY_ID ");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("quantity", new LongType());

		query.setParameter("prId", prId);

		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return (Intern05ExportorderDTO) query.uniqueResult();
	}
	

	public Intern05ExportorderDTO getById(Long id) {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("EX.EX_ID 							exId,");
		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME 		prCategory,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_ID 			prCategoryId,");
		stringBuilder.append("EX.CREATE_DATE 					createDate,");
		stringBuilder.append("EX.QUANTITY 						quantity,");
		stringBuilder.append("EX.UNIT 							unit,");
		stringBuilder.append("EX.UNIT_PRICE 					unitPrice,");
		stringBuilder.append("(EX.UNIT_PRICE * EX.QUANTITY) 	money,");
		stringBuilder.append("EM.EM_ID  						emId,");
		stringBuilder.append("EM.EM_FIRSTNAME  					firstName,");
		stringBuilder.append("EM.EM_LASTNAME  					lastName,");
		stringBuilder.append("EX.NOTE 							note");
		
		stringBuilder.append(" FROM INTERN05_EXPORTORDER 		EX ");
		stringBuilder.append(" JOIN INTERN05_EMPLOYEE 			EM 			ON EX.EM_ID = EM.EM_ID");
		stringBuilder.append(" JOIN INTERN05_PRODUCT 			PR 			ON EX.PR_ID = PR.PR_ID");
		stringBuilder.append(" JOIN INTERN05_PRCATEGORY 		PRC 		ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");

		stringBuilder.append(" WHERE EX.EX_ID = :id");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("exId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
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

		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return (Intern05ExportorderDTO) query.uniqueResult();
	}

	public List<Intern05ExportorderDTO> doSearch (Intern05ExportorderDTO searchObj) {
		
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("EX.EX_ID 							exId,");
		stringBuilder.append("PR.PR_NAME 						prName,");
		stringBuilder.append("PR.PR_ID 							prId,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_NAME 		prCategory,");
		stringBuilder.append("PRC.PRODUCT_CATEGORY_ID 			prCategoryId,");
		stringBuilder.append("EX.CREATE_DATE 					createDate,");
		stringBuilder.append("EX.QUANTITY 						quantity,");
		stringBuilder.append("EX.UNIT 							unit,");
		stringBuilder.append("EX.UNIT_PRICE 					unitPrice,");
		stringBuilder.append("(EX.UNIT_PRICE * EX.QUANTITY) 	money,");
		stringBuilder.append("EM.EM_ID  						emId,");
		stringBuilder.append("EM.EM_FIRSTNAME  					firstName,");
		stringBuilder.append("EM.EM_LASTNAME  					lastName,");
		stringBuilder.append("EX.NOTE 							note");
		
		stringBuilder.append(" FROM INTERN05_EXPORTORDER 	EX ");
		stringBuilder.append(" JOIN INTERN05_EMPLOYEE 		EM 		ON EX.EM_ID = EM.EM_ID");
		stringBuilder.append(" JOIN INTERN05_PRODUCT 		PR 		ON EX.PR_ID = PR.PR_ID");
		stringBuilder.append(" JOIN INTERN05_PRCATEGORY 		PRC 		ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		stringBuilder.append(" WHERE 1 = 1");
		
		if((searchObj.getExId()) != null){
			stringBuilder.append(" AND EX.EX_ID = :id");
		}
		
		if((searchObj.getPrId()) != null){
			stringBuilder.append(" AND PR.PR_ID = :prId)");
		}
		
		if((searchObj.getPrCategoryId()) != null){
			stringBuilder.append(" AND PRC.PRODUCT_CATEGORY_ID = :prCategoryId");
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
			stringBuilder.append(" AND EX.CREATE_DATE >= :dateFrom");
		}
		
		if(searchObj.getCreateDateTo() != null){
			stringBuilder.append(" AND EX.CREATE_DATE <= :dateTo");
		}

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("exId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prId", new LongType());
		query.addScalar("prCategory", new StringType());
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
		
		
		if((searchObj.getExId()) != null){
			query.setParameter("id", searchObj.getExId());
		}
		
		if((searchObj.getPrId()) != null){
			query.setParameter("prId", searchObj.getPrId());
		}
		
		if((searchObj.getPrCategoryId()) != null){
			query.setParameter("prCategoryId", searchObj.getPrCategoryId());
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
		
		query.setResultTransformer(Transformers.aliasToBean(Intern05ExportorderDTO.class));

		return query.list();
	}

	
}
