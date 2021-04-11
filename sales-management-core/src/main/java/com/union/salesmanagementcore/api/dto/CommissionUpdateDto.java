package com.union.salesmanagementcore.api.dto;

import com.union.salesmanagementcore.entities.CommissionType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesmanConfigUpdate")
public class CommissionUpdateDto {

    @ApiModelProperty(value = "${salesmanConfig.update.id}")
    private String id;

    @ApiModelProperty(value = "${salesmanConfig.update.commissionType}")
    private CommissionType commissionType;

    @ApiModelProperty(value = "${salesmanConfig.update.value}")
    private Double value;

    public String getId() {
        return id;
    }

    public CommissionUpdateDto setId(String id) {
        this.id = id;
        return this;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public CommissionUpdateDto setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CommissionUpdateDto setValue(Double value) {
        this.value = value;
        return this;
    }
}
