package com.union.salesmanagementcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.api.dto.CommissionCreateDto;
import com.union.salesmanagementcore.api.dto.CommissionUpdateDto;
import com.union.salesmanagementcore.api.mapper.CommissionMapper;
import com.union.salesmanagementcore.entities.Commission;
import com.union.salesmanagementcore.repository.CommissionRepository;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    public ComissionResponseDto create(CommissionCreateDto commissionCreateDto) {
        return CommissionMapper.toResponseDto(commissionRepository
                .save(CommissionMapper.toEntity(commissionCreateDto)));
    }

    public ComissionResponseDto update(CommissionUpdateDto commissionUpdateDto) {
        Commission commission = findById(commissionUpdateDto.getId());
        commission.setCommissionType(commissionUpdateDto.getCommissionType());
        commission.setValue(commissionUpdateDto.getValue());

        return CommissionMapper.toResponseDto(commissionRepository.save(commission));
    }

    public Commission findById(String configId) {
        return commissionRepository.findById(configId)
                .orElseThrow();
    }

    public ComissionResponseDto find(String configId) {
        return CommissionMapper.toResponseDto(findById(configId));
    }

}
