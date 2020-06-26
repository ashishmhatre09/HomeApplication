package com.ashish.application.web.rest;

import com.ashish.application.HomeApplicationApp;
import com.ashish.application.domain.IDBCompanyDetails;
import com.ashish.application.repository.IDBCompanyDetailsRepository;
import com.ashish.application.service.IDBCompanyDetailsService;
import com.ashish.application.service.dto.IDBCompanyDetailsDTO;
import com.ashish.application.service.mapper.IDBCompanyDetailsMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link IDBCompanyDetailsResource} REST controller.
 */
@SpringBootTest(classes = HomeApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class IDBCompanyDetailsResourceIT {

    private static final String DEFAULT_COMPANY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MEETING_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_MEETING_NUMBER = "BBBBBBBBBB";

    private static final Instant DEFAULT_MEETING_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_MEETING_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_PR_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_PR_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CRR_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CRR_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_OS_LT_RATING = "AAAAAAAAAA";
    private static final String UPDATED_OS_LT_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_OS_ST_RATING = "AAAAAAAAAA";
    private static final String UPDATED_OS_ST_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_OS_OUTLOOK = "AAAAAAAAAA";
    private static final String UPDATED_OS_OUTLOOK = "BBBBBBBBBB";

    private static final String DEFAULT_OS_OTHER_RATING = "AAAAAAAAAA";
    private static final String UPDATED_OS_OTHER_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNED_LT_RATING = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNED_LT_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNED_ST_RATING = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNED_ST_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNED_OUTLOOK = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNED_OUTLOOK = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNED_OTHER_RATING = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNED_OTHER_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_CLASSIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_CLASSIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_OS_LT_RTG_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_OS_LT_RTG_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_OS_ST_RTG_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_OS_ST_RTG_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_EXECUTING_DEPARTMENT = "AAAAAAAAAA";
    private static final String UPDATED_EXECUTING_DEPARTMENT = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_ON = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_ON = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private IDBCompanyDetailsRepository iDBCompanyDetailsRepository;

    @Autowired
    private IDBCompanyDetailsMapper iDBCompanyDetailsMapper;

    @Autowired
    private IDBCompanyDetailsService iDBCompanyDetailsService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIDBCompanyDetailsMockMvc;

    private IDBCompanyDetails iDBCompanyDetails;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IDBCompanyDetails createEntity(EntityManager em) {
        IDBCompanyDetails iDBCompanyDetails = new IDBCompanyDetails()
            .companyCode(DEFAULT_COMPANY_CODE)
            .companyName(DEFAULT_COMPANY_NAME)
            .meetingNumber(DEFAULT_MEETING_NUMBER)
            .meetingDate(DEFAULT_MEETING_DATE)
            .prDate(DEFAULT_PR_DATE)
            .crrDate(DEFAULT_CRR_DATE)
            .osLtRating(DEFAULT_OS_LT_RATING)
            .osStRating(DEFAULT_OS_ST_RATING)
            .osOutlook(DEFAULT_OS_OUTLOOK)
            .osOtherRating(DEFAULT_OS_OTHER_RATING)
            .assignedLtRating(DEFAULT_ASSIGNED_LT_RATING)
            .assignedStRating(DEFAULT_ASSIGNED_ST_RATING)
            .assignedOutlook(DEFAULT_ASSIGNED_OUTLOOK)
            .assignedOtherRating(DEFAULT_ASSIGNED_OTHER_RATING)
            .companyClassification(DEFAULT_COMPANY_CLASSIFICATION)
            .osLtRtgCategory(DEFAULT_OS_LT_RTG_CATEGORY)
            .osStRtgCategory(DEFAULT_OS_ST_RTG_CATEGORY)
            .executingDepartment(DEFAULT_EXECUTING_DEPARTMENT)
            .createdOn(DEFAULT_CREATED_ON);
        return iDBCompanyDetails;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IDBCompanyDetails createUpdatedEntity(EntityManager em) {
        IDBCompanyDetails iDBCompanyDetails = new IDBCompanyDetails()
            .companyCode(UPDATED_COMPANY_CODE)
            .companyName(UPDATED_COMPANY_NAME)
            .meetingNumber(UPDATED_MEETING_NUMBER)
            .meetingDate(UPDATED_MEETING_DATE)
            .prDate(UPDATED_PR_DATE)
            .crrDate(UPDATED_CRR_DATE)
            .osLtRating(UPDATED_OS_LT_RATING)
            .osStRating(UPDATED_OS_ST_RATING)
            .osOutlook(UPDATED_OS_OUTLOOK)
            .osOtherRating(UPDATED_OS_OTHER_RATING)
            .assignedLtRating(UPDATED_ASSIGNED_LT_RATING)
            .assignedStRating(UPDATED_ASSIGNED_ST_RATING)
            .assignedOutlook(UPDATED_ASSIGNED_OUTLOOK)
            .assignedOtherRating(UPDATED_ASSIGNED_OTHER_RATING)
            .companyClassification(UPDATED_COMPANY_CLASSIFICATION)
            .osLtRtgCategory(UPDATED_OS_LT_RTG_CATEGORY)
            .osStRtgCategory(UPDATED_OS_ST_RTG_CATEGORY)
            .executingDepartment(UPDATED_EXECUTING_DEPARTMENT)
            .createdOn(UPDATED_CREATED_ON);
        return iDBCompanyDetails;
    }

    @BeforeEach
    public void initTest() {
        iDBCompanyDetails = createEntity(em);
    }

    @Test
    @Transactional
    public void createIDBCompanyDetails() throws Exception {
        int databaseSizeBeforeCreate = iDBCompanyDetailsRepository.findAll().size();
        // Create the IDBCompanyDetails
        IDBCompanyDetailsDTO iDBCompanyDetailsDTO = iDBCompanyDetailsMapper.toDto(iDBCompanyDetails);
        restIDBCompanyDetailsMockMvc.perform(post("/api/idb-company-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBCompanyDetailsDTO)))
            .andExpect(status().isCreated());

        // Validate the IDBCompanyDetails in the database
        List<IDBCompanyDetails> iDBCompanyDetailsList = iDBCompanyDetailsRepository.findAll();
        assertThat(iDBCompanyDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        IDBCompanyDetails testIDBCompanyDetails = iDBCompanyDetailsList.get(iDBCompanyDetailsList.size() - 1);
        assertThat(testIDBCompanyDetails.getCompanyCode()).isEqualTo(DEFAULT_COMPANY_CODE);
        assertThat(testIDBCompanyDetails.getCompanyName()).isEqualTo(DEFAULT_COMPANY_NAME);
        assertThat(testIDBCompanyDetails.getMeetingNumber()).isEqualTo(DEFAULT_MEETING_NUMBER);
        assertThat(testIDBCompanyDetails.getMeetingDate()).isEqualTo(DEFAULT_MEETING_DATE);
        assertThat(testIDBCompanyDetails.getPrDate()).isEqualTo(DEFAULT_PR_DATE);
        assertThat(testIDBCompanyDetails.getCrrDate()).isEqualTo(DEFAULT_CRR_DATE);
        assertThat(testIDBCompanyDetails.getOsLtRating()).isEqualTo(DEFAULT_OS_LT_RATING);
        assertThat(testIDBCompanyDetails.getOsStRating()).isEqualTo(DEFAULT_OS_ST_RATING);
        assertThat(testIDBCompanyDetails.getOsOutlook()).isEqualTo(DEFAULT_OS_OUTLOOK);
        assertThat(testIDBCompanyDetails.getOsOtherRating()).isEqualTo(DEFAULT_OS_OTHER_RATING);
        assertThat(testIDBCompanyDetails.getAssignedLtRating()).isEqualTo(DEFAULT_ASSIGNED_LT_RATING);
        assertThat(testIDBCompanyDetails.getAssignedStRating()).isEqualTo(DEFAULT_ASSIGNED_ST_RATING);
        assertThat(testIDBCompanyDetails.getAssignedOutlook()).isEqualTo(DEFAULT_ASSIGNED_OUTLOOK);
        assertThat(testIDBCompanyDetails.getAssignedOtherRating()).isEqualTo(DEFAULT_ASSIGNED_OTHER_RATING);
        assertThat(testIDBCompanyDetails.getCompanyClassification()).isEqualTo(DEFAULT_COMPANY_CLASSIFICATION);
        assertThat(testIDBCompanyDetails.getOsLtRtgCategory()).isEqualTo(DEFAULT_OS_LT_RTG_CATEGORY);
        assertThat(testIDBCompanyDetails.getOsStRtgCategory()).isEqualTo(DEFAULT_OS_ST_RTG_CATEGORY);
        assertThat(testIDBCompanyDetails.getExecutingDepartment()).isEqualTo(DEFAULT_EXECUTING_DEPARTMENT);
        assertThat(testIDBCompanyDetails.getCreatedOn()).isEqualTo(DEFAULT_CREATED_ON);
    }

    @Test
    @Transactional
    public void createIDBCompanyDetailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = iDBCompanyDetailsRepository.findAll().size();

        // Create the IDBCompanyDetails with an existing ID
        iDBCompanyDetails.setId(1L);
        IDBCompanyDetailsDTO iDBCompanyDetailsDTO = iDBCompanyDetailsMapper.toDto(iDBCompanyDetails);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIDBCompanyDetailsMockMvc.perform(post("/api/idb-company-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBCompanyDetailsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IDBCompanyDetails in the database
        List<IDBCompanyDetails> iDBCompanyDetailsList = iDBCompanyDetailsRepository.findAll();
        assertThat(iDBCompanyDetailsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllIDBCompanyDetails() throws Exception {
        // Initialize the database
        iDBCompanyDetailsRepository.saveAndFlush(iDBCompanyDetails);

        // Get all the iDBCompanyDetailsList
        restIDBCompanyDetailsMockMvc.perform(get("/api/idb-company-details?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(iDBCompanyDetails.getId().intValue())))
            .andExpect(jsonPath("$.[*].companyCode").value(hasItem(DEFAULT_COMPANY_CODE)))
            .andExpect(jsonPath("$.[*].companyName").value(hasItem(DEFAULT_COMPANY_NAME)))
            .andExpect(jsonPath("$.[*].meetingNumber").value(hasItem(DEFAULT_MEETING_NUMBER)))
            .andExpect(jsonPath("$.[*].meetingDate").value(hasItem(DEFAULT_MEETING_DATE.toString())))
            .andExpect(jsonPath("$.[*].prDate").value(hasItem(DEFAULT_PR_DATE.toString())))
            .andExpect(jsonPath("$.[*].crrDate").value(hasItem(DEFAULT_CRR_DATE.toString())))
            .andExpect(jsonPath("$.[*].osLtRating").value(hasItem(DEFAULT_OS_LT_RATING)))
            .andExpect(jsonPath("$.[*].osStRating").value(hasItem(DEFAULT_OS_ST_RATING)))
            .andExpect(jsonPath("$.[*].osOutlook").value(hasItem(DEFAULT_OS_OUTLOOK)))
            .andExpect(jsonPath("$.[*].osOtherRating").value(hasItem(DEFAULT_OS_OTHER_RATING)))
            .andExpect(jsonPath("$.[*].assignedLtRating").value(hasItem(DEFAULT_ASSIGNED_LT_RATING)))
            .andExpect(jsonPath("$.[*].assignedStRating").value(hasItem(DEFAULT_ASSIGNED_ST_RATING)))
            .andExpect(jsonPath("$.[*].assignedOutlook").value(hasItem(DEFAULT_ASSIGNED_OUTLOOK)))
            .andExpect(jsonPath("$.[*].assignedOtherRating").value(hasItem(DEFAULT_ASSIGNED_OTHER_RATING)))
            .andExpect(jsonPath("$.[*].companyClassification").value(hasItem(DEFAULT_COMPANY_CLASSIFICATION)))
            .andExpect(jsonPath("$.[*].osLtRtgCategory").value(hasItem(DEFAULT_OS_LT_RTG_CATEGORY)))
            .andExpect(jsonPath("$.[*].osStRtgCategory").value(hasItem(DEFAULT_OS_ST_RTG_CATEGORY)))
            .andExpect(jsonPath("$.[*].executingDepartment").value(hasItem(DEFAULT_EXECUTING_DEPARTMENT)))
            .andExpect(jsonPath("$.[*].createdOn").value(hasItem(DEFAULT_CREATED_ON.toString())));
    }
    
    @Test
    @Transactional
    public void getIDBCompanyDetails() throws Exception {
        // Initialize the database
        iDBCompanyDetailsRepository.saveAndFlush(iDBCompanyDetails);

        // Get the iDBCompanyDetails
        restIDBCompanyDetailsMockMvc.perform(get("/api/idb-company-details/{id}", iDBCompanyDetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(iDBCompanyDetails.getId().intValue()))
            .andExpect(jsonPath("$.companyCode").value(DEFAULT_COMPANY_CODE))
            .andExpect(jsonPath("$.companyName").value(DEFAULT_COMPANY_NAME))
            .andExpect(jsonPath("$.meetingNumber").value(DEFAULT_MEETING_NUMBER))
            .andExpect(jsonPath("$.meetingDate").value(DEFAULT_MEETING_DATE.toString()))
            .andExpect(jsonPath("$.prDate").value(DEFAULT_PR_DATE.toString()))
            .andExpect(jsonPath("$.crrDate").value(DEFAULT_CRR_DATE.toString()))
            .andExpect(jsonPath("$.osLtRating").value(DEFAULT_OS_LT_RATING))
            .andExpect(jsonPath("$.osStRating").value(DEFAULT_OS_ST_RATING))
            .andExpect(jsonPath("$.osOutlook").value(DEFAULT_OS_OUTLOOK))
            .andExpect(jsonPath("$.osOtherRating").value(DEFAULT_OS_OTHER_RATING))
            .andExpect(jsonPath("$.assignedLtRating").value(DEFAULT_ASSIGNED_LT_RATING))
            .andExpect(jsonPath("$.assignedStRating").value(DEFAULT_ASSIGNED_ST_RATING))
            .andExpect(jsonPath("$.assignedOutlook").value(DEFAULT_ASSIGNED_OUTLOOK))
            .andExpect(jsonPath("$.assignedOtherRating").value(DEFAULT_ASSIGNED_OTHER_RATING))
            .andExpect(jsonPath("$.companyClassification").value(DEFAULT_COMPANY_CLASSIFICATION))
            .andExpect(jsonPath("$.osLtRtgCategory").value(DEFAULT_OS_LT_RTG_CATEGORY))
            .andExpect(jsonPath("$.osStRtgCategory").value(DEFAULT_OS_ST_RTG_CATEGORY))
            .andExpect(jsonPath("$.executingDepartment").value(DEFAULT_EXECUTING_DEPARTMENT))
            .andExpect(jsonPath("$.createdOn").value(DEFAULT_CREATED_ON.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingIDBCompanyDetails() throws Exception {
        // Get the iDBCompanyDetails
        restIDBCompanyDetailsMockMvc.perform(get("/api/idb-company-details/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIDBCompanyDetails() throws Exception {
        // Initialize the database
        iDBCompanyDetailsRepository.saveAndFlush(iDBCompanyDetails);

        int databaseSizeBeforeUpdate = iDBCompanyDetailsRepository.findAll().size();

        // Update the iDBCompanyDetails
        IDBCompanyDetails updatedIDBCompanyDetails = iDBCompanyDetailsRepository.findById(iDBCompanyDetails.getId()).get();
        // Disconnect from session so that the updates on updatedIDBCompanyDetails are not directly saved in db
        em.detach(updatedIDBCompanyDetails);
        updatedIDBCompanyDetails
            .companyCode(UPDATED_COMPANY_CODE)
            .companyName(UPDATED_COMPANY_NAME)
            .meetingNumber(UPDATED_MEETING_NUMBER)
            .meetingDate(UPDATED_MEETING_DATE)
            .prDate(UPDATED_PR_DATE)
            .crrDate(UPDATED_CRR_DATE)
            .osLtRating(UPDATED_OS_LT_RATING)
            .osStRating(UPDATED_OS_ST_RATING)
            .osOutlook(UPDATED_OS_OUTLOOK)
            .osOtherRating(UPDATED_OS_OTHER_RATING)
            .assignedLtRating(UPDATED_ASSIGNED_LT_RATING)
            .assignedStRating(UPDATED_ASSIGNED_ST_RATING)
            .assignedOutlook(UPDATED_ASSIGNED_OUTLOOK)
            .assignedOtherRating(UPDATED_ASSIGNED_OTHER_RATING)
            .companyClassification(UPDATED_COMPANY_CLASSIFICATION)
            .osLtRtgCategory(UPDATED_OS_LT_RTG_CATEGORY)
            .osStRtgCategory(UPDATED_OS_ST_RTG_CATEGORY)
            .executingDepartment(UPDATED_EXECUTING_DEPARTMENT)
            .createdOn(UPDATED_CREATED_ON);
        IDBCompanyDetailsDTO iDBCompanyDetailsDTO = iDBCompanyDetailsMapper.toDto(updatedIDBCompanyDetails);

        restIDBCompanyDetailsMockMvc.perform(put("/api/idb-company-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBCompanyDetailsDTO)))
            .andExpect(status().isOk());

        // Validate the IDBCompanyDetails in the database
        List<IDBCompanyDetails> iDBCompanyDetailsList = iDBCompanyDetailsRepository.findAll();
        assertThat(iDBCompanyDetailsList).hasSize(databaseSizeBeforeUpdate);
        IDBCompanyDetails testIDBCompanyDetails = iDBCompanyDetailsList.get(iDBCompanyDetailsList.size() - 1);
        assertThat(testIDBCompanyDetails.getCompanyCode()).isEqualTo(UPDATED_COMPANY_CODE);
        assertThat(testIDBCompanyDetails.getCompanyName()).isEqualTo(UPDATED_COMPANY_NAME);
        assertThat(testIDBCompanyDetails.getMeetingNumber()).isEqualTo(UPDATED_MEETING_NUMBER);
        assertThat(testIDBCompanyDetails.getMeetingDate()).isEqualTo(UPDATED_MEETING_DATE);
        assertThat(testIDBCompanyDetails.getPrDate()).isEqualTo(UPDATED_PR_DATE);
        assertThat(testIDBCompanyDetails.getCrrDate()).isEqualTo(UPDATED_CRR_DATE);
        assertThat(testIDBCompanyDetails.getOsLtRating()).isEqualTo(UPDATED_OS_LT_RATING);
        assertThat(testIDBCompanyDetails.getOsStRating()).isEqualTo(UPDATED_OS_ST_RATING);
        assertThat(testIDBCompanyDetails.getOsOutlook()).isEqualTo(UPDATED_OS_OUTLOOK);
        assertThat(testIDBCompanyDetails.getOsOtherRating()).isEqualTo(UPDATED_OS_OTHER_RATING);
        assertThat(testIDBCompanyDetails.getAssignedLtRating()).isEqualTo(UPDATED_ASSIGNED_LT_RATING);
        assertThat(testIDBCompanyDetails.getAssignedStRating()).isEqualTo(UPDATED_ASSIGNED_ST_RATING);
        assertThat(testIDBCompanyDetails.getAssignedOutlook()).isEqualTo(UPDATED_ASSIGNED_OUTLOOK);
        assertThat(testIDBCompanyDetails.getAssignedOtherRating()).isEqualTo(UPDATED_ASSIGNED_OTHER_RATING);
        assertThat(testIDBCompanyDetails.getCompanyClassification()).isEqualTo(UPDATED_COMPANY_CLASSIFICATION);
        assertThat(testIDBCompanyDetails.getOsLtRtgCategory()).isEqualTo(UPDATED_OS_LT_RTG_CATEGORY);
        assertThat(testIDBCompanyDetails.getOsStRtgCategory()).isEqualTo(UPDATED_OS_ST_RTG_CATEGORY);
        assertThat(testIDBCompanyDetails.getExecutingDepartment()).isEqualTo(UPDATED_EXECUTING_DEPARTMENT);
        assertThat(testIDBCompanyDetails.getCreatedOn()).isEqualTo(UPDATED_CREATED_ON);
    }

    @Test
    @Transactional
    public void updateNonExistingIDBCompanyDetails() throws Exception {
        int databaseSizeBeforeUpdate = iDBCompanyDetailsRepository.findAll().size();

        // Create the IDBCompanyDetails
        IDBCompanyDetailsDTO iDBCompanyDetailsDTO = iDBCompanyDetailsMapper.toDto(iDBCompanyDetails);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIDBCompanyDetailsMockMvc.perform(put("/api/idb-company-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBCompanyDetailsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the IDBCompanyDetails in the database
        List<IDBCompanyDetails> iDBCompanyDetailsList = iDBCompanyDetailsRepository.findAll();
        assertThat(iDBCompanyDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIDBCompanyDetails() throws Exception {
        // Initialize the database
        iDBCompanyDetailsRepository.saveAndFlush(iDBCompanyDetails);

        int databaseSizeBeforeDelete = iDBCompanyDetailsRepository.findAll().size();

        // Delete the iDBCompanyDetails
        restIDBCompanyDetailsMockMvc.perform(delete("/api/idb-company-details/{id}", iDBCompanyDetails.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IDBCompanyDetails> iDBCompanyDetailsList = iDBCompanyDetailsRepository.findAll();
        assertThat(iDBCompanyDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
