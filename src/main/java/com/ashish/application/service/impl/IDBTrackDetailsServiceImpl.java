package com.ashish.application.service.impl;

import com.ashish.application.service.IDBTrackDetailsService;
import com.ashish.application.domain.IDBTrackDetails;
import com.ashish.application.repository.IDBTrackDetailsRepository;
import com.ashish.application.service.dto.IDBTrackDetailsDTO;
import com.ashish.application.service.mapper.IDBTrackDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link IDBTrackDetails}.
 */
@Service
@Transactional
public class IDBTrackDetailsServiceImpl implements IDBTrackDetailsService {

    private final Logger log = LoggerFactory.getLogger(IDBTrackDetailsServiceImpl.class);

    private final IDBTrackDetailsRepository iDBTrackDetailsRepository;

    private final IDBTrackDetailsMapper iDBTrackDetailsMapper;

    public IDBTrackDetailsServiceImpl(IDBTrackDetailsRepository iDBTrackDetailsRepository, IDBTrackDetailsMapper iDBTrackDetailsMapper) {
        this.iDBTrackDetailsRepository = iDBTrackDetailsRepository;
        this.iDBTrackDetailsMapper = iDBTrackDetailsMapper;
    }

    /**
     * Save a iDBTrackDetails.
     *
     * @param iDBTrackDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public IDBTrackDetailsDTO save(IDBTrackDetailsDTO iDBTrackDetailsDTO) {
        log.debug("Request to save IDBTrackDetails : {}", iDBTrackDetailsDTO);
        IDBTrackDetails iDBTrackDetails = iDBTrackDetailsMapper.toEntity(iDBTrackDetailsDTO);
        iDBTrackDetails = iDBTrackDetailsRepository.save(iDBTrackDetails);
        return iDBTrackDetailsMapper.toDto(iDBTrackDetails);
    }

    /**
     * Get all the iDBTrackDetails.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<IDBTrackDetailsDTO> findAll() {
        log.debug("Request to get all IDBTrackDetails");
        return iDBTrackDetailsRepository.findAll().stream()
            .map(iDBTrackDetailsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one iDBTrackDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IDBTrackDetailsDTO> findOne(Long id) {
        log.debug("Request to get IDBTrackDetails : {}", id);
        return iDBTrackDetailsRepository.findById(id)
            .map(iDBTrackDetailsMapper::toDto);
    }

    /**
     * Delete the iDBTrackDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IDBTrackDetails : {}", id);
        iDBTrackDetailsRepository.deleteById(id);
    }
}
