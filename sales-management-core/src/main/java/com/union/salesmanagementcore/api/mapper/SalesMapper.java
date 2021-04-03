package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.SalesCreateDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.entities.Sales;

public class SalesMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Sales toEntity(SalesCreateDto salesCreateDto) {
        return modelMapper.map(salesCreateDto, Sales.class);
    }

    public static SalesResponseDto toResponseDto(Sales sales) {
        return modelMapper.map(sales, SalesResponseDto.class);
    }
}
