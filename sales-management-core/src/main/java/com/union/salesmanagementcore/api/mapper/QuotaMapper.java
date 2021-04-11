package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.QuotaResponseDto;
import com.union.salesmanagementcore.entities.Quota;

public class QuotaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static QuotaResponseDto toResponseDto(Quota quota) {
        return modelMapper.map(quota, QuotaResponseDto.class)
                .setId(quota.getSalesman().getId())
                .setInitialQuarterReference(quota.getQuarter().getInitQuarterReference())
                .setEndQuarterReference(quota.getQuarter().getEndQuarterReference());
    }
}
