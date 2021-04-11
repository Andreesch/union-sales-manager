package com.union.salesmanagementcore.api.mapper;

import org.modelmapper.ModelMapper;

import com.union.salesmanagementcore.api.dto.PaymentResponseDto;
import com.union.salesmanagementcore.entities.Payment;

public class PaymentMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static PaymentResponseDto toResponseDto(Payment payment) {
        return modelMapper.map(payment, PaymentResponseDto.class)
                .setRelatedSalesman(SalesmanMapper.toResponseDto(payment.getSalesman()))
                .setInitQuarterReference(payment.getQuota().getQuarter().getInitQuarterReference())
                .setEndQuarterReference(payment.getQuota().getQuarter().getEndQuarterReference());
    }
}
