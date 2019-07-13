package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05ProductDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_PRODUCT")
@SuppressWarnings("serial")

public class Intern05ProductBO extends BaseFWModelImpl {

	private java.lang.Long prId;
	private java.lang.String prName;
	private java.lang.Float price;
	private java.lang.String prUnit;
	private java.lang.Long quantity;
	private java.lang.Float discountRate;
	private java.lang.String prDescription;
	private java.lang.String prDigitalproduct;
	private java.lang.Long productCategoryId;

	public Intern05ProductBO() {
		setColId("prId");
		setColName("prId");
		setUniqueColumn(new String[] { "prId" });
	}

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_PRODUCT_SEQ") })
	@Column(name = "PR_ID", length = 22)
	public java.lang.Long getPrId() {
		return prId;
	}

	public void setPrId(java.lang.Long prId) {
		this.prId = prId;
	}

	@Column(name = "PR_NAME", length = 200)
	public java.lang.String getPrName() {
		return prName;
	}

	public void setPrName(java.lang.String prName) {
		this.prName = prName;
	}

	@Column(name = "PRICE", length = 22)
	public java.lang.Float getPrice() {
		return price;
	}

	public void setPrice(java.lang.Float price) {
		this.price = price;
	}

	@Column(name = "PR_UNIT", length = 40)
	public java.lang.String getPrUnit() {
		return prUnit;
	}

	public void setPrUnit(java.lang.String prUnit) {
		this.prUnit = prUnit;
	}

	@Column(name = "QUANTITY", length = 22)
	public java.lang.Long getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "DISCOUNT_RATE", length = 22)
	public java.lang.Float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(java.lang.Float discountRate) {
		this.discountRate = discountRate;
	}

	@Column(name = "PR_DESCRIPTION", length = 1000)
	public java.lang.String getPrDescription() {
		return prDescription;
	}

	public void setPrDescription(java.lang.String prDescription) {
		this.prDescription = prDescription;
	}

	@Column(name = "PR_DIGITALPRODUCT", length = 400)
	public java.lang.String getPrDigitalproduct() {
		return prDigitalproduct;
	}

	public void setPrDigitalproduct(java.lang.String prDigitalproduct) {
		this.prDigitalproduct = prDigitalproduct;
	}

	@Column(name = "PRODUCT_CATEGORY_ID", length = 22)
	public java.lang.Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(java.lang.Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Override
	public Intern05ProductDTO toDTO() {
		Intern05ProductDTO intern05ProductDTO = new Intern05ProductDTO();
		// set cac gia tri
		intern05ProductDTO.setPrId(this.prId);
		intern05ProductDTO.setPrName(this.prName);
		intern05ProductDTO.setPrice(this.price);
		intern05ProductDTO.setPrUnit(this.prUnit);
		intern05ProductDTO.setQuantity(this.quantity);
		intern05ProductDTO.setDiscountRate(this.discountRate);
		intern05ProductDTO.setPrDescription(this.prDescription);
		intern05ProductDTO.setPrDigitalproduct(this.prDigitalproduct);
		intern05ProductDTO.setProductCategoryId(this.productCategoryId);
		return intern05ProductDTO;
	}
}
