package com.union.salesmanagementcore.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;

public class QuotaResponseDto {

    @ApiModelProperty(value = "Identificador")
    private String id;

    @ApiModelProperty(value = "Data de criação")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "Início do período de vigência")
    private LocalDate initialQuarterReference;

    @ApiModelProperty(value = "Fim do período de vigência")
    private LocalDate endQuarterReference;

    @ApiModelProperty(value = "Identificador do vendedor")
    private String salesmanId;

    public String getId() {
        return id;
    }

    public QuotaResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public QuotaResponseDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getInitialQuarterReference() {
        return initialQuarterReference;
    }

    public QuotaResponseDto setInitialQuarterReference(LocalDate initialQuarterReference) {
        this.initialQuarterReference = initialQuarterReference;
        return this;
    }

    public LocalDate getEndQuarterReference() {
        return endQuarterReference;
    }

    public QuotaResponseDto setEndQuarterReference(LocalDate endQuarterReference) {
        this.endQuarterReference = endQuarterReference;
        return this;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public QuotaResponseDto setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
        return this;
    }
}
