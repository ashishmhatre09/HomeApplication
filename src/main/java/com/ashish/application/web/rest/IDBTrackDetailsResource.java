package com.ashish.application.web.rest;

import com.ashish.application.domain.IDBTrackDetails;
import com.ashish.application.repository.IDBTrackDetailsRepository;
import com.ashish.application.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class IDBTrackDetailsResource {

    private final Logger log = LoggerFactory.getLogger(IDBTrackDetailsResource.class);

    private static final String ENTITY_NAME = "iDBTrackDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IDBTrackDetailsRepository iDBTrackDetailsRepository;

    public IDBTrackDetailsResource(IDBTrackDetailsRepository iDBTrackDetailsRepository) {
        this.iDBTrackDetailsRepository = iDBTrackDetailsRepository;
    }

    /**
     * {@code POST  /idb-track-details} : Create a new iDBTrackDetails.
     *
     * @param iDBTrackDetails the iDBTrackDetails to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iDBTrackDetails, or with status {@code 400 (Bad Request)} if the iDBTrackDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/idb-track-details")
    public ResponseEntity<IDBTrackDetails> createIDBTrackDetails(@RequestBody IDBTrackDetails iDBTrackDetails) throws URISyntaxException {
        log.debug("REST request to save IDBTrackDetails : {}", iDBTrackDetails);
        if (iDBTrackDetails.getId() != null) {
            throw new BadRequestAlertException("A new iDBTrackDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IDBTrackDetails result = iDBTrackDetailsRepository.save(iDBTrackDetails);
        return ResponseEntity.created(new URI("/api/idb-track-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /idb-track-details} : Updates an existing iDBTrackDetails.
     *
     * @param iDBTrackDetails the iDBTrackDetails to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iDBTrackDetails,
     * or with status {@code 400 (Bad Request)} if the iDBTrackDetails is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iDBTrackDetails couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/idb-track-details")
    public ResponseEntity<IDBTrackDetails> updateIDBTrackDetails(@RequestBody IDBTrackDetails iDBTrackDetails) throws URISyntaxException {
        log.debug("REST request to update IDBTrackDetails : {}", iDBTrackDetails);
        if (iDBTrackDetails.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IDBTrackDetails result = iDBTrackDetailsRepository.save(iDBTrackDetails);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iDBTrackDetails.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /idb-track-details} : get all the iDBTrackDetails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iDBTrackDetails in body.
     */
    @GetMapping("/idb-track-details")
    public List<IDBTrackDetails> getAllIDBTrackDetails() {
        log.debug("REST request to get all IDBTrackDetails");
        return iDBTrackDetailsRepository.findAll();
    }

    /**
     * {@code GET  /idb-track-details/:id} : get the "id" iDBTrackDetails.
     *
     * @param id the id of the iDBTrackDetails to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iDBTrackDetails, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/idb-track-details/{id}")
    public ResponseEntity<IDBTrackDetails> getIDBTrackDetails(@PathVariable Long id) {
        log.debug("REST request to get IDBTrackDetails : {}", id);
        Optional<IDBTrackDetails> iDBTrackDetails = iDBTrackDetailsRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(iDBTrackDetails);
    }

    /**
     * {@code DELETE  /idb-track-details/:id} : delete the "id" iDBTrackDetails.
     *
     * @param id the id of the iDBTrackDetails to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/idb-track-details/{id}")
    public ResponseEntity<Void> deleteIDBTrackDetails(@PathVariable Long id) {
        log.debug("REST request to delete IDBTrackDetails : {}", id);
        iDBTrackDetailsRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
