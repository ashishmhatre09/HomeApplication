package com.ashish.application.service.mapper;


import com.ashish.application.domain.*;
import com.ashish.application.service.dto.IDBCompanyDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IDBCompanyDetails} and its DTO {@link IDBCompanyDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IDBCompanyDetailsMapper extends EntityMapper<IDBCompanyDetailsDTO, IDBCompanyDetails> {



    default IDBCompanyDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        IDBCompanyDetails iDBCompanyDetails = new IDBCompanyDetails();
        iDBCompanyDetails.setId(id);
        return iDBCompanyDetails;
    }
}
