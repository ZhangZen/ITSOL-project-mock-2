package com.itsol.eas.business;
 
import com.itsol.eas.bo.Intern05InvoiceBO;
import com.itsol.eas.dao.Intern05InvoiceDAO;
import com.itsol.eas.dto.Intern05InvoiceDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("intern05InvoiceBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05InvoiceBusinessImpl extends BaseFWBusinessImpl<Intern05InvoiceDAO,Intern05InvoiceDTO, Intern05InvoiceBO> 
implements Intern05InvoiceBusiness {

    @Autowired
    private Intern05InvoiceDAO intern05InvoiceDAO;
     
    public Intern05InvoiceBusinessImpl() {
        tModel = new Intern05InvoiceBO();
        tDAO = intern05InvoiceDAO;
    }

    @Override
    public Intern05InvoiceDAO gettDAO() {
        return intern05InvoiceDAO;
    }

    @Override
    public long count() {
        return intern05InvoiceDAO.count("Intern05InvoiceBO", null);
    }   
    
    @Override
	public List<Intern05InvoiceDTO> getAllInvoice() {
		return intern05InvoiceDAO.getAllInvoice();
	}

    @Override
	public List<Intern05InvoiceDTO> doSearch(Intern05InvoiceDTO criteria) {
		return intern05InvoiceDAO.doSearch(criteria);
	}
}
