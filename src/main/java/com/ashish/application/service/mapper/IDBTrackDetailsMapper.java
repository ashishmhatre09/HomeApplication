package com.ashish.application.service.mapper;


import com.ashish.application.domain.*;
import com.ashish.application.service.dto.IDBTrackDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IDBTrackDetails} and its DTO {@link IDBTrackDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IDBTrackDetailsMapper extends EntityMapper<IDBTrackDetailsDTO, IDBTrackDetails> {



    default IDBTrackDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        IDBTrackDetails iDBTrackDetails = new IDBTrackDetails();
        iDBTrackDetails.setId(id);
        return iDBTrackDetails;
    }
}
