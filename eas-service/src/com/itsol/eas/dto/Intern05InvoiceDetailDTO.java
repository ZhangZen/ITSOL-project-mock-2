package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05InvoiceDetailBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "INTERN05_INVOICE_DETAILBO")
public class Intern05InvoiceDetailDTO extends BaseFWDTOImpl<Intern05InvoiceDetailBO> {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long invoiceDetailId;
	private java.lang.Float unitPrice;
	private java.lang.Long quantity;
	private java.lang.Long invoiceId;
	private java.lang.Long productId;
	private java.lang.Float discountRate;

	// thong tin bo sung
	private java.lang.String productName;
	private java.lang.String productUnit;

	public java.lang.String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(java.lang.String productUnit) {
		this.productUnit = productUnit;
	}

	public java.lang.String getProductName() {
		return productName;
	}

	public void setProductName(java.lang.String productName) {
		this.productName = productName;
	}

	@Override
	public Intern05InvoiceDetailBO toModel() {
		Intern05InvoiceDetailBO intern05InvoiceDetailBO = new Intern05InvoiceDetailBO();
		intern05InvoiceDetailBO.setInvoiceDetailId(this.invoiceDetailId);
		intern05InvoiceDetailBO.setUnitPrice(this.unitPrice);
		intern05InvoiceDetailBO.setQuantity(this.quantity);
		intern05InvoiceDetailBO.setInvoiceId(this.invoiceId);
		intern05InvoiceDetailBO.setProductId(this.productId);
		intern05InvoiceDetailBO.setDiscountRate(this.discountRate);
		return intern05InvoiceDetailBO;
	}

	@Override
	public Long getFWModelId() {
		return invoiceDetailId;
	}

	@Override
	public String catchName() {
		return getInvoiceDetailId().toString();
	}

	public java.lang.Long getInvoiceDetailId() {
		return invoiceDetailId;
	}

	public void setInvoiceDetailId(java.lang.Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}

	public java.lang.Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(java.lang.Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public java.lang.Long getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Long quantity) {
		this.quantity = quantity;
	}

	public java.lang.Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(java.lang.Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public java.lang.Long getProductId() {
		return productId;
	}

	public void setProductId(java.lang.Long productId) {
		this.productId = productId;
	}

	public java.lang.Float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(java.lang.Float discountRate) {
		this.discountRate = discountRate;
	}

}
