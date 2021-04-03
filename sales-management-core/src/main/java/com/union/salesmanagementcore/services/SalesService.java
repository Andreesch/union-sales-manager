package com.union.salesmanagementcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesCreateDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.api.mapper.SalesMapper;
import com.union.salesmanagementcore.entities.Sales;
import com.union.salesmanagementcore.entities.Salesman;
import com.union.salesmanagementcore.repository.SalesRepository;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesmanService salesmanService;

    public SalesResponseDto create(SalesCreateDto salesCreateDto) {
        Salesman relatedSalesman = salesmanService.findById(salesCreateDto.getSalesmanId());

        Sales newSale = SalesMapper.toEntity(salesCreateDto)
                .setSalesman(relatedSalesman);

        return SalesMapper.toResponseDto(salesRepository
                .save(newSale));
    }
}
