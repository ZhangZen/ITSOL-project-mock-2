package com.itsol.eas.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Intern05StatisticsDTO{

	private java.lang.String prName;
	private java.lang.String prCategory;
	private java.lang.String suName;
	private java.lang.String unit;
	private java.lang.Float unitPrice;
	private java.lang.Long imId;
	private java.lang.Long suId;
	private java.lang.Long quantity;
	private java.lang.Float money;
	private java.lang.Long prCategoryId;
	private java.lang.Long prId;
	
	
	
	public java.lang.Long getImId() {
		return imId;
	}

	public void setImId(java.lang.Long imId) {
		this.imId = imId;
	}

	public java.lang.String getPrCategory() {
		return prCategory;
	}

	public void setPrCategory(java.lang.String prCategory) {
		this.prCategory = prCategory;
	}


	public java.lang.String getPrName() {
		return prName;
	}

	public void setPrName(java.lang.String prName) {
		this.prName = prName;
	}

	public java.lang.String getSuName() {
		return suName;
	}

	public void setSuName(java.lang.String suName) {
		this.suName = suName;
	}

	public java.lang.String getUnit() {
		return unit;
	}

	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	public java.lang.Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(java.lang.Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public java.lang.Long getSuId() {
		return suId;
	}

	public void setSuId(java.lang.Long suId) {
		this.suId = suId;
	}

	public java.lang.Long getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Long quantity) {
		this.quantity = quantity;
	}

	public java.lang.Float getMoney() {
		return money;
	}

	public void setMoney(java.lang.Float money) {
		this.money = money;
	}

	public java.lang.Long getPrCategoryId() {
		return prCategoryId;
	}

	public void setPrCategoryId(java.lang.Long prCategoryId) {
		this.prCategoryId = prCategoryId;
	}

	public java.lang.Long getPrId() {
		return prId;
	}

	public void setPrId(java.lang.Long prId) {
		this.prId = prId;
	}



}
