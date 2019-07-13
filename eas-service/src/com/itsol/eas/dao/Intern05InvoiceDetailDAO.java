package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05InvoiceDetailBO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import com.itsol.eas.dto.Intern05InvoiceDetailDTO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository("intern05InvoiceDetailDAO")
public class Intern05InvoiceDetailDAO extends BaseFWDAOImpl<Intern05InvoiceDetailBO, Long> {

	public Intern05InvoiceDetailDAO() {
		this.model = new Intern05InvoiceDetailBO();
	}

	public Intern05InvoiceDetailDAO(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Intern05InvoiceDetailDTO> getInvoiceDetailByInvoiceId(Long id) {
		StringBuilder sqlBuffer = new StringBuilder("SELECT"
				+ " PR.PR_ID productId" 
				+ ",PR.PR_NAME productName " 
				+ ",PR.PR_UNIT productUnit" 
				+ ",IND.QUANTITY quantity"
				+ ",IND.UNIT_PRICE unitPrice" 
				+ ",IND.DISCOUNT_RATE discountRate"

				// from table
				+ " FROM INTERN05_INVOICE_DETAIL IND"
				+ " JOIN INTERN05_PRODUCT PR ON IND.PRODUCT_ID = PR.PR_ID"
				+ " WHERE IND.INVOICE_ID = :invoiceId ");

		SQLQuery query = getSession().createSQLQuery(sqlBuffer.toString());

		query.addScalar("productId", new LongType());
		query.addScalar("productName", new StringType());
		query.addScalar("productUnit", new StringType());
		query.addScalar("quantity", new LongType());
		query.addScalar("unitPrice", new FloatType());
		query.addScalar("discountRate", new FloatType());

		query.setParameter("invoiceId", id);

		query.setResultTransformer(Transformers.aliasToBean(Intern05InvoiceDetailDTO.class));
		return query.list();
	}
}
