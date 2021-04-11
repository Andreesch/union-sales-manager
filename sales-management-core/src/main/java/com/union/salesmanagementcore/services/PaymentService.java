package com.union.salesmanagementcore.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.PaymentResponseDto;
import com.union.salesmanagementcore.api.mapper.PaymentMapper;
import com.union.salesmanagementcore.entities.Payment;
import com.union.salesmanagementcore.repository.PaymentRepository;
import com.union.salesmanagementcore.repository.SalesmanRepository;
import com.union.salesmanagementcore.services.vo.PaymentCreateVO;
import com.union.salesmanagementcore.strategy.PaymentStrategy;

@Service
public class PaymentService implements PaymentStrategy {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SalesmanRepository salesmanRepository;

    public void pay(PaymentCreateVO paymentCreateVO) {
        Payment payment = createEntity(paymentCreateVO);

        paymentRepository.save(payment);
    }

    public Optional<Payment> findBySalesmanIdAndReferenceDate(String salesmanId, LocalDate referenceDate) {
        return paymentRepository.findBySalesmanIdAndReferenceDate(salesmanId, referenceDate);
    }

    public List<PaymentResponseDto> findAllByQuarter(String quarterId) {
        return paymentRepository.findAllByQuarterDate(quarterId)
                .stream()
                .map(PaymentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    private Payment createEntity(PaymentCreateVO paymentCreateVO) {
        return new Payment()
                .setCreatedAt(LocalDate.now())
                .setTotalValue(paymentCreateVO.getTotalValue())
                .setSalesman(paymentCreateVO.getSalesman())
                .setQuota(paymentCreateVO.getQuota());
    }
}
