/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05EmployeeBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author BuiBaTruong
 */
@XmlRootElement(name = "INTERN05_EMPLOYEEBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05EmployeeDTO extends BaseFWDTOImpl<Intern05EmployeeBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6112117261052498749L;

	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int UNKNOWN = 3;

	private java.lang.Long emId;
	private java.lang.String emFirstname;
	private java.lang.String emLastname;
	private java.util.Date emBirthday;
	private java.lang.String emHometown;
	private java.lang.Long emSex;
	private java.lang.String emEthnic;
	private java.lang.String emPhone;
	private java.util.Date emStarteddate;
	private java.lang.Long deId;
	private java.lang.Long poId;
	private java.lang.Long liId;
	private java.lang.Long saLevel;

	private java.lang.String emFullName;
	private java.lang.String emSexString;
	private java.lang.String liName;
	private java.lang.String poName;
	private java.lang.String deName;
	private java.lang.Float saBasic;
	private java.lang.Float saCoefficient;
	private java.lang.Float saAllowanceCoefficient;

	@Override
	public Intern05EmployeeBO toModel() {
		Intern05EmployeeBO intern05EmployeeBO = new Intern05EmployeeBO();
		intern05EmployeeBO.setEmId(this.emId);
		intern05EmployeeBO.setEmFirstname(this.emFirstname);
		intern05EmployeeBO.setEmLastname(this.emLastname);
		intern05EmployeeBO.setEmBirthday(this.emBirthday);
		intern05EmployeeBO.setEmHometown(this.emHometown);
		intern05EmployeeBO.setEmSex(this.emSex);
		intern05EmployeeBO.setEmEthnic(this.emEthnic);
		intern05EmployeeBO.setEmPhone(this.emPhone);
		intern05EmployeeBO.setEmStarteddate(this.emStarteddate);
		intern05EmployeeBO.setDeId(this.deId);
		intern05EmployeeBO.setPoId(this.poId);
		intern05EmployeeBO.setLiId(this.liId);
		intern05EmployeeBO.setSaLevel(this.saLevel);
		return intern05EmployeeBO;
	}

	@Override
	public Long getFWModelId() {
		return emId;
	}

	@Override
	public String catchName() {
		return getEmId().toString();
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

	public java.lang.String getEmFullName() {
		return emFullName;
	}

	public void setEmFullName(java.lang.String emFullName) {
		this.emFullName = emFullName;
	}

	public java.lang.String getEmSexString() {
		return emSexString;
	}

	public void setEmSexString(java.lang.String emSexString) {
		this.emSexString = emSexString;
	}

	public java.lang.String getLiName() {
		return liName;
	}

	public void setLiName(java.lang.String liName) {
		this.liName = liName;
	}

	public java.lang.String getPoName() {
		return poName;
	}

	public void setPoName(java.lang.String poName) {
		this.poName = poName;
	}

	public java.lang.String getDeName() {
		return deName;
	}

	public void setDeName(java.lang.String deName) {
		this.deName = deName;
	}

	public java.lang.Float getSaBasic() {
		return saBasic;
	}

	public void setSaBasic(java.lang.Float saBasic) {
		this.saBasic = saBasic;
	}

	public java.lang.Float getSaCoefficient() {
		return saCoefficient;
	}

	public void setSaCoefficient(java.lang.Float saCoefficient) {
		this.saCoefficient = saCoefficient;
	}

	public java.lang.Float getSaAllowanceCoefficient() {
		return saAllowanceCoefficient;
	}

	public void setSaAllowanceCoefficient(java.lang.Float saAllowanceCoefficient) {
		this.saAllowanceCoefficient = saAllowanceCoefficient;
	}

}
