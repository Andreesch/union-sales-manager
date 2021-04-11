package com.union.salesmanagementcore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanCurrentStatusReportDto;
import com.union.salesmanagementcore.entities.Quota;
import com.union.salesmanagementcore.entities.Sales;
import com.union.salesmanagementcore.helper.CommissionHelper;

@Service
public class ReportService {

    @Autowired
    private QuotaService quotaService;

    @Autowired
    private SalesmanService salesmanService;

    @Autowired
    private SalesService salesService;

    public SalesmanCurrentStatusReportDto salesmanCurrentStatus(String salesmanId, String quarterId) {
        Quota currentQuota = quotaService.findBySalesmanIdAndQuarterId(salesmanId, quarterId);

        Double totalSalesValue = currentQuota.getSales().stream()
                .mapToDouble(Sales::getValue)
                .sum();

        boolean hasAchievedGoal = totalSalesValue >= currentQuota.getValue();

        return new SalesmanCurrentStatusReportDto()
                .setName(currentQuota.getSalesman().getName())
                .setRegion(currentQuota.getSalesman().getRegion())
                .setCommissionType(currentQuota.getSalesman().getCommission().getCommissionType())
                .setCommissionValue(currentQuota.getSalesman().getCommission().getValue())
                .setCommissionPayed(CommissionHelper.calculateCommissionToReceive(totalSalesValue,
                        currentQuota.getSalesman().getCommission().getValue(),
                        currentQuota.getSalesman().getCommission().getCommissionType(),
                        hasAchievedGoal))
                .setHasAchievedGoal(hasAchievedGoal)
                .setTotalSalesValue(totalSalesValue)
                .setQuota(currentQuota.getValue());


    }

    public List<SalesResponseDto> listSales() {
        return salesService.listAll();
    }
}
