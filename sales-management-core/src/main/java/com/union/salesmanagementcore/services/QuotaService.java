package com.union.salesmanagementcore.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.QuarterCreateDto;
import com.union.salesmanagementcore.api.dto.QuarterResponseDto;
import com.union.salesmanagementcore.api.dto.QuotaCreateDto;
import com.union.salesmanagementcore.api.dto.QuotaResponseDto;
import com.union.salesmanagementcore.api.mapper.QuarterMapper;
import com.union.salesmanagementcore.api.mapper.QuotaMapper;
import com.union.salesmanagementcore.entities.Quarter;
import com.union.salesmanagementcore.entities.Quota;
import com.union.salesmanagementcore.entities.Sales;
import com.union.salesmanagementcore.repository.QuarterRepository;
import com.union.salesmanagementcore.repository.QuotaRepository;
import com.union.salesmanagementcore.repository.QuotaSearchRepository;

@Service
public class QuotaService {

    @Autowired
    private QuotaRepository quotaRepository;

    @Autowired
    private QuotaSearchRepository quotaSearchRepository;

    @Autowired
    private SalesmanService salesmanService;

    @Autowired
    private QuarterRepository quarterRepository;

    public QuotaResponseDto create(QuotaCreateDto quotaCreateDto) {
        Quota newQuota = buildQuota(quotaCreateDto.getValue(), quotaCreateDto.getSalesmanId(), quotaCreateDto.getQuarterId());

        return QuotaMapper.toResponseDto(quotaRepository.save(newQuota));
    }

    public QuarterResponseDto createQuarter(QuarterCreateDto quarterCreateDto) {
        Quarter quarter = new Quarter()
                .setInitQuarterReference(quarterCreateDto.getInitQuarterReference())
                .setEndQuarterReference(quarterCreateDto.getEndQuarterReference())
                .setCreatedAt(LocalDate.now());

        return QuarterMapper.toResponseDto(quarterRepository.save(quarter));
    }

    public Quota findBySaleDate(String salesmanId, LocalDate saleDate) {
        return quotaSearchRepository.findBySalesmanIdAndReferenceDate(salesmanId, saleDate)
                .orElseThrow();
    }

    public Quota findBySalesmanIdAndQuarterId(String salesmanId, String quarterId) {
        return quotaSearchRepository.findBySalesmanIdAndQuarterId(salesmanId, quarterId)
                .orElseThrow();
    }

    private Quota buildQuota(Double value, String salesmanId, String quarterId) {
        Quarter relatedQuarter = quarterRepository.findById(quarterId)
                .orElseThrow();

        return new Quota()
                .setCreatedAt(LocalDateTime.now())
                .setValue(value)
                .setQuarter(relatedQuarter)
                .setSalesman(salesmanService.findById(salesmanId));
    }
}
