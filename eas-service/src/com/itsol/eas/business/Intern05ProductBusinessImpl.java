package com.itsol.eas.business;
 
import com.itsol.eas.bo.Intern05ProductBO;
import com.itsol.eas.dao.Intern05ProductDAO;
import com.itsol.eas.dto.Intern05ProductDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("intern05ProductBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Intern05ProductBusinessImpl extends BaseFWBusinessImpl<Intern05ProductDAO,Intern05ProductDTO, Intern05ProductBO> implements Intern05ProductBusiness {

    @Autowired
    private Intern05ProductDAO intern05ProductDAO;
    

     
    public Intern05ProductBusinessImpl() {
        tModel = new Intern05ProductBO();
        tDAO = intern05ProductDAO;
    }

    @Override
    public Intern05ProductDAO gettDAO() {
        return intern05ProductDAO;
    }

    @Override
    public long count() {
        return intern05ProductDAO.count("Intern05ProductBO", null);
    }

    @Override
    public Intern05ProductDTO getOneById(Long id) {
        return intern05ProductDAO.getOneById(id);
    }

    
}
