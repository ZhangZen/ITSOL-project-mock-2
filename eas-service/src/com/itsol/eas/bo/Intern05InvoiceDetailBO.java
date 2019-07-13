package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05InvoiceDetailDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_INVOICE_DETAIL")
@SuppressWarnings("serial")

public class Intern05InvoiceDetailBO extends BaseFWModelImpl {

	private java.lang.Long invoiceDetailId;
	private java.lang.Float unitPrice;
	private java.lang.Long quantity;
	private java.lang.Long invoiceId;
	private java.lang.Long productId;
	private java.lang.Float discountRate;

	public Intern05InvoiceDetailBO() {
		setColId("invoiceDetailId");
		setColName("invoiceDetailId");
		setUniqueColumn(new String[] { "invoiceDetailId" });
	}

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_INVOICE_DETAIL_SEQ") })
	@Column(name = "INVOICE_DETAIL_ID", length = 22)
	public java.lang.Long getInvoiceDetailId() {
		return invoiceDetailId;
	}

	public void setInvoiceDetailId(java.lang.Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}

	@Column(name = "UNIT_PRICE", length = 22)
	public java.lang.Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(java.lang.Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "QUANTITY", length = 22)
	public java.lang.Long getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "INVOICE_ID", length = 22)
	public java.lang.Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(java.lang.Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "PRODUCT_ID", length = 22)
	public java.lang.Long getProductId() {
		return productId;
	}

	public void setProductId(java.lang.Long productId) {
		this.productId = productId;
	}

	@Column(name = "DISCOUNT_RATE", length = 22)
	public java.lang.Float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(java.lang.Float discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public Intern05InvoiceDetailDTO toDTO() {
		Intern05InvoiceDetailDTO intern05InvoiceDetailDTO = new Intern05InvoiceDetailDTO();
		// set cac gia tri
		intern05InvoiceDetailDTO.setInvoiceDetailId(this.invoiceDetailId);
		intern05InvoiceDetailDTO.setUnitPrice(this.unitPrice);
		intern05InvoiceDetailDTO.setQuantity(this.quantity);
		intern05InvoiceDetailDTO.setInvoiceId(this.invoiceId);
		intern05InvoiceDetailDTO.setProductId(this.productId);
		intern05InvoiceDetailDTO.setDiscountRate(this.discountRate);
		return intern05InvoiceDetailDTO;
	}
}
