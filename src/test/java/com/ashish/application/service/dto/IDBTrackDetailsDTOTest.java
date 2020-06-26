package com.ashish.application.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ashish.application.web.rest.TestUtil;

public class IDBTrackDetailsDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(IDBTrackDetailsDTO.class);
        IDBTrackDetailsDTO iDBTrackDetailsDTO1 = new IDBTrackDetailsDTO();
        iDBTrackDetailsDTO1.setId(1L);
        IDBTrackDetailsDTO iDBTrackDetailsDTO2 = new IDBTrackDetailsDTO();
        assertThat(iDBTrackDetailsDTO1).isNotEqualTo(iDBTrackDetailsDTO2);
        iDBTrackDetailsDTO2.setId(iDBTrackDetailsDTO1.getId());
        assertThat(iDBTrackDetailsDTO1).isEqualTo(iDBTrackDetailsDTO2);
        iDBTrackDetailsDTO2.setId(2L);
        assertThat(iDBTrackDetailsDTO1).isNotEqualTo(iDBTrackDetailsDTO2);
        iDBTrackDetailsDTO1.setId(null);
        assertThat(iDBTrackDetailsDTO1).isNotEqualTo(iDBTrackDetailsDTO2);
    }
}
