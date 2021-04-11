package com.union.salesmanagementcore.api.dto;

import com.union.salesmanagementcore.entities.CommissionType;
import com.union.salesmanagementcore.entities.Region;

public class SalesmanCurrentStatusReportDto {

    private String name;

    private Region region;

    private CommissionType commissionType;

    private Double commissionValue;

    private Double totalSalesValue;

    private Double quota;

    private boolean hasAchievedGoal;

    private Double commissionPayed;

    public String getName() {
        return name;
    }

    public SalesmanCurrentStatusReportDto setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public SalesmanCurrentStatusReportDto setRegion(Region region) {
        this.region = region;
        return this;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public SalesmanCurrentStatusReportDto setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getCommissionValue() {
        return commissionValue;
    }

    public SalesmanCurrentStatusReportDto setCommissionValue(Double commissionValue) {
        this.commissionValue = commissionValue;
        return this;
    }

    public Double getTotalSalesValue() {
        return totalSalesValue;
    }

    public SalesmanCurrentStatusReportDto setTotalSalesValue(Double totalSalesValue) {
        this.totalSalesValue = totalSalesValue;
        return this;
    }

    public Double getQuota() {
        return quota;
    }

    public SalesmanCurrentStatusReportDto setQuota(Double quota) {
        this.quota = quota;
        return this;
    }

    public boolean isHasAchievedGoal() {
        return hasAchievedGoal;
    }

    public SalesmanCurrentStatusReportDto setHasAchievedGoal(boolean hasAchievedGoal) {
        this.hasAchievedGoal = hasAchievedGoal;
        return this;
    }

    public Double getCommissionPayed() {
        return commissionPayed;
    }

    public SalesmanCurrentStatusReportDto setCommissionPayed(Double commissionPayed) {
        this.commissionPayed = commissionPayed;
        return this;
    }
}
