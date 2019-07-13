/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05PositionBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author BuiBaTruong
 */
@XmlRootElement(name = "INTERN05_POSITIONBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05PositionDTO extends BaseFWDTOImpl<Intern05PositionBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7974768154592518764L;
	private java.lang.Long poId;
	private java.lang.String poName;

	@Override
	public Intern05PositionBO toModel() {
		Intern05PositionBO intern05PositionBO = new Intern05PositionBO();
		intern05PositionBO.setPoId(this.poId);
		intern05PositionBO.setPoName(this.poName);
		return intern05PositionBO;
	}

	@Override
	public Long getFWModelId() {
		return poId;
	}

	@Override
	public String catchName() {
		return getPoId().toString();
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

}
