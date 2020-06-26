package com.ashish.application.service;

import com.ashish.application.service.dto.IDBTrackDetailsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ashish.application.domain.IDBTrackDetails}.
 */
public interface IDBTrackDetailsService {

    /**
     * Save a iDBTrackDetails.
     *
     * @param iDBTrackDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    IDBTrackDetailsDTO save(IDBTrackDetailsDTO iDBTrackDetailsDTO);

    /**
     * Get all the iDBTrackDetails.
     *
     * @return the list of entities.
     */
    List<IDBTrackDetailsDTO> findAll();


    /**
     * Get the "id" iDBTrackDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IDBTrackDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" iDBTrackDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
