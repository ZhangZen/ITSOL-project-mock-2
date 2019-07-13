package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05InvoiceBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "INTERN05_INVOICEBO")
public class Intern05InvoiceDTO extends BaseFWDTOImpl<Intern05InvoiceBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long invoiceId;
	private java.lang.String customerName;
	private java.lang.String customerAddress;
	private java.lang.String customerPhone;
	private java.util.Date invoiceDate;
	private java.util.Date invoiceDateFrom;
	private java.util.Date invoiceDateTo;
	private java.lang.Float totalAmount;
	private java.lang.Long employeeId;
	// thong tin nhan vien
	private java.lang.String employeeName;
	private List<Intern05InvoiceDetailDTO> invDetail;

	public List<Intern05InvoiceDetailDTO> getInvDetail() {
		return invDetail;
	}



	public void setInvDetail(List<Intern05InvoiceDetailDTO> invDetail) {
		this.invDetail = invDetail;
	}



	@Override
	public Intern05InvoiceBO toModel() {
		Intern05InvoiceBO intern05InvoiceBO = new Intern05InvoiceBO();
		intern05InvoiceBO.setInvoiceId(this.invoiceId);
		intern05InvoiceBO.setCustomerName(this.customerName);
		intern05InvoiceBO.setCustomerAddress(this.customerAddress);
		intern05InvoiceBO.setCustomerPhone(this.customerPhone);
		intern05InvoiceBO.setInvoiceDate(this.invoiceDate);
		intern05InvoiceBO.setTotalAmount(this.totalAmount);
		intern05InvoiceBO.setEmployeeId(this.employeeId);
		return intern05InvoiceBO;
	}

	
	
	public java.util.Date getInvoiceDateFrom() {
		return invoiceDateFrom;
	}



	public void setInvoiceDateFrom(java.util.Date invoiceDateFrom) {
		this.invoiceDateFrom = invoiceDateFrom;
	}



	public java.util.Date getInvoiceDateTo() {
		return invoiceDateTo;
	}



	public void setInvoiceDateTo(java.util.Date invoiceDateTo) {
		this.invoiceDateTo = invoiceDateTo;
	}



	public java.lang.String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(java.lang.String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public Long getFWModelId() {
		return invoiceId;
	}

	@Override
	public String catchName() {
		return getInvoiceId().toString();
	}

	public java.lang.Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(java.lang.Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public java.lang.String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(java.lang.String customerName) {
		this.customerName = customerName;
	}

	public java.lang.String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(java.lang.String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public java.lang.String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(java.lang.String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public java.util.Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public java.lang.Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(java.lang.Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public java.lang.Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(java.lang.Long employeeId) {
		this.employeeId = employeeId;
	}

}
