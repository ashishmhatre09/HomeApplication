package com.ashish.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A IDBTrackDetails.
 */
@Entity
@Table(name = "idb_track_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class IDBTrackDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "assignment_id")
    private Integer assignmentId;

    @Column(name = "track_id")
    private Integer trackId;

    @Column(name = "number_of_days")
    private Integer numberOfDays;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "level_id")
    private Integer levelId;

    @Column(name = "listed")
    private String listed;

    @Column(name = "withdrawal_option")
    private String withdrawalOption;

    @Column(name = "assigne_lt_rating")
    private String assigneLtRating;

    @Column(name = "assigne_st_rating")
    private String assigneStRating;

    @Column(name = "assigned_outlook")
    private String assignedOutlook;

    @Column(name = "assigned_other_rating")
    private String assignedOtherRating;

    @Column(name = "total_numberof_days")
    private Integer totalNumberofDays;

    @Column(name = "company_classification")
    private String companyClassification;

    @Column(name = "reason")
    private String reason;

    @Column(name = "comments")
    private String comments;

    @Column(name = "target_date")
    private Instant targetDate;

    @Column(name = "created_on")
    private Instant createdOn;

    @Column(name = "executing_department")
    private String executingDepartment;

    @Column(name = "company_name")
    private String companyName;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public IDBTrackDetails companyCode(String companyCode) {
        this.companyCode = companyCode;
        return this;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public IDBTrackDetails assignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
        return this;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public IDBTrackDetails trackId(Integer trackId) {
        this.trackId = trackId;
        return this;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public IDBTrackDetails numberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public IDBTrackDetails employeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public IDBTrackDetails employeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public IDBTrackDetails levelId(Integer levelId) {
        this.levelId = levelId;
        return this;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getListed() {
        return listed;
    }

    public IDBTrackDetails listed(String listed) {
        this.listed = listed;
        return this;
    }

    public void setListed(String listed) {
        this.listed = listed;
    }

    public String getWithdrawalOption() {
        return withdrawalOption;
    }

    public IDBTrackDetails withdrawalOption(String withdrawalOption) {
        this.withdrawalOption = withdrawalOption;
        return this;
    }

    public void setWithdrawalOption(String withdrawalOption) {
        this.withdrawalOption = withdrawalOption;
    }

    public String getAssigneLtRating() {
        return assigneLtRating;
    }

    public IDBTrackDetails assigneLtRating(String assigneLtRating) {
        this.assigneLtRating = assigneLtRating;
        return this;
    }

    public void setAssigneLtRating(String assigneLtRating) {
        this.assigneLtRating = assigneLtRating;
    }

    public String getAssigneStRating() {
        return assigneStRating;
    }

    public IDBTrackDetails assigneStRating(String assigneStRating) {
        this.assigneStRating = assigneStRating;
        return this;
    }

    public void setAssigneStRating(String assigneStRating) {
        this.assigneStRating = assigneStRating;
    }

    public String getAssignedOutlook() {
        return assignedOutlook;
    }

    public IDBTrackDetails assignedOutlook(String assignedOutlook) {
        this.assignedOutlook = assignedOutlook;
        return this;
    }

    public void setAssignedOutlook(String assignedOutlook) {
        this.assignedOutlook = assignedOutlook;
    }

    public String getAssignedOtherRating() {
        return assignedOtherRating;
    }

    public IDBTrackDetails assignedOtherRating(String assignedOtherRating) {
        this.assignedOtherRating = assignedOtherRating;
        return this;
    }

    public void setAssignedOtherRating(String assignedOtherRating) {
        this.assignedOtherRating = assignedOtherRating;
    }

    public Integer getTotalNumberofDays() {
        return totalNumberofDays;
    }

    public IDBTrackDetails totalNumberofDays(Integer totalNumberofDays) {
        this.totalNumberofDays = totalNumberofDays;
        return this;
    }

    public void setTotalNumberofDays(Integer totalNumberofDays) {
        this.totalNumberofDays = totalNumberofDays;
    }

    public String getCompanyClassification() {
        return companyClassification;
    }

    public IDBTrackDetails companyClassification(String companyClassification) {
        this.companyClassification = companyClassification;
        return this;
    }

    public void setCompanyClassification(String companyClassification) {
        this.companyClassification = companyClassification;
    }

    public String getReason() {
        return reason;
    }

    public IDBTrackDetails reason(String reason) {
        this.reason = reason;
        return this;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComments() {
        return comments;
    }

    public IDBTrackDetails comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Instant getTargetDate() {
        return targetDate;
    }

    public IDBTrackDetails targetDate(Instant targetDate) {
        this.targetDate = targetDate;
        return this;
    }

    public void setTargetDate(Instant targetDate) {
        this.targetDate = targetDate;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public IDBTrackDetails createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getExecutingDepartment() {
        return executingDepartment;
    }

    public IDBTrackDetails executingDepartment(String executingDepartment) {
        this.executingDepartment = executingDepartment;
        return this;
    }

    public void setExecutingDepartment(String executingDepartment) {
        this.executingDepartment = executingDepartment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public IDBTrackDetails companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IDBTrackDetails)) {
            return false;
        }
        return id != null && id.equals(((IDBTrackDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IDBTrackDetails{" +
            "id=" + getId() +
            ", companyCode='" + getCompanyCode() + "'" +
            ", assignmentId=" + getAssignmentId() +
            ", trackId=" + getTrackId() +
            ", numberOfDays=" + getNumberOfDays() +
            ", employeeId='" + getEmployeeId() + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            ", levelId=" + getLevelId() +
            ", listed='" + getListed() + "'" +
            ", withdrawalOption='" + getWithdrawalOption() + "'" +
            ", assigneLtRating='" + getAssigneLtRating() + "'" +
            ", assigneStRating='" + getAssigneStRating() + "'" +
            ", assignedOutlook='" + getAssignedOutlook() + "'" +
            ", assignedOtherRating='" + getAssignedOtherRating() + "'" +
            ", totalNumberofDays=" + getTotalNumberofDays() +
            ", companyClassification='" + getCompanyClassification() + "'" +
            ", reason='" + getReason() + "'" +
            ", comments='" + getComments() + "'" +
            ", targetDate='" + getTargetDate() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", executingDepartment='" + getExecutingDepartment() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            "}";
    }
}
