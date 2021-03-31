package com.union.salesmanagementcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesmanCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.api.mapper.SalesmanMapper;
import com.union.salesmanagementcore.entities.Salesman;
import com.union.salesmanagementcore.entities.SalesmanConfig;
import com.union.salesmanagementcore.repository.SalesmanRepository;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private SalesmanConfigService salesmanConfigService;

    public SalesmanResponseDto create(SalesmanCreateDto salesmanCreateDto) {
        SalesmanConfig salesmanConfig = salesmanConfigService.findById(salesmanCreateDto.getSalesmanConfigId());

        Salesman salesman = SalesmanMapper.toEntity(salesmanCreateDto)
                .setSalesmanConfig(salesmanConfig);

        return SalesmanMapper.toResponseDto(salesman);
    }
}
