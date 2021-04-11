package com.union.salesmanagementcore.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesCreateDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.api.mapper.SalesMapper;
import com.union.salesmanagementcore.entities.Payment;
import com.union.salesmanagementcore.entities.Quota;
import com.union.salesmanagementcore.entities.Sales;
import com.union.salesmanagementcore.entities.Salesman;
import com.union.salesmanagementcore.helper.CommissionHelper;
import com.union.salesmanagementcore.repository.SalesRepository;
import com.union.salesmanagementcore.services.vo.PaymentCreateVO;
import com.union.salesmanagementcore.strategy.PaymentStrategy;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SalesmanService salesmanService;

    @Autowired
    private QuotaService quotaService;

    @Autowired
    private PaymentService paymentService;

    public SalesResponseDto create(SalesCreateDto salesCreateDto) {
        Salesman relatedSalesman = salesmanService.findById(salesCreateDto.getSalesmanId());

        Quota relatedQuota = quotaService.findBySaleDate(salesCreateDto.getSalesmanId(), salesCreateDto.getCreatedAt());

        Sales newSale = SalesMapper.toEntity(salesCreateDto)
                .setSalesman(relatedSalesman)
                .setQuota(relatedQuota)
                .setCreatedAt(LocalDateTime.now());

        Double totalSalesValue = relatedQuota.getSales().stream()
                .mapToDouble(Sales::getValue)
                .sum();

        totalSalesValue = totalSalesValue + newSale.getValue();

        boolean hasAchievedGoal = totalSalesValue >= relatedQuota.getValue();

        if (hasAchievedGoal) {
            //Verifica se já não foi pago
            Optional<Payment> quarterPayment = paymentService.findBySalesmanIdAndReferenceDate(relatedSalesman.getId(), LocalDate.now());

            if (quarterPayment.isEmpty()) {
                // Por hora vai utilizar apenas 1 método de pagamento
                PaymentStrategy paymentStrategy = paymentService;

                PaymentCreateVO paymentCreateVO = new PaymentCreateVO()
                        .setQuota(relatedQuota)
                        .setTotalValue(CommissionHelper.calculateCommissionToReceive(totalSalesValue,
                                relatedSalesman.getCommission().getValue(),
                                relatedSalesman.getCommission().getCommissionType(),
                                true))
                        .setSalesman(relatedSalesman);

                paymentStrategy.pay(paymentCreateVO);
            }
        }

        return SalesMapper.toResponseDto(salesRepository
                .save(newSale));
    }

    public List<SalesResponseDto> findAllSalesBySalesman(String salesmanId) {
        List<Sales> salesList = salesRepository.findAllBySalesmanId(salesmanId);

        return salesList.stream()
                .map(SalesMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<SalesResponseDto> listAll() {
        return salesRepository.findAll()
                .stream()
                .map(SalesMapper::toResponseDto)
                .collect(Collectors.toList());
    }
 }
