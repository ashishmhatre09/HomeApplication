package com.ashish.application.service.impl;

import com.ashish.application.service.IDBCompanyDetailsService;
import com.ashish.application.domain.IDBCompanyDetails;
import com.ashish.application.repository.IDBCompanyDetailsRepository;
import com.ashish.application.service.dto.IDBCompanyDetailsDTO;
import com.ashish.application.service.mapper.IDBCompanyDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link IDBCompanyDetails}.
 */
@Service
@Transactional
public class IDBCompanyDetailsServiceImpl implements IDBCompanyDetailsService {

    private final Logger log = LoggerFactory.getLogger(IDBCompanyDetailsServiceImpl.class);

    private final IDBCompanyDetailsRepository iDBCompanyDetailsRepository;

    private final IDBCompanyDetailsMapper iDBCompanyDetailsMapper;

    public IDBCompanyDetailsServiceImpl(IDBCompanyDetailsRepository iDBCompanyDetailsRepository, IDBCompanyDetailsMapper iDBCompanyDetailsMapper) {
        this.iDBCompanyDetailsRepository = iDBCompanyDetailsRepository;
        this.iDBCompanyDetailsMapper = iDBCompanyDetailsMapper;
    }

    /**
     * Save a iDBCompanyDetails.
     *
     * @param iDBCompanyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public IDBCompanyDetailsDTO save(IDBCompanyDetailsDTO iDBCompanyDetailsDTO) {
        log.debug("Request to save IDBCompanyDetails : {}", iDBCompanyDetailsDTO);
        IDBCompanyDetails iDBCompanyDetails = iDBCompanyDetailsMapper.toEntity(iDBCompanyDetailsDTO);
        iDBCompanyDetails = iDBCompanyDetailsRepository.save(iDBCompanyDetails);
        return iDBCompanyDetailsMapper.toDto(iDBCompanyDetails);
    }

    /**
     * Get all the iDBCompanyDetails.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<IDBCompanyDetailsDTO> findAll() {
        log.debug("Request to get all IDBCompanyDetails");
        return iDBCompanyDetailsRepository.findAll().stream()
            .map(iDBCompanyDetailsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one iDBCompanyDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IDBCompanyDetailsDTO> findOne(Long id) {
        log.debug("Request to get IDBCompanyDetails : {}", id);
        return iDBCompanyDetailsRepository.findById(id)
            .map(iDBCompanyDetailsMapper::toDto);
    }

    /**
     * Delete the iDBCompanyDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IDBCompanyDetails : {}", id);
        iDBCompanyDetailsRepository.deleteById(id);
    }
}
