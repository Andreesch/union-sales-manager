package com.union.salesmanagementcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesmanCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanUpdateDto;
import com.union.salesmanagementcore.api.mapper.SalesmanMapper;
import com.union.salesmanagementcore.entities.Commission;
import com.union.salesmanagementcore.entities.Salesman;
import com.union.salesmanagementcore.repository.SalesmanRepository;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private CommissionService salesmanConfigService;

    public SalesmanResponseDto create(SalesmanCreateDto salesmanCreateDto) {
        Commission commission = salesmanConfigService.findById(salesmanCreateDto.getCommissionId());

        Salesman salesman = SalesmanMapper.toEntity(salesmanCreateDto)
                .setCommission(commission);

        return SalesmanMapper.toResponseDto(salesmanRepository.save(salesman));
    }

    public SalesmanResponseDto update(SalesmanUpdateDto salesmanUpdateDto) {
        findById(salesmanUpdateDto.getSalesmanId());

        Commission commission = salesmanConfigService.findById(salesmanUpdateDto.getSalesmanConfigId());

        Salesman updatedSalesman = SalesmanMapper.toEntity(salesmanUpdateDto)
                .setCommission(commission);

        return SalesmanMapper.toResponseDto(salesmanRepository.save(updatedSalesman));

    }

    public Salesman findById(String id) {
        return salesmanRepository.findById(id)
                .orElseThrow();
    }
}
