package com.ashish.application.service;

import com.ashish.application.service.dto.IDBCompanyDetailsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ashish.application.domain.IDBCompanyDetails}.
 */
public interface IDBCompanyDetailsService {

    /**
     * Save a iDBCompanyDetails.
     *
     * @param iDBCompanyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    IDBCompanyDetailsDTO save(IDBCompanyDetailsDTO iDBCompanyDetailsDTO);

    /**
     * Get all the iDBCompanyDetails.
     *
     * @return the list of entities.
     */
    List<IDBCompanyDetailsDTO> findAll();


    /**
     * Get the "id" iDBCompanyDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IDBCompanyDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" iDBCompanyDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
