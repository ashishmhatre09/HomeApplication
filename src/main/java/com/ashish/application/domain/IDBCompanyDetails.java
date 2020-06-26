package com.ashish.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A IDBCompanyDetails.
 */
@Entity
@Table(name = "idb_company_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class IDBCompanyDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "meeting_number")
    private String meetingNumber;

    @Column(name = "meeting_date")
    private Instant meetingDate;

    @Column(name = "pr_date")
    private Instant prDate;

    @Column(name = "crr_date")
    private Instant crrDate;

    @Column(name = "os_lt_rating")
    private String osLtRating;

    @Column(name = "os_st_rating")
    private String osStRating;

    @Column(name = "os_outlook")
    private String osOutlook;

    @Column(name = "os_other_rating")
    private String osOtherRating;

    @Column(name = "assigned_lt_rating")
    private String assignedLtRating;

    @Column(name = "assigned_st_rating")
    private String assignedStRating;

    @Column(name = "assigned_outlook")
    private String assignedOutlook;

    @Column(name = "assigned_other_rating")
    private String assignedOtherRating;

    @Column(name = "company_classification")
    private String companyClassification;

    @Column(name = "os_lt_rtg_category")
    private String osLtRtgCategory;

    @Column(name = "os_st_rtg_category")
    private String osStRtgCategory;

    @Column(name = "executing_department")
    private String executingDepartment;

    @Column(name = "created_on")
    private Instant createdOn;

    @OneToMany(mappedBy = "companyCode")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<IDBTrackDetails> companyCodes = new HashSet<>();

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

    public IDBCompanyDetails companyCode(String companyCode) {
        this.companyCode = companyCode;
        return this;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public IDBCompanyDetails companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public IDBCompanyDetails meetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
        return this;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public Instant getMeetingDate() {
        return meetingDate;
    }

    public IDBCompanyDetails meetingDate(Instant meetingDate) {
        this.meetingDate = meetingDate;
        return this;
    }

    public void setMeetingDate(Instant meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Instant getPrDate() {
        return prDate;
    }

    public IDBCompanyDetails prDate(Instant prDate) {
        this.prDate = prDate;
        return this;
    }

    public void setPrDate(Instant prDate) {
        this.prDate = prDate;
    }

    public Instant getCrrDate() {
        return crrDate;
    }

    public IDBCompanyDetails crrDate(Instant crrDate) {
        this.crrDate = crrDate;
        return this;
    }

    public void setCrrDate(Instant crrDate) {
        this.crrDate = crrDate;
    }

    public String getOsLtRating() {
        return osLtRating;
    }

    public IDBCompanyDetails osLtRating(String osLtRating) {
        this.osLtRating = osLtRating;
        return this;
    }

    public void setOsLtRating(String osLtRating) {
        this.osLtRating = osLtRating;
    }

    public String getOsStRating() {
        return osStRating;
    }

    public IDBCompanyDetails osStRating(String osStRating) {
        this.osStRating = osStRating;
        return this;
    }

    public void setOsStRating(String osStRating) {
        this.osStRating = osStRating;
    }

    public String getOsOutlook() {
        return osOutlook;
    }

    public IDBCompanyDetails osOutlook(String osOutlook) {
        this.osOutlook = osOutlook;
        return this;
    }

    public void setOsOutlook(String osOutlook) {
        this.osOutlook = osOutlook;
    }

    public String getOsOtherRating() {
        return osOtherRating;
    }

    public IDBCompanyDetails osOtherRating(String osOtherRating) {
        this.osOtherRating = osOtherRating;
        return this;
    }

    public void setOsOtherRating(String osOtherRating) {
        this.osOtherRating = osOtherRating;
    }

    public String getAssignedLtRating() {
        return assignedLtRating;
    }

    public IDBCompanyDetails assignedLtRating(String assignedLtRating) {
        this.assignedLtRating = assignedLtRating;
        return this;
    }

    public void setAssignedLtRating(String assignedLtRating) {
        this.assignedLtRating = assignedLtRating;
    }

    public String getAssignedStRating() {
        return assignedStRating;
    }

    public IDBCompanyDetails assignedStRating(String assignedStRating) {
        this.assignedStRating = assignedStRating;
        return this;
    }

    public void setAssignedStRating(String assignedStRating) {
        this.assignedStRating = assignedStRating;
    }

    public String getAssignedOutlook() {
        return assignedOutlook;
    }

    public IDBCompanyDetails assignedOutlook(String assignedOutlook) {
        this.assignedOutlook = assignedOutlook;
        return this;
    }

    public void setAssignedOutlook(String assignedOutlook) {
        this.assignedOutlook = assignedOutlook;
    }

    public String getAssignedOtherRating() {
        return assignedOtherRating;
    }

    public IDBCompanyDetails assignedOtherRating(String assignedOtherRating) {
        this.assignedOtherRating = assignedOtherRating;
        return this;
    }

    public void setAssignedOtherRating(String assignedOtherRating) {
        this.assignedOtherRating = assignedOtherRating;
    }

    public String getCompanyClassification() {
        return companyClassification;
    }

    public IDBCompanyDetails companyClassification(String companyClassification) {
        this.companyClassification = companyClassification;
        return this;
    }

    public void setCompanyClassification(String companyClassification) {
        this.companyClassification = companyClassification;
    }

    public String getOsLtRtgCategory() {
        return osLtRtgCategory;
    }

    public IDBCompanyDetails osLtRtgCategory(String osLtRtgCategory) {
        this.osLtRtgCategory = osLtRtgCategory;
        return this;
    }

    public void setOsLtRtgCategory(String osLtRtgCategory) {
        this.osLtRtgCategory = osLtRtgCategory;
    }

    public String getOsStRtgCategory() {
        return osStRtgCategory;
    }

    public IDBCompanyDetails osStRtgCategory(String osStRtgCategory) {
        this.osStRtgCategory = osStRtgCategory;
        return this;
    }

    public void setOsStRtgCategory(String osStRtgCategory) {
        this.osStRtgCategory = osStRtgCategory;
    }

    public String getExecutingDepartment() {
        return executingDepartment;
    }

    public IDBCompanyDetails executingDepartment(String executingDepartment) {
        this.executingDepartment = executingDepartment;
        return this;
    }

    public void setExecutingDepartment(String executingDepartment) {
        this.executingDepartment = executingDepartment;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public IDBCompanyDetails createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Set<IDBTrackDetails> getCompanyCodes() {
        return companyCodes;
    }

    public IDBCompanyDetails companyCodes(Set<IDBTrackDetails> iDBTrackDetails) {
        this.companyCodes = iDBTrackDetails;
        return this;
    }

    public IDBCompanyDetails addCompanyCode(IDBTrackDetails iDBTrackDetails) {
        this.companyCodes.add(iDBTrackDetails);
        iDBTrackDetails.setCompanyCode(this);
        return this;
    }

    public IDBCompanyDetails removeCompanyCode(IDBTrackDetails iDBTrackDetails) {
        this.companyCodes.remove(iDBTrackDetails);
        iDBTrackDetails.setCompanyCode(null);
        return this;
    }

    public void setCompanyCodes(Set<IDBTrackDetails> iDBTrackDetails) {
        this.companyCodes = iDBTrackDetails;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IDBCompanyDetails)) {
            return false;
        }
        return id != null && id.equals(((IDBCompanyDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IDBCompanyDetails{" +
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
