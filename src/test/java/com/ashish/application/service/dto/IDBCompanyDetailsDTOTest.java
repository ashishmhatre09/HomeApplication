package com.ashish.application.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ashish.application.web.rest.TestUtil;

public class IDBCompanyDetailsDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IDBCompanyDetailsDTO.class);
        IDBCompanyDetailsDTO iDBCompanyDetailsDTO1 = new IDBCompanyDetailsDTO();
        iDBCompanyDetailsDTO1.setId(1L);
        IDBCompanyDetailsDTO iDBCompanyDetailsDTO2 = new IDBCompanyDetailsDTO();
        assertThat(iDBCompanyDetailsDTO1).isNotEqualTo(iDBCompanyDetailsDTO2);
        iDBCompanyDetailsDTO2.setId(iDBCompanyDetailsDTO1.getId());
        assertThat(iDBCompanyDetailsDTO1).isEqualTo(iDBCompanyDetailsDTO2);
        iDBCompanyDetailsDTO2.setId(2L);
        assertThat(iDBCompanyDetailsDTO1).isNotEqualTo(iDBCompanyDetailsDTO2);
        iDBCompanyDetailsDTO1.setId(null);
        assertThat(iDBCompanyDetailsDTO1).isNotEqualTo(iDBCompanyDetailsDTO2);
    }
}
