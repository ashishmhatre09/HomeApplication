package com.ashish.application.web.rest;

import com.ashish.application.HomeApplicationApp;
import com.ashish.application.domain.IDBTrackDetails;
import com.ashish.application.repository.IDBTrackDetailsRepository;

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
 * Integration tests for the {@link IDBTrackDetailsResource} REST controller.
 */
@SpringBootTest(classes = HomeApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class IDBTrackDetailsResourceIT {

    private static final String DEFAULT_COMPANY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ASSIGNMENT_ID = 1;
    private static final Integer UPDATED_ASSIGNMENT_ID = 2;

    private static final Integer DEFAULT_TRACK_ID = 1;
    private static final Integer UPDATED_TRACK_ID = 2;

    private static final Integer DEFAULT_NUMBER_OF_DAYS = 1;
    private static final Integer UPDATED_NUMBER_OF_DAYS = 2;

    private static final String DEFAULT_EMPLOYEE_ID = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_LEVEL_ID = 1;
    private static final Integer UPDATED_LEVEL_ID = 2;

    private static final String DEFAULT_LISTED = "AAAAAAAAAA";
    private static final String UPDATED_LISTED = "BBBBBBBBBB";

    private static final String DEFAULT_WITHDRAWAL_OPTION = "AAAAAAAAAA";
    private static final String UPDATED_WITHDRAWAL_OPTION = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNE_LT_RATING = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNE_LT_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNE_ST_RATING = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNE_ST_RATING = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNED_OUTLOOK = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNED_OUTLOOK = "BBBBBBBBBB";

    private static final String DEFAULT_ASSIGNED_OTHER_RATING = "AAAAAAAAAA";
    private static final String UPDATED_ASSIGNED_OTHER_RATING = "BBBBBBBBBB";

    private static final Integer DEFAULT_TOTAL_NUMBEROF_DAYS = 1;
    private static final Integer UPDATED_TOTAL_NUMBEROF_DAYS = 2;

    private static final String DEFAULT_COMPANY_CLASSIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_CLASSIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_REASON = "AAAAAAAAAA";
    private static final String UPDATED_REASON = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS = "BBBBBBBBBB";

    private static final Instant DEFAULT_TARGET_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_TARGET_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CREATED_ON = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_ON = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_EXECUTING_DEPARTMENT = "AAAAAAAAAA";
    private static final String UPDATED_EXECUTING_DEPARTMENT = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_NAME = "BBBBBBBBBB";

    @Autowired
    private IDBTrackDetailsRepository iDBTrackDetailsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restIDBTrackDetailsMockMvc;

    private IDBTrackDetails iDBTrackDetails;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IDBTrackDetails createEntity(EntityManager em) {
        IDBTrackDetails iDBTrackDetails = new IDBTrackDetails()
            .companyCode(DEFAULT_COMPANY_CODE)
            .assignmentId(DEFAULT_ASSIGNMENT_ID)
            .trackId(DEFAULT_TRACK_ID)
            .numberOfDays(DEFAULT_NUMBER_OF_DAYS)
            .employeeId(DEFAULT_EMPLOYEE_ID)
            .employeeName(DEFAULT_EMPLOYEE_NAME)
            .levelId(DEFAULT_LEVEL_ID)
            .listed(DEFAULT_LISTED)
            .withdrawalOption(DEFAULT_WITHDRAWAL_OPTION)
            .assigneLtRating(DEFAULT_ASSIGNE_LT_RATING)
            .assigneStRating(DEFAULT_ASSIGNE_ST_RATING)
            .assignedOutlook(DEFAULT_ASSIGNED_OUTLOOK)
            .assignedOtherRating(DEFAULT_ASSIGNED_OTHER_RATING)
            .totalNumberofDays(DEFAULT_TOTAL_NUMBEROF_DAYS)
            .companyClassification(DEFAULT_COMPANY_CLASSIFICATION)
            .reason(DEFAULT_REASON)
            .comments(DEFAULT_COMMENTS)
            .targetDate(DEFAULT_TARGET_DATE)
            .createdOn(DEFAULT_CREATED_ON)
            .executingDepartment(DEFAULT_EXECUTING_DEPARTMENT)
            .companyName(DEFAULT_COMPANY_NAME);
        return iDBTrackDetails;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static IDBTrackDetails createUpdatedEntity(EntityManager em) {
        IDBTrackDetails iDBTrackDetails = new IDBTrackDetails()
            .companyCode(UPDATED_COMPANY_CODE)
            .assignmentId(UPDATED_ASSIGNMENT_ID)
            .trackId(UPDATED_TRACK_ID)
            .numberOfDays(UPDATED_NUMBER_OF_DAYS)
            .employeeId(UPDATED_EMPLOYEE_ID)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .levelId(UPDATED_LEVEL_ID)
            .listed(UPDATED_LISTED)
            .withdrawalOption(UPDATED_WITHDRAWAL_OPTION)
            .assigneLtRating(UPDATED_ASSIGNE_LT_RATING)
            .assigneStRating(UPDATED_ASSIGNE_ST_RATING)
            .assignedOutlook(UPDATED_ASSIGNED_OUTLOOK)
            .assignedOtherRating(UPDATED_ASSIGNED_OTHER_RATING)
            .totalNumberofDays(UPDATED_TOTAL_NUMBEROF_DAYS)
            .companyClassification(UPDATED_COMPANY_CLASSIFICATION)
            .reason(UPDATED_REASON)
            .comments(UPDATED_COMMENTS)
            .targetDate(UPDATED_TARGET_DATE)
            .createdOn(UPDATED_CREATED_ON)
            .executingDepartment(UPDATED_EXECUTING_DEPARTMENT)
            .companyName(UPDATED_COMPANY_NAME);
        return iDBTrackDetails;
    }

    @BeforeEach
    public void initTest() {
        iDBTrackDetails = createEntity(em);
    }

    @Test
    @Transactional
    public void createIDBTrackDetails() throws Exception {
        int databaseSizeBeforeCreate = iDBTrackDetailsRepository.findAll().size();
        // Create the IDBTrackDetails
        restIDBTrackDetailsMockMvc.perform(post("/api/idb-track-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBTrackDetails)))
            .andExpect(status().isCreated());

        // Validate the IDBTrackDetails in the database
        List<IDBTrackDetails> iDBTrackDetailsList = iDBTrackDetailsRepository.findAll();
        assertThat(iDBTrackDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        IDBTrackDetails testIDBTrackDetails = iDBTrackDetailsList.get(iDBTrackDetailsList.size() - 1);
        assertThat(testIDBTrackDetails.getCompanyCode()).isEqualTo(DEFAULT_COMPANY_CODE);
        assertThat(testIDBTrackDetails.getAssignmentId()).isEqualTo(DEFAULT_ASSIGNMENT_ID);
        assertThat(testIDBTrackDetails.getTrackId()).isEqualTo(DEFAULT_TRACK_ID);
        assertThat(testIDBTrackDetails.getNumberOfDays()).isEqualTo(DEFAULT_NUMBER_OF_DAYS);
        assertThat(testIDBTrackDetails.getEmployeeId()).isEqualTo(DEFAULT_EMPLOYEE_ID);
        assertThat(testIDBTrackDetails.getEmployeeName()).isEqualTo(DEFAULT_EMPLOYEE_NAME);
        assertThat(testIDBTrackDetails.getLevelId()).isEqualTo(DEFAULT_LEVEL_ID);
        assertThat(testIDBTrackDetails.getListed()).isEqualTo(DEFAULT_LISTED);
        assertThat(testIDBTrackDetails.getWithdrawalOption()).isEqualTo(DEFAULT_WITHDRAWAL_OPTION);
        assertThat(testIDBTrackDetails.getAssigneLtRating()).isEqualTo(DEFAULT_ASSIGNE_LT_RATING);
        assertThat(testIDBTrackDetails.getAssigneStRating()).isEqualTo(DEFAULT_ASSIGNE_ST_RATING);
        assertThat(testIDBTrackDetails.getAssignedOutlook()).isEqualTo(DEFAULT_ASSIGNED_OUTLOOK);
        assertThat(testIDBTrackDetails.getAssignedOtherRating()).isEqualTo(DEFAULT_ASSIGNED_OTHER_RATING);
        assertThat(testIDBTrackDetails.getTotalNumberofDays()).isEqualTo(DEFAULT_TOTAL_NUMBEROF_DAYS);
        assertThat(testIDBTrackDetails.getCompanyClassification()).isEqualTo(DEFAULT_COMPANY_CLASSIFICATION);
        assertThat(testIDBTrackDetails.getReason()).isEqualTo(DEFAULT_REASON);
        assertThat(testIDBTrackDetails.getComments()).isEqualTo(DEFAULT_COMMENTS);
        assertThat(testIDBTrackDetails.getTargetDate()).isEqualTo(DEFAULT_TARGET_DATE);
        assertThat(testIDBTrackDetails.getCreatedOn()).isEqualTo(DEFAULT_CREATED_ON);
        assertThat(testIDBTrackDetails.getExecutingDepartment()).isEqualTo(DEFAULT_EXECUTING_DEPARTMENT);
        assertThat(testIDBTrackDetails.getCompanyName()).isEqualTo(DEFAULT_COMPANY_NAME);
    }

    @Test
    @Transactional
    public void createIDBTrackDetailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = iDBTrackDetailsRepository.findAll().size();

        // Create the IDBTrackDetails with an existing ID
        iDBTrackDetails.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restIDBTrackDetailsMockMvc.perform(post("/api/idb-track-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBTrackDetails)))
            .andExpect(status().isBadRequest());

        // Validate the IDBTrackDetails in the database
        List<IDBTrackDetails> iDBTrackDetailsList = iDBTrackDetailsRepository.findAll();
        assertThat(iDBTrackDetailsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllIDBTrackDetails() throws Exception {
        // Initialize the database
        iDBTrackDetailsRepository.saveAndFlush(iDBTrackDetails);

        // Get all the iDBTrackDetailsList
        restIDBTrackDetailsMockMvc.perform(get("/api/idb-track-details?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(iDBTrackDetails.getId().intValue())))
            .andExpect(jsonPath("$.[*].companyCode").value(hasItem(DEFAULT_COMPANY_CODE)))
            .andExpect(jsonPath("$.[*].assignmentId").value(hasItem(DEFAULT_ASSIGNMENT_ID)))
            .andExpect(jsonPath("$.[*].trackId").value(hasItem(DEFAULT_TRACK_ID)))
            .andExpect(jsonPath("$.[*].numberOfDays").value(hasItem(DEFAULT_NUMBER_OF_DAYS)))
            .andExpect(jsonPath("$.[*].employeeId").value(hasItem(DEFAULT_EMPLOYEE_ID)))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME)))
            .andExpect(jsonPath("$.[*].levelId").value(hasItem(DEFAULT_LEVEL_ID)))
            .andExpect(jsonPath("$.[*].listed").value(hasItem(DEFAULT_LISTED)))
            .andExpect(jsonPath("$.[*].withdrawalOption").value(hasItem(DEFAULT_WITHDRAWAL_OPTION)))
            .andExpect(jsonPath("$.[*].assigneLtRating").value(hasItem(DEFAULT_ASSIGNE_LT_RATING)))
            .andExpect(jsonPath("$.[*].assigneStRating").value(hasItem(DEFAULT_ASSIGNE_ST_RATING)))
            .andExpect(jsonPath("$.[*].assignedOutlook").value(hasItem(DEFAULT_ASSIGNED_OUTLOOK)))
            .andExpect(jsonPath("$.[*].assignedOtherRating").value(hasItem(DEFAULT_ASSIGNED_OTHER_RATING)))
            .andExpect(jsonPath("$.[*].totalNumberofDays").value(hasItem(DEFAULT_TOTAL_NUMBEROF_DAYS)))
            .andExpect(jsonPath("$.[*].companyClassification").value(hasItem(DEFAULT_COMPANY_CLASSIFICATION)))
            .andExpect(jsonPath("$.[*].reason").value(hasItem(DEFAULT_REASON)))
            .andExpect(jsonPath("$.[*].comments").value(hasItem(DEFAULT_COMMENTS)))
            .andExpect(jsonPath("$.[*].targetDate").value(hasItem(DEFAULT_TARGET_DATE.toString())))
            .andExpect(jsonPath("$.[*].createdOn").value(hasItem(DEFAULT_CREATED_ON.toString())))
            .andExpect(jsonPath("$.[*].executingDepartment").value(hasItem(DEFAULT_EXECUTING_DEPARTMENT)))
            .andExpect(jsonPath("$.[*].companyName").value(hasItem(DEFAULT_COMPANY_NAME)));
    }
    
    @Test
    @Transactional
    public void getIDBTrackDetails() throws Exception {
        // Initialize the database
        iDBTrackDetailsRepository.saveAndFlush(iDBTrackDetails);

        // Get the iDBTrackDetails
        restIDBTrackDetailsMockMvc.perform(get("/api/idb-track-details/{id}", iDBTrackDetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(iDBTrackDetails.getId().intValue()))
            .andExpect(jsonPath("$.companyCode").value(DEFAULT_COMPANY_CODE))
            .andExpect(jsonPath("$.assignmentId").value(DEFAULT_ASSIGNMENT_ID))
            .andExpect(jsonPath("$.trackId").value(DEFAULT_TRACK_ID))
            .andExpect(jsonPath("$.numberOfDays").value(DEFAULT_NUMBER_OF_DAYS))
            .andExpect(jsonPath("$.employeeId").value(DEFAULT_EMPLOYEE_ID))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME))
            .andExpect(jsonPath("$.levelId").value(DEFAULT_LEVEL_ID))
            .andExpect(jsonPath("$.listed").value(DEFAULT_LISTED))
            .andExpect(jsonPath("$.withdrawalOption").value(DEFAULT_WITHDRAWAL_OPTION))
            .andExpect(jsonPath("$.assigneLtRating").value(DEFAULT_ASSIGNE_LT_RATING))
            .andExpect(jsonPath("$.assigneStRating").value(DEFAULT_ASSIGNE_ST_RATING))
            .andExpect(jsonPath("$.assignedOutlook").value(DEFAULT_ASSIGNED_OUTLOOK))
            .andExpect(jsonPath("$.assignedOtherRating").value(DEFAULT_ASSIGNED_OTHER_RATING))
            .andExpect(jsonPath("$.totalNumberofDays").value(DEFAULT_TOTAL_NUMBEROF_DAYS))
            .andExpect(jsonPath("$.companyClassification").value(DEFAULT_COMPANY_CLASSIFICATION))
            .andExpect(jsonPath("$.reason").value(DEFAULT_REASON))
            .andExpect(jsonPath("$.comments").value(DEFAULT_COMMENTS))
            .andExpect(jsonPath("$.targetDate").value(DEFAULT_TARGET_DATE.toString()))
            .andExpect(jsonPath("$.createdOn").value(DEFAULT_CREATED_ON.toString()))
            .andExpect(jsonPath("$.executingDepartment").value(DEFAULT_EXECUTING_DEPARTMENT))
            .andExpect(jsonPath("$.companyName").value(DEFAULT_COMPANY_NAME));
    }
    @Test
    @Transactional
    public void getNonExistingIDBTrackDetails() throws Exception {
        // Get the iDBTrackDetails
        restIDBTrackDetailsMockMvc.perform(get("/api/idb-track-details/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateIDBTrackDetails() throws Exception {
        // Initialize the database
        iDBTrackDetailsRepository.saveAndFlush(iDBTrackDetails);

        int databaseSizeBeforeUpdate = iDBTrackDetailsRepository.findAll().size();

        // Update the iDBTrackDetails
        IDBTrackDetails updatedIDBTrackDetails = iDBTrackDetailsRepository.findById(iDBTrackDetails.getId()).get();
        // Disconnect from session so that the updates on updatedIDBTrackDetails are not directly saved in db
        em.detach(updatedIDBTrackDetails);
        updatedIDBTrackDetails
            .companyCode(UPDATED_COMPANY_CODE)
            .assignmentId(UPDATED_ASSIGNMENT_ID)
            .trackId(UPDATED_TRACK_ID)
            .numberOfDays(UPDATED_NUMBER_OF_DAYS)
            .employeeId(UPDATED_EMPLOYEE_ID)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .levelId(UPDATED_LEVEL_ID)
            .listed(UPDATED_LISTED)
            .withdrawalOption(UPDATED_WITHDRAWAL_OPTION)
            .assigneLtRating(UPDATED_ASSIGNE_LT_RATING)
            .assigneStRating(UPDATED_ASSIGNE_ST_RATING)
            .assignedOutlook(UPDATED_ASSIGNED_OUTLOOK)
            .assignedOtherRating(UPDATED_ASSIGNED_OTHER_RATING)
            .totalNumberofDays(UPDATED_TOTAL_NUMBEROF_DAYS)
            .companyClassification(UPDATED_COMPANY_CLASSIFICATION)
            .reason(UPDATED_REASON)
            .comments(UPDATED_COMMENTS)
            .targetDate(UPDATED_TARGET_DATE)
            .createdOn(UPDATED_CREATED_ON)
            .executingDepartment(UPDATED_EXECUTING_DEPARTMENT)
            .companyName(UPDATED_COMPANY_NAME);

        restIDBTrackDetailsMockMvc.perform(put("/api/idb-track-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedIDBTrackDetails)))
            .andExpect(status().isOk());

        // Validate the IDBTrackDetails in the database
        List<IDBTrackDetails> iDBTrackDetailsList = iDBTrackDetailsRepository.findAll();
        assertThat(iDBTrackDetailsList).hasSize(databaseSizeBeforeUpdate);
        IDBTrackDetails testIDBTrackDetails = iDBTrackDetailsList.get(iDBTrackDetailsList.size() - 1);
        assertThat(testIDBTrackDetails.getCompanyCode()).isEqualTo(UPDATED_COMPANY_CODE);
        assertThat(testIDBTrackDetails.getAssignmentId()).isEqualTo(UPDATED_ASSIGNMENT_ID);
        assertThat(testIDBTrackDetails.getTrackId()).isEqualTo(UPDATED_TRACK_ID);
        assertThat(testIDBTrackDetails.getNumberOfDays()).isEqualTo(UPDATED_NUMBER_OF_DAYS);
        assertThat(testIDBTrackDetails.getEmployeeId()).isEqualTo(UPDATED_EMPLOYEE_ID);
        assertThat(testIDBTrackDetails.getEmployeeName()).isEqualTo(UPDATED_EMPLOYEE_NAME);
        assertThat(testIDBTrackDetails.getLevelId()).isEqualTo(UPDATED_LEVEL_ID);
        assertThat(testIDBTrackDetails.getListed()).isEqualTo(UPDATED_LISTED);
        assertThat(testIDBTrackDetails.getWithdrawalOption()).isEqualTo(UPDATED_WITHDRAWAL_OPTION);
        assertThat(testIDBTrackDetails.getAssigneLtRating()).isEqualTo(UPDATED_ASSIGNE_LT_RATING);
        assertThat(testIDBTrackDetails.getAssigneStRating()).isEqualTo(UPDATED_ASSIGNE_ST_RATING);
        assertThat(testIDBTrackDetails.getAssignedOutlook()).isEqualTo(UPDATED_ASSIGNED_OUTLOOK);
        assertThat(testIDBTrackDetails.getAssignedOtherRating()).isEqualTo(UPDATED_ASSIGNED_OTHER_RATING);
        assertThat(testIDBTrackDetails.getTotalNumberofDays()).isEqualTo(UPDATED_TOTAL_NUMBEROF_DAYS);
        assertThat(testIDBTrackDetails.getCompanyClassification()).isEqualTo(UPDATED_COMPANY_CLASSIFICATION);
        assertThat(testIDBTrackDetails.getReason()).isEqualTo(UPDATED_REASON);
        assertThat(testIDBTrackDetails.getComments()).isEqualTo(UPDATED_COMMENTS);
        assertThat(testIDBTrackDetails.getTargetDate()).isEqualTo(UPDATED_TARGET_DATE);
        assertThat(testIDBTrackDetails.getCreatedOn()).isEqualTo(UPDATED_CREATED_ON);
        assertThat(testIDBTrackDetails.getExecutingDepartment()).isEqualTo(UPDATED_EXECUTING_DEPARTMENT);
        assertThat(testIDBTrackDetails.getCompanyName()).isEqualTo(UPDATED_COMPANY_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingIDBTrackDetails() throws Exception {
        int databaseSizeBeforeUpdate = iDBTrackDetailsRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restIDBTrackDetailsMockMvc.perform(put("/api/idb-track-details")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(iDBTrackDetails)))
            .andExpect(status().isBadRequest());

        // Validate the IDBTrackDetails in the database
        List<IDBTrackDetails> iDBTrackDetailsList = iDBTrackDetailsRepository.findAll();
        assertThat(iDBTrackDetailsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteIDBTrackDetails() throws Exception {
        // Initialize the database
        iDBTrackDetailsRepository.saveAndFlush(iDBTrackDetails);

        int databaseSizeBeforeDelete = iDBTrackDetailsRepository.findAll().size();

        // Delete the iDBTrackDetails
        restIDBTrackDetailsMockMvc.perform(delete("/api/idb-track-details/{id}", iDBTrackDetails.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<IDBTrackDetails> iDBTrackDetailsList = iDBTrackDetailsRepository.findAll();
        assertThat(iDBTrackDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
