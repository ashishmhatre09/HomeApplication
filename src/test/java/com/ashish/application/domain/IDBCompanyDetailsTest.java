package com.ashish.application.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ashish.application.web.rest.TestUtil;

public class IDBCompanyDetailsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IDBCompanyDetails.class);
        IDBCompanyDetails iDBCompanyDetails1 = new IDBCompanyDetails();
        iDBCompanyDetails1.setId(1L);
        IDBCompanyDetails iDBCompanyDetails2 = new IDBCompanyDetails();
        iDBCompanyDetails2.setId(iDBCompanyDetails1.getId());
        assertThat(iDBCompanyDetails1).isEqualTo(iDBCompanyDetails2);
        iDBCompanyDetails2.setId(2L);
        assertThat(iDBCompanyDetails1).isNotEqualTo(iDBCompanyDetails2);
        iDBCompanyDetails1.setId(null);
        assertThat(iDBCompanyDetails1).isNotEqualTo(iDBCompanyDetails2);
    }
}
