package com.union.salesmanagementcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesmanCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanUpdateDto;
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

        return SalesmanMapper.toResponseDto(salesmanRepository.save(salesman));
    }

    public SalesmanResponseDto update(SalesmanUpdateDto salesmanUpdateDto) {
        findById(salesmanUpdateDto.getSalesmanId());

        SalesmanConfig salesmanConfig = salesmanConfigService.findById(salesmanUpdateDto.getSalesmanConfigId());

        Salesman updatedSalesman = SalesmanMapper.toEntity(salesmanUpdateDto)
                .setSalesmanConfig(salesmanConfig);

        return SalesmanMapper.toResponseDto(salesmanRepository.save(updatedSalesman));

    }

    public Salesman findById(String id) {
        return salesmanRepository.findById(id)
                .orElseThrow();
    }
}
