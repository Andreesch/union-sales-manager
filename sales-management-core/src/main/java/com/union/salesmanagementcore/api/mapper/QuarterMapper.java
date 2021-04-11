package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.QuarterResponseDto;
import com.union.salesmanagementcore.entities.Quarter;

public class QuarterMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static QuarterResponseDto toResponseDto(Quarter quarter) {
        return modelMapper.map(quarter, QuarterResponseDto.class);
    }
}
