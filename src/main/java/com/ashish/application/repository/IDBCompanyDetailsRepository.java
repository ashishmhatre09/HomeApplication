package com.ashish.application.repository;

import com.ashish.application.domain.IDBCompanyDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IDBCompanyDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IDBCompanyDetailsRepository extends JpaRepository<IDBCompanyDetails, Long> {
}
