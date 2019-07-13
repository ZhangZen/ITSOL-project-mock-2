package com.itsol.eas.dao;

import com.itsol.eas.bo.Intern05InvoiceBO;
import com.itsol.eas.dto.Intern05InvoiceDTO;
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

@Repository("intern05InvoiceDAO")
@SuppressWarnings("unchecked")
public class Intern05InvoiceDAO extends BaseFWDAOImpl<Intern05InvoiceBO, Long> {

	public Intern05InvoiceDAO() {
		this.model = new Intern05InvoiceBO();
	}

	public Intern05InvoiceDAO(Session session) {
		this.session = session;
	}

	public List<Intern05InvoiceDTO> getAllInvoice() {
		StringBuilder sqlBuffer = new StringBuilder("SELECT INV.INVOICE_ID invoiceId" + ",INV.EMPLOYEE_ID employeeId"
				+ ",(EMP.EM_FIRSTNAME || ' ' || EMP.EM_LASTNAME) employeeName" + ",INV.INVOICE_DATE invoiceDate"
				+ ",INV.CUSTOMER_NAME customerName" + ",INV.CUSTOMER_ADDRESS customerAddress"
				+ ",INV.CUSTOMER_PHONE customerPhone" + ",INV.TOTAL_AMOUNT totalAmount"

				+ " FROM INTERN05_INVOICE INV" + " JOIN INTERN05_EMPLOYEE EMP ON INV.EMPLOYEE_ID = EMP.EM_ID"
				+ " ORDER BY INV.INVOICE_ID DESC");

		SQLQuery query = getSession().createSQLQuery(sqlBuffer.toString());

		query.addScalar("invoiceId", new LongType());
		query.addScalar("employeeId", new LongType());
		query.addScalar("employeeName", new StringType());
		query.addScalar("invoiceDate", new DateType());
		query.addScalar("customerName", new StringType());
		query.addScalar("customerAddress", new StringType());
		query.addScalar("customerPhone", new StringType());
		query.addScalar("totalAmount", new FloatType());
		query.setResultTransformer(Transformers.aliasToBean(Intern05InvoiceDTO.class));
		return query.list();
	}

	public List<Intern05InvoiceDTO> doSearch(Intern05InvoiceDTO criteria) {
		StringBuilder sql = new StringBuilder("SELECT INV.INVOICE_ID invoiceId");
		sql.append(",INV.EMPLOYEE_ID employeeId");
		sql.append(",(EMP.EM_FIRSTNAME || ' ' || EMP.EM_LASTNAME) employeeName");
		sql.append(",INV.INVOICE_DATE invoiceDate");
		sql.append(",INV.CUSTOMER_NAME customerName");
		sql.append(",INV.CUSTOMER_ADDRESS customerAddress");
		sql.append(",INV.CUSTOMER_PHONE customerPhone");
		sql.append(",INV.TOTAL_AMOUNT totalAmount");

		sql.append(" FROM INTERN05_INVOICE INV");
		sql.append(" JOIN INTERN05_EMPLOYEE EMP ON INV.EMPLOYEE_ID = EMP.EM_ID");
		sql.append(" WHERE");
		sql.append(" NOT INV.TOTAL_AMOUNT = 0");

		// Apply search criteria
		if (null != criteria.getInvoiceId()) {
			sql.append(" AND UPPER(INV.INVOICE_ID) LIKE UPPER(:invoiceId) escape '\\' ");
		}
		if (StringUtils.isNotEmpty(criteria.getEmployeeName())) {
			sql.append(
					" AND UPPER((EMP.EM_FIRSTNAME || ' ' || EMP.EM_LASTNAME)) LIKE UPPER(:employeeName) escape '\\' ");
		}
		if (null != criteria.getInvoiceDateFrom()) {
			sql.append(" AND INV.INVOICE_DATE >= :invoiceDateFrom ");
		}

		if (null != criteria.getInvoiceDateTo()) {
			sql.append(" AND INV.INVOICE_DATE <= :invoiceDateTo ");
		}

		if (StringUtils.isNotEmpty(criteria.getCustomerName())) {
			sql.append(" AND UPPER(INV.CUSTOMER_NAME) LIKE UPPER(:customerName) escape '\\' ");
		}
		if (StringUtils.isNotEmpty(criteria.getCustomerAddress())) {
			sql.append(" AND UPPER(INV.CUSTOMER_ADDRESS) LIKE UPPER(:customerAddress) escape '\\' ");
		}
		if (StringUtils.isNotEmpty(criteria.getCustomerPhone())) {
			sql.append(" AND UPPER(INV.CUSTOMER_PHONE ) LIKE UPPER(:customerPhone) escape '\\' ");
		}

		sql.append(" ORDER BY INV.INVOICE_DATE DESC");

		SQLQuery query = getSession().createSQLQuery(sql.toString());

		query.addScalar("invoiceId", new LongType());
		query.addScalar("employeeId", new LongType());
		query.addScalar("employeeName", new StringType());
		query.addScalar("invoiceDate", new DateType());
		query.addScalar("customerName", new StringType());
		query.addScalar("customerAddress", new StringType());
		query.addScalar("customerPhone", new StringType());
		query.addScalar("totalAmount", new FloatType());

		if (null != criteria.getInvoiceId()) {
			query.setParameter("invoiceId", criteria.getInvoiceId());
		}

		if (StringUtils.isNotEmpty(criteria.getEmployeeName())) {
			query.setParameter("employeeName",
					"%" + com.viettel.service.base.utils.StringUtils.replaceSpecialKeySearch(criteria.getEmployeeName())
							+ "%");
		}

		if (StringUtils.isNotEmpty(criteria.getCustomerName())) {
			query.setParameter("customerName",
					"%" + com.viettel.service.base.utils.StringUtils.replaceSpecialKeySearch(criteria.getCustomerName())
							+ "%");
		}

		if (StringUtils.isNotEmpty(criteria.getCustomerAddress())) {
			query.setParameter("customerAddress", "%"
					+ com.viettel.service.base.utils.StringUtils.replaceSpecialKeySearch(criteria.getCustomerAddress())
					+ "%");
		}

		if (StringUtils.isNotEmpty(criteria.getCustomerPhone())) {
			query.setParameter("customerPhone", "%"
					+ com.viettel.service.base.utils.StringUtils.replaceSpecialKeySearch(criteria.getCustomerPhone())
					+ "%");
		}

		if (null != criteria.getTotalAmount()) {
			query.setParameter("totalAmount", criteria.getTotalAmount());
		}

		if (null != criteria.getInvoiceDateFrom()) {
			query.setTimestamp("invoiceDateFrom", criteria.getInvoiceDateFrom());
		}

		if (null != criteria.getInvoiceDateTo()) {
			query.setTimestamp("invoiceDateTo", criteria.getInvoiceDateTo());
		}

		query.setResultTransformer(Transformers.aliasToBean(Intern05InvoiceDTO.class));
		return query.list();
	}
}
