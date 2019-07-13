/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05ImportorderBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DATNQ
 */
@XmlRootElement(name = "INTERN05_IMPORTORDERBO")
public class Intern05ImportorderDTO extends BaseFWDTOImpl<Intern05ImportorderBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long imId;
	private java.lang.Long suId;
	private java.lang.String prName;
	private java.lang.String suName;
	private java.lang.String prCategory;
	private java.lang.String unit;
	private java.lang.Long quantity;
	private java.lang.Float unitPrice;
	private java.lang.Float money;
	private java.util.Date createDate;
	private java.lang.String note;
	private java.lang.Long emId;
	private java.lang.Long prCategoryId;
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.Long prId;
	private java.util.Date createDateFrom;
	private java.util.Date createDateTo;

	public java.lang.Long getPrCategoryId() {
		return prCategoryId;
	}

	public void setPrCategoryId(java.lang.Long prCategoryId) {
		this.prCategoryId = prCategoryId;
	}

	public java.util.Date getCreateDateFrom() {
		return createDateFrom;
	}

	public void setCreateDateFrom(java.util.Date createDateFrom) {
		this.createDateFrom = createDateFrom;
	}

	public java.util.Date getCreateDateTo() {
		return createDateTo;
	}

	public void setCreateDateTo(java.util.Date createDateTo) {
		this.createDateTo = createDateTo;
	}

	public java.lang.String getFirstName() {
		return firstName;
	}

	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	public java.lang.String getLastName() {
		return lastName;
	}

	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	public java.lang.Long getPrId() {
		return prId;
	}

	public void setPrId(java.lang.Long prId) {
		this.prId = prId;
	}

	public java.lang.Long getSuId() {
		return suId;
	}

	public void setSuId(java.lang.Long suId) {
		this.suId = suId;
	}

	public java.lang.Long getEmId() {
		return emId;
	}

	public void setEmId(java.lang.Long emId) {
		this.emId = emId;
	}

	@Override
	public Intern05ImportorderBO toModel() {
		Intern05ImportorderBO intern05ImportorderBO = new Intern05ImportorderBO();
		intern05ImportorderBO.setImId(this.imId);
		intern05ImportorderBO.setPrId(this.prId);
		intern05ImportorderBO.setEmId(this.emId);
		intern05ImportorderBO.setSuId(this.suId);
		intern05ImportorderBO.setUnit(this.unit);
		intern05ImportorderBO.setQuantity(this.quantity);
		intern05ImportorderBO.setUnitPrice(this.unitPrice);
		intern05ImportorderBO.setCreateDate(this.createDate);
		intern05ImportorderBO.setNote(this.note);
		return intern05ImportorderBO;
	}

	@Override
	public Long getFWModelId() {
		return imId;
	}

	@Override
	public String catchName() {
		return getImId().toString();
	}

	public java.lang.Long getImId() {
		return imId;
	}

	public void setImId(java.lang.Long imId) {
		this.imId = imId;
	}

	public java.lang.String getUnit() {
		return unit;
	}

	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	public java.lang.Long getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Long quantity) {
		this.quantity = quantity;
	}

	public java.lang.Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(java.lang.Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public java.lang.Float getMoney() {
		return money;
	}

	public void setMoney(java.lang.Float money) {
		this.money = money;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
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

	public java.lang.String getPrCategory() {
		return prCategory;
	}

	public void setPrCategory(java.lang.String prCategory) {
		this.prCategory = prCategory;
	}

}
