package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.SalesmanConfigCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.entities.SalesmanConfig;

public class SalesmanConfigMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static SalesmanConfig toEntity(SalesmanConfigCreateDto salesmanConfigCreateDto) {
        return modelMapper.map(salesmanConfigCreateDto, SalesmanConfig.class);
    }

    public static SalesmanConfigResponseDto toResponseDto(SalesmanConfig salesmanConfig) {
        return modelMapper.map(salesmanConfig, SalesmanConfigResponseDto.class);
    }

}
