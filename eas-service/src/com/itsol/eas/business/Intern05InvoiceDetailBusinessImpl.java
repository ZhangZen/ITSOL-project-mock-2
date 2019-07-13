package com.itsol.eas.business;
 
import com.itsol.eas.bo.Intern05InvoiceDetailBO;
import com.itsol.eas.dao.Intern05InvoiceDetailDAO;
import com.itsol.eas.dto.Intern05InvoiceDetailDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("intern05InvoiceDetailBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05InvoiceDetailBusinessImpl extends BaseFWBusinessImpl<Intern05InvoiceDetailDAO,Intern05InvoiceDetailDTO, Intern05InvoiceDetailBO> implements Intern05InvoiceDetailBusiness {

    @Autowired
    private Intern05InvoiceDetailDAO intern05InvoiceDetailDAO;
    

     
    public Intern05InvoiceDetailBusinessImpl() {
        tModel = new Intern05InvoiceDetailBO();
        tDAO = intern05InvoiceDetailDAO;
    }

    @Override
    public Intern05InvoiceDetailDAO gettDAO() {
        return intern05InvoiceDetailDAO;
    }

    @Override
    public long count() {
        return intern05InvoiceDetailDAO.count("Intern05InvoiceDetailBO", null);
    }
    
    @Override
	public List<Intern05InvoiceDetailDTO> getInvoiceDetailByInvoiceId(Long id) {
		return intern05InvoiceDetailDAO.getInvoiceDetailByInvoiceId(id);
	}

    

    
}
