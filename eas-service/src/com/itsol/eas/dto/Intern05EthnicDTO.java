package com.itsol.eas.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "INTERN05_DEPARTMENTBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05EthnicDTO {

	private java.lang.Long ethId;
	private java.lang.String ethName;

	public Intern05EthnicDTO() {
		// TODO Auto-generated constructor stub
	}

	public Intern05EthnicDTO(Long ethId, String ethName) {
		super();
		this.ethId = ethId;
		this.ethName = ethName;
	}

	public java.lang.Long getEthId() {
		return ethId;
	}

	public void setEthId(java.lang.Long ethId) {
		this.ethId = ethId;
	}

	public java.lang.String getEthName() {
		return ethName;
	}

	public void setEthName(java.lang.String ethName) {
		this.ethName = ethName;
	}

}
