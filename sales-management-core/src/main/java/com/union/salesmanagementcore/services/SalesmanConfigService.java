package com.union.salesmanagementcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesmanConfigCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigUpdateDto;
import com.union.salesmanagementcore.api.mapper.SalesmanConfigMapper;
import com.union.salesmanagementcore.entities.SalesmanConfig;
import com.union.salesmanagementcore.repository.SalesmanConfigRepository;

@Service
public class SalesmanConfigService {

    @Autowired
    private SalesmanConfigRepository salesmanConfigRepository;

    public SalesmanConfigResponseDto create(SalesmanConfigCreateDto salesmanConfigCreateDto) {
        return SalesmanConfigMapper.toResponseDto(salesmanConfigRepository
                .save(SalesmanConfigMapper.toEntity(salesmanConfigCreateDto)));
    }

    public SalesmanConfigResponseDto update(SalesmanConfigUpdateDto salesmanConfigUpdateDto) {
        SalesmanConfig salesmanConfig = findById(salesmanConfigUpdateDto.getId());
        salesmanConfig.setCommissionType(salesmanConfigUpdateDto.getCommissionType());
        salesmanConfig.setValue(salesmanConfigUpdateDto.getValue());

        return SalesmanConfigMapper.toResponseDto(salesmanConfigRepository.save(salesmanConfig));
    }

    public SalesmanConfig findById(String configId) {
        return salesmanConfigRepository.findById(configId)
                .orElseThrow();
    }

    public SalesmanConfigResponseDto find(String configId) {
        return SalesmanConfigMapper.toResponseDto(findById(configId));
    }

}
