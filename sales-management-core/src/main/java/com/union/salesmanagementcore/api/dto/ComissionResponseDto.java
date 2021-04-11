package com.union.salesmanagementcore.api.dto;

import com.union.salesmanagementcore.entities.CommissionType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesmanConfigResponse")
public class ComissionResponseDto {

    @ApiModelProperty(value = "${salesmanConfig.response.id}")
    private String id;

    @ApiModelProperty(value = "${salesmanConfig.response.commissionType}")
    private CommissionType commissionType;

    @ApiModelProperty(value = "${salesmanConfig.response.value}")
    private Double value;

    public String getId() {
        return id;
    }

    public ComissionResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public ComissionResponseDto setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ComissionResponseDto setValue(Double value) {
        this.value = value;
        return this;
    }
}
