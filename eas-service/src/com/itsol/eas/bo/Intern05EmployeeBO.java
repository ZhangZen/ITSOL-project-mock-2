/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05EmployeeDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_EMPLOYEE")
@SuppressWarnings("serial")

/**
 *
 * @author: BuiBaTruong
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05EmployeeBO extends BaseFWModelImpl {

	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int UNKNOWN = 3;

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_EMPLOYEE_SEQ") })
	@Column(name = "EM_ID", length = 20)
	private java.lang.Long emId;

	@Column(name = "EM_FIRSTNAME", length = 60)
	private java.lang.String emFirstname;

	@Column(name = "EM_LASTNAME", length = 60)
	private java.lang.String emLastname;

	@Column(name = "EM_BIRTHDAY", length = 7)
	private java.util.Date emBirthday;

	@Column(name = "EM_HOMETOWN", length = 60)
	private java.lang.String emHometown;

	@Column(name = "EM_SEX", length = 22)
	private java.lang.Long emSex;

	@Column(name = "EM_ETHNIC", length = 60)
	private java.lang.String emEthnic;

	@Column(name = "EM_PHONE", length = 30)
	private java.lang.String emPhone;

	@Column(name = "EM_STARTEDDATE", length = 7)
	private java.util.Date emStarteddate;

	@Column(name = "DE_ID", length = 22)
	private java.lang.Long deId;

	@Column(name = "PO_ID", length = 22)
	private java.lang.Long poId;

	@Column(name = "LI_ID", length = 22)
	private java.lang.Long liId;

	@Column(name = "SA_LEVEL", length = 22)
	private java.lang.Long saLevel;

	public Intern05EmployeeBO() {
		setColId("emId");
		setColName("emId");
		setUniqueColumn(new String[] { "emId" });
	}

	public java.lang.Long getEmId() {
		return emId;
	}

	public void setEmId(java.lang.Long emId) {
		this.emId = emId;
	}

	public java.lang.String getEmFirstname() {
		return emFirstname;
	}

	public void setEmFirstname(java.lang.String emFirstname) {
		this.emFirstname = emFirstname;
	}

	public java.lang.String getEmLastname() {
		return emLastname;
	}

	public void setEmLastname(java.lang.String emLastname) {
		this.emLastname = emLastname;
	}

	public java.util.Date getEmBirthday() {
		return emBirthday;
	}

	public void setEmBirthday(java.util.Date emBirthday) {
		this.emBirthday = emBirthday;
	}

	public java.lang.String getEmHometown() {
		return emHometown;
	}

	public void setEmHometown(java.lang.String emHometown) {
		this.emHometown = emHometown;
	}

	public java.lang.Long getEmSex() {
		return emSex;
	}

	public void setEmSex(java.lang.Long emSex) {
		this.emSex = emSex;
	}

	public java.lang.String getEmEthnic() {
		return emEthnic;
	}

	public void setEmEthnic(java.lang.String emEthnic) {
		this.emEthnic = emEthnic;
	}

	public java.lang.String getEmPhone() {
		return emPhone;
	}

	public void setEmPhone(java.lang.String emPhone) {
		this.emPhone = emPhone;
	}

	public java.util.Date getEmStarteddate() {
		return emStarteddate;
	}

	public void setEmStarteddate(java.util.Date emStarteddate) {
		this.emStarteddate = emStarteddate;
	}

	public java.lang.Long getDeId() {
		return deId;
	}

	public void setDeId(java.lang.Long deId) {
		this.deId = deId;
	}

	public java.lang.Long getPoId() {
		return poId;
	}

	public void setPoId(java.lang.Long poId) {
		this.poId = poId;
	}

	public java.lang.Long getLiId() {
		return liId;
	}

	public void setLiId(java.lang.Long liId) {
		this.liId = liId;
	}

	public java.lang.Long getSaLevel() {
		return saLevel;
	}

	public void setSaLevel(java.lang.Long saLevel) {
		this.saLevel = saLevel;
	}

	@Override
	public Intern05EmployeeDTO toDTO() {
		Intern05EmployeeDTO intern05EmployeeDTO = new Intern05EmployeeDTO();
		intern05EmployeeDTO.setEmId(this.emId);
		intern05EmployeeDTO.setEmFirstname(this.emFirstname);
		intern05EmployeeDTO.setEmLastname(this.emLastname);
		intern05EmployeeDTO.setEmBirthday(this.emBirthday);
		intern05EmployeeDTO.setEmHometown(this.emHometown);
		intern05EmployeeDTO.setEmSex(this.emSex);
		intern05EmployeeDTO.setEmEthnic(this.emEthnic);
		intern05EmployeeDTO.setEmPhone(this.emPhone);
		intern05EmployeeDTO.setEmStarteddate(this.emStarteddate);
		intern05EmployeeDTO.setDeId(this.deId);
		intern05EmployeeDTO.setPoId(this.poId);
		intern05EmployeeDTO.setLiId(this.liId);
		intern05EmployeeDTO.setSaLevel(this.saLevel);
		return intern05EmployeeDTO;
	}
}
