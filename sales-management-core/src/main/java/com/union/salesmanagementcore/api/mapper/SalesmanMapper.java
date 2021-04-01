package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.SalesmanCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanUpdateDto;
import com.union.salesmanagementcore.entities.Salesman;

public class SalesmanMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Salesman toEntity(SalesmanCreateDto salesmanCreateDto) {
        return modelMapper.map(salesmanCreateDto, Salesman.class);
    }

    public static Salesman toEntity(SalesmanUpdateDto salesmanUpdateDto) {
        return modelMapper.map(salesmanUpdateDto, Salesman.class);
    }


    public static SalesmanResponseDto toResponseDto(Salesman salesman) {
        return modelMapper.map(salesman, SalesmanResponseDto.class);
    }
}
