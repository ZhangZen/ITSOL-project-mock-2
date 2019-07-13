/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05LiteracyBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author BuiBaTruong
 */
@XmlRootElement(name = "INTERN05_LITERACYBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05LiteracyDTO extends BaseFWDTOImpl<Intern05LiteracyBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4425678243761151097L;
	private java.lang.Long liId;
	private java.lang.String liName;

	@Override
	public Intern05LiteracyBO toModel() {
		Intern05LiteracyBO intern05LiteracyBO = new Intern05LiteracyBO();
		intern05LiteracyBO.setLiId(this.liId);
		intern05LiteracyBO.setLiName(this.liName);
		return intern05LiteracyBO;
	}

	@Override
	public Long getFWModelId() {
		return liId;
	}

	@Override
	public String catchName() {
		return getLiId().toString();
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

}
