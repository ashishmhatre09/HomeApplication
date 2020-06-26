package com.ashish.application.service.dto;

import java.time.Instant;
import java.io.Serializable;

/**
 * A DTO for the {@link com.ashish.application.domain.IDBCompanyDetails} entity.
 */
public class IDBCompanyDetailsDTO implements Serializable {
    
    private Long id;

    private String companyCode;

    private String companyName;

    private String meetingNumber;

    private Instant meetingDate;

    private Instant prDate;

    private Instant crrDate;

    private String osLtRating;

    private String osStRating;

    private String osOutlook;

    private String osOtherRating;

    private String assignedLtRating;

    private String assignedStRating;

    private String assignedOutlook;

    private String assignedOtherRating;

    private String companyClassification;

    private String osLtRtgCategory;

    private String osStRtgCategory;

    private String executingDepartment;

    private Instant createdOn;

    
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public Instant getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Instant meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Instant getPrDate() {
        return prDate;
    }

    public void setPrDate(Instant prDate) {
        this.prDate = prDate;
    }

    public Instant getCrrDate() {
        return crrDate;
    }

    public void setCrrDate(Instant crrDate) {
        this.crrDate = crrDate;
    }

    public String getOsLtRating() {
        return osLtRating;
    }

    public void setOsLtRating(String osLtRating) {
        this.osLtRating = osLtRating;
    }

    public String getOsStRating() {
        return osStRating;
    }

    public void setOsStRating(String osStRating) {
        this.osStRating = osStRating;
    }

    public String getOsOutlook() {
        return osOutlook;
    }

    public void setOsOutlook(String osOutlook) {
        this.osOutlook = osOutlook;
    }

    public String getOsOtherRating() {
        return osOtherRating;
    }

    public void setOsOtherRating(String osOtherRating) {
        this.osOtherRating = osOtherRating;
    }

    public String getAssignedLtRating() {
        return assignedLtRating;
    }

    public void setAssignedLtRating(String assignedLtRating) {
        this.assignedLtRating = assignedLtRating;
    }

    public String getAssignedStRating() {
        return assignedStRating;
    }

    public void setAssignedStRating(String assignedStRating) {
        this.assignedStRating = assignedStRating;
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

    public String getCompanyClassification() {
        return companyClassification;
    }

    public void setCompanyClassification(String companyClassification) {
        this.companyClassification = companyClassification;
    }

    public String getOsLtRtgCategory() {
        return osLtRtgCategory;
    }

    public void setOsLtRtgCategory(String osLtRtgCategory) {
        this.osLtRtgCategory = osLtRtgCategory;
    }

    public String getOsStRtgCategory() {
        return osStRtgCategory;
    }

    public void setOsStRtgCategory(String osStRtgCategory) {
        this.osStRtgCategory = osStRtgCategory;
    }

    public String getExecutingDepartment() {
        return executingDepartment;
    }

    public void setExecutingDepartment(String executingDepartment) {
        this.executingDepartment = executingDepartment;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IDBCompanyDetailsDTO)) {
            return false;
        }

        return id != null && id.equals(((IDBCompanyDetailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IDBCompanyDetailsDTO{" +
            "id=" + getId() +
            ", companyCode='" + getCompanyCode() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", meetingNumber='" + getMeetingNumber() + "'" +
            ", meetingDate='" + getMeetingDate() + "'" +
            ", prDate='" + getPrDate() + "'" +
            ", crrDate='" + getCrrDate() + "'" +
            ", osLtRating='" + getOsLtRating() + "'" +
            ", osStRating='" + getOsStRating() + "'" +
            ", osOutlook='" + getOsOutlook() + "'" +
            ", osOtherRating='" + getOsOtherRating() + "'" +
            ", assignedLtRating='" + getAssignedLtRating() + "'" +
            ", assignedStRating='" + getAssignedStRating() + "'" +
            ", assignedOutlook='" + getAssignedOutlook() + "'" +
            ", assignedOtherRating='" + getAssignedOtherRating() + "'" +
            ", companyClassification='" + getCompanyClassification() + "'" +
            ", osLtRtgCategory='" + getOsLtRtgCategory() + "'" +
            ", osStRtgCategory='" + getOsStRtgCategory() + "'" +
            ", executingDepartment='" + getExecutingDepartment() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            "}";
    }
}
