package com.itsol.eas.business;

import java.util.List;

import com.itsol.eas.dto.Intern05InvoiceDetailDTO;

public interface Intern05InvoiceDetailBusiness {

	long count();

	List<Intern05InvoiceDetailDTO> getInvoiceDetailByInvoiceId(Long id);
}
