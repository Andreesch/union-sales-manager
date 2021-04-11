package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.CommissionCreateDto;
import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.entities.Commission;

public class CommissionMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Commission toEntity(CommissionCreateDto commissionCreateDto) {
        return modelMapper.map(commissionCreateDto, Commission.class);
    }

    public static ComissionResponseDto toResponseDto(Commission commission) {
        return modelMapper.map(commission, ComissionResponseDto.class);
    }

}
