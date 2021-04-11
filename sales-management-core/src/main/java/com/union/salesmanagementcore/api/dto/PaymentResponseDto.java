package com.union.salesmanagementcore.api.dto;

import java.time.LocalDate;

public class PaymentResponseDto {

    private String id;

    private LocalDate createdAt;

    private Double totalValue;

    private LocalDate initQuarterReference;

    private LocalDate endQuarterReference;

    private SalesmanResponseDto relatedSalesman;

    public String getId() {
        return id;
    }

    public PaymentResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public PaymentResponseDto setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public PaymentResponseDto setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public LocalDate getInitQuarterReference() {
        return initQuarterReference;
    }

    public PaymentResponseDto setInitQuarterReference(LocalDate initQuarterReference) {
        this.initQuarterReference = initQuarterReference;
        return this;
    }

    public LocalDate getEndQuarterReference() {
        return endQuarterReference;
    }

    public PaymentResponseDto setEndQuarterReference(LocalDate endQuarterReference) {
        this.endQuarterReference = endQuarterReference;
        return this;
    }

    public SalesmanResponseDto getRelatedSalesman() {
        return relatedSalesman;
    }

    public PaymentResponseDto setRelatedSalesman(SalesmanResponseDto relatedSalesman) {
        this.relatedSalesman = relatedSalesman;
        return this;
    }
}
