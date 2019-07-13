package com.itsol.eas.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement(name = "INTERN05_DEPARTMENTBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intern05CitiesDTO {

	private java.lang.Long ciId;
	private java.lang.String ciName;

	public Intern05CitiesDTO() {
		// TODO Auto-generated constructor stub
	}

	public Intern05CitiesDTO(Long ciId, String ciName) {
		super();
		this.ciId = ciId;
		this.ciName = ciName;
	}

	public java.lang.Long getCiId() {
		return ciId;
	}

	public void setCiId(java.lang.Long ciId) {
		this.ciId = ciId;
	}

	public java.lang.String getCiName() {
		return ciName;
	}

	public void setCiName(java.lang.String ciName) {
		this.ciName = ciName;
	}

}
