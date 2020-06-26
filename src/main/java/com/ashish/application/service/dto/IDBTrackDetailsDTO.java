package com.ashish.application.service.dto;

import java.time.Instant;
import java.io.Serializable;

/**
 * A DTO for the {@link com.ashish.application.domain.IDBTrackDetails} entity.
 */
public class IDBTrackDetailsDTO implements Serializable {
    
    private Long id;

    private String companyCode;

    private Integer assignmentId;

    private Integer trackId;

    private Integer numberOfDays;

    private String employeeId;

    private String employeeName;

    private Integer levelId;

    private String listed;

    private String withdrawalOption;

    private String assigneLtRating;

    private String assigneStRating;

    private String assignedOutlook;

    private String assignedOtherRating;

    private Integer totalNumberofDays;

    private String companyClassification;

    private String reason;

    private String comments;

    private Instant targetDate;

    private Instant createdOn;

    private String executingDepartment;

    private String companyName;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getListed() {
        return listed;
    }

    public void setListed(String listed) {
        this.listed = listed;
    }

    public String getWithdrawalOption() {
        return withdrawalOption;
    }

    public void setWithdrawalOption(String withdrawalOption) {
        this.withdrawalOption = withdrawalOption;
    }

    public String getAssigneLtRating() {
        return assigneLtRating;
    }

    public void setAssigneLtRating(String assigneLtRating) {
        this.assigneLtRating = assigneLtRating;
    }

    public String getAssigneStRating() {
        return assigneStRating;
    }

    public void setAssigneStRating(String assigneStRating) {
        this.assigneStRating = assigneStRating;
    }

    public String getAssignedOutlook() {
        return assignedOutlook;
    }

    public void setAssignedOutlook(String assignedOutlook) {
        this.assignedOutlook = assignedOutlook;
    }

    public String getAssignedOtherRating() {
        return assignedOtherRating;
    }

    public void setAssignedOtherRating(String assignedOtherRating) {
        this.assignedOtherRating = assignedOtherRating;
    }

    public Integer getTotalNumberofDays() {
        return totalNumberofDays;
    }

    public void setTotalNumberofDays(Integer totalNumberofDays) {
        this.totalNumberofDays = totalNumberofDays;
    }

    public String getCompanyClassification() {
        return companyClassification;
    }

    public void setCompanyClassification(String companyClassification) {
        this.companyClassification = companyClassification;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Instant getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Instant targetDate) {
        this.targetDate = targetDate;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public String getExecutingDepartment() {
        return executingDepartment;
    }

    public void setExecutingDepartment(String executingDepartment) {
        this.executingDepartment = executingDepartment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IDBTrackDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((IDBTrackDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IDBTrackDetailsDTO{" +
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
