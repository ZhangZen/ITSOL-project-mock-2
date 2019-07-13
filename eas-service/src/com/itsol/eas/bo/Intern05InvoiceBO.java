package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05InvoiceDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_INVOICE")
@SuppressWarnings("serial")

public class Intern05InvoiceBO extends BaseFWModelImpl {

	private java.lang.Long invoiceId;
	private java.lang.String customerName;
	private java.lang.String customerAddress;
	private java.lang.String customerPhone;
	private java.util.Date invoiceDate;
	private java.lang.Float totalAmount;
	private java.lang.Long employeeId;

	public Intern05InvoiceBO() {
		setColId("invoiceId");
		setColName("invoiceId");
		setUniqueColumn(new String[] { "invoiceId" });
	}

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_INVOICE_SEQ") })
	@Column(name = "INVOICE_ID", length = 22)
	public java.lang.Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(java.lang.Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "CUSTOMER_NAME", length = 100)
	public java.lang.String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(java.lang.String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "CUSTOMER_ADDRESS", length = 100)
	public java.lang.String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(java.lang.String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Column(name = "CUSTOMER_PHONE", length = 30)
	public java.lang.String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(java.lang.String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Column(name = "INVOICE_DATE", length = 7)
	public java.util.Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Column(name = "TOTAL_AMOUNT", length = 22)
	public java.lang.Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(java.lang.Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "EMPLOYEE_ID", length = 22)
	public java.lang.Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(java.lang.Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public Intern05InvoiceDTO toDTO() {
		Intern05InvoiceDTO intern05InvoiceDTO = new Intern05InvoiceDTO();
		// set cac gia tri
		intern05InvoiceDTO.setInvoiceId(this.invoiceId);
		intern05InvoiceDTO.setCustomerName(this.customerName);
		intern05InvoiceDTO.setCustomerAddress(this.customerAddress);
		intern05InvoiceDTO.setCustomerPhone(this.customerPhone);
		intern05InvoiceDTO.setInvoiceDate(this.invoiceDate);
		intern05InvoiceDTO.setTotalAmount(this.totalAmount);
		intern05InvoiceDTO.setEmployeeId(this.employeeId);
		return intern05InvoiceDTO;
	}
}
