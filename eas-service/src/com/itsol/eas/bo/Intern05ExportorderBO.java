/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05ExportorderDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_EXPORTORDER")
@SuppressWarnings("serial")
/**
 *
 * @author: DATNQ
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05ExportorderBO extends BaseFWModelImpl {

	private java.lang.Long exId;
	private java.lang.String unit;
	private java.lang.Long quantity;
	private java.lang.Float unitPrice;
	private java.util.Date createDate;
	private java.lang.String note;
	private java.lang.Long emId;
	private java.lang.Long prId;

	public Intern05ExportorderBO() {
		setColId("exId");
		setColName("exId");
		setUniqueColumn(new String[] { "exId" });
	}

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_EXPORTORDER_SEQ") })
	@Column(name = "EX_ID", length = 22)
	public java.lang.Long getExId() {
		return exId;
	}

	public void setExId(java.lang.Long exId) {
		this.exId = exId;
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

	@Override
	public Intern05ExportorderDTO toDTO() {
		Intern05ExportorderDTO intern05ExportorderDTO = new Intern05ExportorderDTO();
		// set cac gia tri
		intern05ExportorderDTO.setUnit(this.unit);
		intern05ExportorderDTO.setQuantity(this.quantity);
		intern05ExportorderDTO.setNote(this.note);
		intern05ExportorderDTO.setCreateDate(this.createDate);
		intern05ExportorderDTO.setExId(this.exId);
		intern05ExportorderDTO.setUnitPrice(this.unitPrice);
		return intern05ExportorderDTO;
	}
}
