/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05SalaryBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author BuiBaTruong
 */
@XmlRootElement(name = "INTERN05_SALARYBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05SalaryDTO extends BaseFWDTOImpl<Intern05SalaryBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 350256519108370464L;
	private java.lang.Float saCoefficient;
	private java.lang.Long saLevel;
	private java.lang.Float saBasic;
	private java.lang.Float saAllowancecoefficient;

	@Override
	public Intern05SalaryBO toModel() {
		Intern05SalaryBO intern05SalaryBO = new Intern05SalaryBO();
		intern05SalaryBO.setSaCoefficient(this.saCoefficient);
		intern05SalaryBO.setSaLevel(this.saLevel);
		intern05SalaryBO.setSaBasic(this.saBasic);
		intern05SalaryBO.setSaAllowancecoefficient(this.saAllowancecoefficient);
		return intern05SalaryBO;
	}

	public java.lang.Float getSaCoefficient() {
		return saCoefficient;
	}

	public void setSaCoefficient(java.lang.Float saCoefficient) {
		this.saCoefficient = saCoefficient;
	}

	@Override
	public Long getFWModelId() {
		return saLevel;
	}

	@Override
	public String catchName() {
		return getSaLevel().toString();
	}

	public java.lang.Long getSaLevel() {
		return saLevel;
	}

	public void setSaLevel(java.lang.Long saLevel) {
		this.saLevel = saLevel;
	}

	public java.lang.Float getSaBasic() {
		return saBasic;
	}

	public void setSaBasic(java.lang.Float saBasic) {
		this.saBasic = saBasic;
	}

	public java.lang.Float getSaAllowancecoefficient() {
		return saAllowancecoefficient;
	}

	public void setSaAllowancecoefficient(java.lang.Float saAllowancecoefficient) {
		this.saAllowancecoefficient = saAllowancecoefficient;
	}

}
