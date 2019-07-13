/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05LiteracyDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_LITERACY")
@SuppressWarnings("serial")
/**
 *
 * @author: BuiBaTruong
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05LiteracyBO extends BaseFWModelImpl {

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_LITERACY_SEQ") })
	@Column(name = "LI_ID", length = 22)
	private java.lang.Long liId;

	@Column(name = "LI_NAME", length = 100)
	private java.lang.String liName;

	public Intern05LiteracyBO() {
		setColId("liId");
		setColName("liId");
		setUniqueColumn(new String[] { "liId" });
	}

	public java.lang.Long getLiId() {
		return liId;
	}

	public void setLiId(java.lang.Long liId) {
		this.liId = liId;
	}

	public java.lang.String getLiName() {
		return liName;
	}

	public void setLiName(java.lang.String liName) {
		this.liName = liName;
	}

	@Override
	public Intern05LiteracyDTO toDTO() {
		Intern05LiteracyDTO intern05LiteracyDTO = new Intern05LiteracyDTO();
		intern05LiteracyDTO.setLiId(this.liId);
		intern05LiteracyDTO.setLiName(this.liName);
		return intern05LiteracyDTO;
	}
}
