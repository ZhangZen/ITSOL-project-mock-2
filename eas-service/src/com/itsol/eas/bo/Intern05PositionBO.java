/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05PositionDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_POSITION")
@SuppressWarnings("serial")
/**
 *
 * @author: BuiBaTruong
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05PositionBO extends BaseFWModelImpl {

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_POSITION_SEQ") })
	@Column(name = "PO_ID", length = 22)
	private java.lang.Long poId;

	@Column(name = "PO_NAME", length = 100)
	private java.lang.String poName;

	public Intern05PositionBO() {
		setColId("poId");
		setColName("poId");
		setUniqueColumn(new String[] { "poId" });
	}

	public java.lang.Long getPoId() {
		return poId;
	}

	public void setPoId(java.lang.Long poId) {
		this.poId = poId;
	}

	public java.lang.String getPoName() {
		return poName;
	}

	public void setPoName(java.lang.String poName) {
		this.poName = poName;
	}

	@Override
	public Intern05PositionDTO toDTO() {
		Intern05PositionDTO intern05PositionDTO = new Intern05PositionDTO();
		intern05PositionDTO.setPoId(this.poId);
		intern05PositionDTO.setPoName(this.poName);
		return intern05PositionDTO;
	}
}
