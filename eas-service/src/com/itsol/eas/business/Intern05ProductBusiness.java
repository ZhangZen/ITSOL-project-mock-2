package com.itsol.eas.business;

import com.itsol.eas.dto.Intern05ProductDTO;

public interface Intern05ProductBusiness {

    long count();
    
    Intern05ProductDTO getOneById(Long id);
}
