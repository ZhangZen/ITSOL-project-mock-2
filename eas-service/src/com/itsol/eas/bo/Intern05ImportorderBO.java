/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05ImportorderDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_IMPORTORDER")
@SuppressWarnings("serial")
/**
 *
 * @author: DATNQ
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05ImportorderBO extends BaseFWModelImpl {

	private java.lang.Long imId;
	private java.lang.String unit;
	private java.lang.Long quantity;
	private java.lang.Float unitPrice;
	private java.util.Date createDate;
	private java.lang.String note;
	private java.lang.Long emId;
	private java.lang.Long prId;
	private java.lang.Long suId;

	public Intern05ImportorderBO() {
		setColId("imId");
		setColName("imId");
		setUniqueColumn(new String[] { "imId" });
	}

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_IMPORTORDER_SEQ") })
	@Column(name = "IM_ID", length = 22)
	public java.lang.Long getImId() {
		return imId;
	}

	public void setImId(java.lang.Long imId) {
		this.imId = imId;
	}

	@Column(name = "UNIT", length = 10)
	public java.lang.String getUnit() {
		return unit;
	}

	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	@Column(name = "QUANTITY", length = 10)
	public java.lang.Long getQuantity() {
		return quantity;
	}

	public void setQuantity(java.lang.Long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "UNIT_PRICE", length = 22)
	public java.lang.Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(java.lang.Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "CREATE_DATE", length = 7)
	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "NOTE", length = 510)
	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
	}

	@Column(name = "EM_ID", length = 22)
	public java.lang.Long getEmId() {
		return emId;
	}

	public void setEmId(java.lang.Long emId) {
		this.emId = emId;
	}

	@Column(name = "PR_ID", length = 22)
	public java.lang.Long getPrId() {
		return prId;
	}

	public void setPrId(java.lang.Long prId) {
		this.prId = prId;
	}

	@Column(name = "SU_ID", length = 22)
	public java.lang.Long getSuId() {
		return suId;
	}

	public void setSuId(java.lang.Long suId) {
		this.suId = suId;
	}

	@Override
	public Intern05ImportorderDTO toDTO() {
		Intern05ImportorderDTO intern05ImportorderDTO = new Intern05ImportorderDTO();
		// set cac gia tri
		intern05ImportorderDTO.setImId(this.imId);
		intern05ImportorderDTO.setUnit(this.unit);
		intern05ImportorderDTO.setQuantity(this.quantity);
		intern05ImportorderDTO.setUnitPrice(this.unitPrice);
		intern05ImportorderDTO.setCreateDate(this.createDate);
		intern05ImportorderDTO.setNote(this.note);
		return intern05ImportorderDTO;
	}
}
