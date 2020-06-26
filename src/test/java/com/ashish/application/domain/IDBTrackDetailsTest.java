package com.ashish.application.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.ashish.application.web.rest.TestUtil;

public class IDBTrackDetailsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(IDBTrackDetails.class);
        IDBTrackDetails iDBTrackDetails1 = new IDBTrackDetails();
        iDBTrackDetails1.setId(1L);
        IDBTrackDetails iDBTrackDetails2 = new IDBTrackDetails();
        iDBTrackDetails2.setId(iDBTrackDetails1.getId());
        assertThat(iDBTrackDetails1).isEqualTo(iDBTrackDetails2);
        iDBTrackDetails2.setId(2L);
        assertThat(iDBTrackDetails1).isNotEqualTo(iDBTrackDetails2);
        iDBTrackDetails1.setId(null);
        assertThat(iDBTrackDetails1).isNotEqualTo(iDBTrackDetails2);
    }
}
