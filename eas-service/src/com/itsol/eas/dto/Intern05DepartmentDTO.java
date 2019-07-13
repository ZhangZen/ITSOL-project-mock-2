/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05DepartmentBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author BuiBaTruong
 */
@XmlRootElement(name = "INTERN05_DEPARTMENTBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05DepartmentDTO extends BaseFWDTOImpl<Intern05DepartmentBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931476319900164510L;
	private java.lang.String deName;
	private java.lang.Long deId;
	private java.lang.String dePhone;

	@Override
	public Intern05DepartmentBO toModel() {
		Intern05DepartmentBO intern05DepartmentBO = new Intern05DepartmentBO();
		intern05DepartmentBO.setDeName(this.deName);
		intern05DepartmentBO.setDeId(this.deId);
		intern05DepartmentBO.setDePhone(this.dePhone);
		return intern05DepartmentBO;
	}

	public java.lang.String getDeName() {
		return deName;
	}

	public void setDeName(java.lang.String deName) {
		this.deName = deName;
	}

	@Override
	public Long getFWModelId() {
		return deId;
	}

	@Override
	public String catchName() {
		return getDeId().toString();
	}

	public java.lang.Long getDeId() {
		return deId;
	}

	public void setDeId(java.lang.Long deId) {
		this.deId = deId;
	}

	public java.lang.String getDePhone() {
		return dePhone;
	}

	public void setDePhone(java.lang.String dePhone) {
		this.dePhone = dePhone;
	}

}
