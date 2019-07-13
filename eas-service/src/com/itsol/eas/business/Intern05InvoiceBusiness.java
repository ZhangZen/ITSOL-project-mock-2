package com.itsol.eas.business;

import java.util.List;

import com.itsol.eas.dto.Intern05InvoiceDTO;


public interface Intern05InvoiceBusiness {

    long count();
    //get all invoice
    List<Intern05InvoiceDTO> getAllInvoice();

	List<Intern05InvoiceDTO> doSearch(Intern05InvoiceDTO criteria);
}
