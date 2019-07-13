package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05ImportorderBO;
import com.itsol.eas.dto.Intern05ImportorderDTO;
import com.itsol.eas.dto.Intern05StatisticsDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository("intern05StatisticsDAO")
public class Intern05StatisticsDAO extends BaseFWDAOImpl<Intern05ImportorderBO, Long> {

	public List<Intern05StatisticsDTO> getAll() {
		StringBuilder sb = new StringBuilder("SELECT ");
		
		sb.append("IM.IM_ID 										imId,		");
		sb.append("PR.PR_NAME		 								prName, 	");
		sb.append("PR.PR_ID											prId, 		");
		sb.append("PRC.PRODUCT_CATEGORY_NAME						prCategory,	");
		sb.append("PRC.PRODUCT_CATEGORY_ID							prCategoryId,");
		sb.append("SU.SU_NAME										suName, 	");
		sb.append("SU.SU_ID											suId, 		");
		sb.append("IM.UNIT											unit,		");
		sb.append("PR.QUANTITY 										quantity , 	");
		sb.append("IM.UNIT_PRICE 									unitPrice, 	");
		sb.append("(IM.UNIT_PRICE * PR.QUANTITY) 					money 		");

		sb.append(" FROM INTERN05_IMPORTORDER IM ");

		sb.append(" JOIN INTERN05_PRODUCT 			PR 		ON IM.PR_ID = PR.PR_ID ");
		sb.append(" JOIN INTERN05_SUPPLIER 			SU 		ON IM.SU_ID = SU.SU_ID ");
		sb.append(" JOIN INTERN05_PRCATEGORY 		PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		sb.append(" ORDER BY IM.IM_ID ");

		SQLQuery query = getSession().createSQLQuery(sb.toString());

		query.addScalar("imId", new LongType());
		query.addScalar("prId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());
		query.addScalar("unit", new StringType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("quantity", new LongType());
		query.addScalar("money", new FloatType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05StatisticsDTO.class));
		return query.list();

	}

	public List<Intern05StatisticsDTO> getAllProduct() {
		StringBuilder stringBuilder = new StringBuilder("SELECT ");

		stringBuilder.append("PR_ID 	prId,");
		stringBuilder.append("PR_NAME 	prName,");
		stringBuilder.append("QUANTITY 	quantity");
		
		stringBuilder.append(" FROM INTERN05_PRODUCT ");

		SQLQuery query = getSession().createSQLQuery(stringBuilder.toString());

		query.addScalar("prId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("quantity", new LongType());

		query.setResultTransformer(Transformers.aliasToBean(Intern05StatisticsDTO.class));

		return query.list();
	}
	
	
	public Intern05StatisticsDTO getByImId(Long imId) {
		StringBuilder sb = new StringBuilder("SELECT ");

		sb.append("IM.IM_ID 										imId,		");
		sb.append("PR.PR_NAME		 								prName, 	");
		sb.append("PR.PR_ID											prId, 		");
		sb.append("PRC.PRODUCT_CATEGORY_NAME						prCategory,	");
		sb.append("PRC.PRODUCT_CATEGORY_ID							prCategoryId,");
		sb.append("SU.SU_NAME										suName, 	");
		sb.append("SU.SU_ID											suId, 		");
		sb.append("IM.UNIT											unit,		");
		sb.append("PR.QUANTITY 										quantity , 	");
		sb.append("IM.UNIT_PRICE 									unitPrice, 	");
		sb.append("(IM.UNIT_PRICE * PR.QUANTITY) 					money 		");


		sb.append(" FROM INTERN05_IMPORTORDER IM ");

		sb.append(" JOIN INTERN05_PRODUCT 			PR 		ON IM.PR_ID = PR.PR_ID ");
		sb.append(" JOIN INTERN05_SUPPLIER 			SU 		ON IM.SU_ID = SU.SU_ID ");
		sb.append(" JOIN INTERN05_PRCATEGORY 		PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		sb.append(" WHERE IM.IM_ID = :imId ");
		
		SQLQuery query = getSession().createSQLQuery(sb.toString());

		query.addScalar("imId", new LongType());
		query.addScalar("prId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());
		query.addScalar("unit", new StringType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("quantity", new LongType());
		query.addScalar("money", new FloatType());
		
		query.setParameter("imId", imId);

		query.setResultTransformer(Transformers.aliasToBean(Intern05StatisticsDTO.class));
		
		return (Intern05StatisticsDTO) query.uniqueResult();

	}
	
public List<Intern05StatisticsDTO> doSearch (Intern05StatisticsDTO searchObj) {
		
		StringBuilder sb = new StringBuilder("SELECT ");

		sb.append("IM.IM_ID 										imId,		");
		sb.append("PR.PR_NAME		 								prName, 	");
		sb.append("PR.PR_ID											prId, 		");
		sb.append("PRC.PRODUCT_CATEGORY_NAME						prCategory,	");
		sb.append("PRC.PRODUCT_CATEGORY_ID							prCategoryId,");
		sb.append("SU.SU_NAME										suName, 	");
		sb.append("SU.SU_ID											suId, 		");
		sb.append("IM.UNIT											unit,		");
		sb.append("PR.QUANTITY 										quantity , 	");
		sb.append("IM.UNIT_PRICE 									unitPrice, 	");
		sb.append("(IM.UNIT_PRICE * PR.QUANTITY) 					money 		");


		sb.append(" FROM INTERN05_IMPORTORDER IM ");

		sb.append(" JOIN INTERN05_PRODUCT 			PR 		ON IM.PR_ID = PR.PR_ID ");
		sb.append(" JOIN INTERN05_SUPPLIER 			SU 		ON IM.SU_ID = SU.SU_ID ");
		sb.append(" JOIN INTERN05_PRCATEGORY 		PRC 	ON PR.PRODUCT_CATEGORY_ID = PRC.PRODUCT_CATEGORY_ID");
		
		sb.append(" WHERE 1 = 1");
		
		if((searchObj.getPrId()) != null){
			sb.append(" AND PR.PR_ID = :prId");
		}
		
		if((searchObj.getPrCategoryId()) != null){
			sb.append(" AND PRC.PRODUCT_CATEGORY_ID = :prCategoryId");
		}
		
		if((searchObj.getSuId()) != null){
			sb.append(" AND SU.SU_ID = :suId");
		}
		

		SQLQuery query = getSession().createSQLQuery(sb.toString());

		query.addScalar("imId", new LongType());
		query.addScalar("prId", new LongType());
		query.addScalar("prName", new StringType());
		query.addScalar("prCategoryId", new LongType());
		query.addScalar("prCategory", new StringType());
		query.addScalar("suId", new LongType());
		query.addScalar("suName", new StringType());
		query.addScalar("unit", new StringType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("quantity", new LongType());
		query.addScalar("money", new FloatType());
		
		
		if((searchObj.getPrId()) != null){
			query.setParameter("prId", searchObj.getPrId());
		}
		
		if((searchObj.getPrCategoryId()) != null){
			query.setParameter("prCategoryId", searchObj.getPrCategoryId());
		}
		
		if((searchObj.getSuId()) != null){
			query.setParameter("suId", searchObj.getSuId());
		}
		
		
		query.setResultTransformer(Transformers.aliasToBean(Intern05StatisticsDTO.class));

		return query.list();
	}
}
