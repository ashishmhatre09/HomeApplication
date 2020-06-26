package com.ashish.application.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IDBTrackDetailsMapperTest {

    private IDBTrackDetailsMapper iDBTrackDetailsMapper;

    @BeforeEach
    public void setUp() {
        iDBTrackDetailsMapper = new IDBTrackDetailsMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(iDBTrackDetailsMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(iDBTrackDetailsMapper.fromId(null)).isNull();
    }
}
