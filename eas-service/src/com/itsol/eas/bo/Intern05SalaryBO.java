/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.itsol.eas.bo;

import com.itsol.eas.dto.Intern05SalaryDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "INTERN05_SALARY")
@SuppressWarnings("serial")
/**
 *
 * @author: BuiBaTruong
 * @version: 1.0
 * @since: 1.0
 */
public class Intern05SalaryBO extends BaseFWModelImpl {

	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@Parameter(name = "sequence", value = "INTERN05_SALARY_SEQ") })
	@Column(name = "SA_LEVEL", length = 22)
	private java.lang.Long saLevel;

	@Column(name = "SA_BASIC", length = 22)
	private java.lang.Float saBasic;

	@Column(name = "SA_COEFFICIENT", length = 22)
	private java.lang.Float saCoefficient;

	@Column(name = "SA_ALLOWANCECOEFFICIENT", length = 22)
	private java.lang.Float saAllowancecoefficient;

	public Intern05SalaryBO() {
		setColId("saLevel");
		setColName("saLevel");
		setUniqueColumn(new String[] { "saLevel" });
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

	public java.lang.Float getSaCoefficient() {
		return saCoefficient;
	}

	public void setSaCoefficient(java.lang.Float saCoefficient) {
		this.saCoefficient = saCoefficient;
	}

	public java.lang.Float getSaAllowancecoefficient() {
		return saAllowancecoefficient;
	}

	public void setSaAllowancecoefficient(java.lang.Float saAllowancecoefficient) {
		this.saAllowancecoefficient = saAllowancecoefficient;
	}

	@Override
	public Intern05SalaryDTO toDTO() {
		Intern05SalaryDTO intern05SalaryDTO = new Intern05SalaryDTO();
		intern05SalaryDTO.setSaCoefficient(this.saCoefficient);
		intern05SalaryDTO.setSaLevel(this.saLevel);
		intern05SalaryDTO.setSaBasic(this.saBasic);
		intern05SalaryDTO.setSaAllowancecoefficient(this.saAllowancecoefficient);
		return intern05SalaryDTO;
	}
}
