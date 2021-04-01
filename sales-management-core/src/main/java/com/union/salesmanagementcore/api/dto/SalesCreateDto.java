package com.union.salesmanagementcore.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesCreate")
public class SalesCreateDto {

    @NotBlank
    @ApiModelProperty(value = "${sales.create.description}")
    private String description;

    @NotNull
    @ApiModelProperty(value = "${sales.create.value}")
    private Double value;

    @NotBlank
    @ApiModelProperty(value = "${sales.create.createdAt}")
    private LocalDateTime createdAt;

    @NotBlank
    @ApiModelProperty(value = "${sales.create.salesmanId}")
    private String salesmanId;

    public String getDescription() {
        return description;
    }

    public SalesCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public SalesCreateDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public SalesCreateDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public SalesCreateDto setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
        return this;
    }
}
