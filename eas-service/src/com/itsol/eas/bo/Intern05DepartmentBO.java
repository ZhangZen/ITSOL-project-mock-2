/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05DepartmentDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_DEPARTMENT")
@SuppressWarnings("serial")
/**
 *
 * @author: BuiBaTruong
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05DepartmentBO extends BaseFWModelImpl {

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_DEPARTMENT_SEQ") })
	@Column(name = "DE_ID", length = 22)
	private java.lang.Long deId;

	@Column(name = "DE_NAME", length = 100)
	private java.lang.String deName;

	@Column(name = "DE_PHONE", length = 30)
	private java.lang.String dePhone;

	public Intern05DepartmentBO() {
		setColId("deId");
		setColName("deId");
		setUniqueColumn(new String[] { "deId" });
	}

	public java.lang.Long getDeId() {
		return deId;
	}

	public void setDeId(java.lang.Long deId) {
		this.deId = deId;
	}

	public java.lang.String getDeName() {
		return deName;
	}

	public void setDeName(java.lang.String deName) {
		this.deName = deName;
	}

	public java.lang.String getDePhone() {
		return dePhone;
	}

	public void setDePhone(java.lang.String dePhone) {
		this.dePhone = dePhone;
	}

	@Override
	public Intern05DepartmentDTO toDTO() {
		Intern05DepartmentDTO intern05DepartmentDTO = new Intern05DepartmentDTO();
		intern05DepartmentDTO.setDeName(this.deName);
		intern05DepartmentDTO.setDeId(this.deId);
		intern05DepartmentDTO.setDePhone(this.dePhone);
		return intern05DepartmentDTO;
	}
}
