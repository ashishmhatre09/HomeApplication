package com.ashish.application.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IDBCompanyDetailsMapperTest {

    private IDBCompanyDetailsMapper iDBCompanyDetailsMapper;

    @BeforeEach
    public void setUp() {
        iDBCompanyDetailsMapper = new IDBCompanyDetailsMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(iDBCompanyDetailsMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(iDBCompanyDetailsMapper.fromId(null)).isNull();
    }
}
