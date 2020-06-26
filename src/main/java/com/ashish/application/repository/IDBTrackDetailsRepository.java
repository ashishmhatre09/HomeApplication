package com.ashish.application.repository;

import com.ashish.application.domain.IDBTrackDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IDBTrackDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IDBTrackDetailsRepository extends JpaRepository<IDBTrackDetails, Long> {
}
