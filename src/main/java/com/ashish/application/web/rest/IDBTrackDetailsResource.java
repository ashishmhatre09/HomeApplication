package com.ashish.application.web.rest;

import com.ashish.application.service.IDBTrackDetailsService;
import com.ashish.application.web.rest.errors.BadRequestAlertException;
import com.ashish.application.service.dto.IDBTrackDetailsDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.ashish.application.domain.IDBTrackDetails}.
 */
@RestController
@RequestMapping("/api")
public class IDBTrackDetailsResource {

    private final Logger log = LoggerFactory.getLogger(IDBTrackDetailsResource.class);

    private static final String ENTITY_NAME = "iDBTrackDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IDBTrackDetailsService iDBTrackDetailsService;

    public IDBTrackDetailsResource(IDBTrackDetailsService iDBTrackDetailsService) {
        this.iDBTrackDetailsService = iDBTrackDetailsService;
    }

    /**
     * {@code POST  /idb-track-details} : Create a new iDBTrackDetails.
     *
     * @param iDBTrackDetailsDTO the iDBTrackDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iDBTrackDetailsDTO, or with status {@code 400 (Bad Request)} if the iDBTrackDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/idb-track-details")
    public ResponseEntity<IDBTrackDetailsDTO> createIDBTrackDetails(@RequestBody IDBTrackDetailsDTO iDBTrackDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save IDBTrackDetails : {}", iDBTrackDetailsDTO);
        if (iDBTrackDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new iDBTrackDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IDBTrackDetailsDTO result = iDBTrackDetailsService.save(iDBTrackDetailsDTO);
        return ResponseEntity.created(new URI("/api/idb-track-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /idb-track-details} : Updates an existing iDBTrackDetails.
     *
     * @param iDBTrackDetailsDTO the iDBTrackDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iDBTrackDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the iDBTrackDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iDBTrackDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/idb-track-details")
    public ResponseEntity<IDBTrackDetailsDTO> updateIDBTrackDetails(@RequestBody IDBTrackDetailsDTO iDBTrackDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update IDBTrackDetails : {}", iDBTrackDetailsDTO);
        if (iDBTrackDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IDBTrackDetailsDTO result = iDBTrackDetailsService.save(iDBTrackDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iDBTrackDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /idb-track-details} : get all the iDBTrackDetails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iDBTrackDetails in body.
     */
    @GetMapping("/idb-track-details")
    public List<IDBTrackDetailsDTO> getAllIDBTrackDetails() {
        log.debug("REST request to get all IDBTrackDetails");
        return iDBTrackDetailsService.findAll();
    }

    /**
     * {@code GET  /idb-track-details/:id} : get the "id" iDBTrackDetails.
     *
     * @param id the id of the iDBTrackDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iDBTrackDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/idb-track-details/{id}")
    public ResponseEntity<IDBTrackDetailsDTO> getIDBTrackDetails(@PathVariable Long id) {
        log.debug("REST request to get IDBTrackDetails : {}", id);
        Optional<IDBTrackDetailsDTO> iDBTrackDetailsDTO = iDBTrackDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iDBTrackDetailsDTO);
    }

    /**
     * {@code DELETE  /idb-track-details/:id} : delete the "id" iDBTrackDetails.
     *
     * @param id the id of the iDBTrackDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/idb-track-details/{id}")
    public ResponseEntity<Void> deleteIDBTrackDetails(@PathVariable Long id) {
        log.debug("REST request to delete IDBTrackDetails : {}", id);
        iDBTrackDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
