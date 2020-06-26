package com.ashish.application.web.rest;

import com.ashish.application.service.IDBCompanyDetailsService;
import com.ashish.application.web.rest.errors.BadRequestAlertException;
import com.ashish.application.service.dto.IDBCompanyDetailsDTO;

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
 * REST controller for managing {@link com.ashish.application.domain.IDBCompanyDetails}.
 */
@RestController
@RequestMapping("/api")
public class IDBCompanyDetailsResource {

    private final Logger log = LoggerFactory.getLogger(IDBCompanyDetailsResource.class);

    private static final String ENTITY_NAME = "iDBCompanyDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IDBCompanyDetailsService iDBCompanyDetailsService;

    public IDBCompanyDetailsResource(IDBCompanyDetailsService iDBCompanyDetailsService) {
        this.iDBCompanyDetailsService = iDBCompanyDetailsService;
    }

    /**
     * {@code POST  /idb-company-details} : Create a new iDBCompanyDetails.
     *
     * @param iDBCompanyDetailsDTO the iDBCompanyDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iDBCompanyDetailsDTO, or with status {@code 400 (Bad Request)} if the iDBCompanyDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/idb-company-details")
    public ResponseEntity<IDBCompanyDetailsDTO> createIDBCompanyDetails(@RequestBody IDBCompanyDetailsDTO iDBCompanyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save IDBCompanyDetails : {}", iDBCompanyDetailsDTO);
        if (iDBCompanyDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new iDBCompanyDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IDBCompanyDetailsDTO result = iDBCompanyDetailsService.save(iDBCompanyDetailsDTO);
        return ResponseEntity.created(new URI("/api/idb-company-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /idb-company-details} : Updates an existing iDBCompanyDetails.
     *
     * @param iDBCompanyDetailsDTO the iDBCompanyDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iDBCompanyDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the iDBCompanyDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iDBCompanyDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/idb-company-details")
    public ResponseEntity<IDBCompanyDetailsDTO> updateIDBCompanyDetails(@RequestBody IDBCompanyDetailsDTO iDBCompanyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update IDBCompanyDetails : {}", iDBCompanyDetailsDTO);
        if (iDBCompanyDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IDBCompanyDetailsDTO result = iDBCompanyDetailsService.save(iDBCompanyDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iDBCompanyDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /idb-company-details} : get all the iDBCompanyDetails.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iDBCompanyDetails in body.
     */
    @GetMapping("/idb-company-details")
    public List<IDBCompanyDetailsDTO> getAllIDBCompanyDetails() {
        log.debug("REST request to get all IDBCompanyDetails");
        return iDBCompanyDetailsService.findAll();
    }

    /**
     * {@code GET  /idb-company-details/:id} : get the "id" iDBCompanyDetails.
     *
     * @param id the id of the iDBCompanyDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iDBCompanyDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/idb-company-details/{id}")
    public ResponseEntity<IDBCompanyDetailsDTO> getIDBCompanyDetails(@PathVariable Long id) {
        log.debug("REST request to get IDBCompanyDetails : {}", id);
        Optional<IDBCompanyDetailsDTO> iDBCompanyDetailsDTO = iDBCompanyDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iDBCompanyDetailsDTO);
    }

    /**
     * {@code DELETE  /idb-company-details/:id} : delete the "id" iDBCompanyDetails.
     *
     * @param id the id of the iDBCompanyDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/idb-company-details/{id}")
    public ResponseEntity<Void> deleteIDBCompanyDetails(@PathVariable Long id) {
        log.debug("REST request to delete IDBCompanyDetails : {}", id);
        iDBCompanyDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
