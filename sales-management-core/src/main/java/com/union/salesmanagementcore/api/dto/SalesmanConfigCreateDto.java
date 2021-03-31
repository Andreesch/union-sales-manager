package com.union.salesmanagementcore.api.dto;

import javax.validation.constraints.NotNull;
import com.union.salesmanagementcore.entities.CommissionType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesmanConfigCreate")
public class SalesmanConfigCreateDto {

    @NotNull
    @ApiModelProperty(value = "${salesmanConfig.create.commissionType}")
    private CommissionType commissionType;

    @NotNull
    @ApiModelProperty(value = "${salesmanConfig.create.value}")
    private Double value;

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public SalesmanConfigCreateDto setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public SalesmanConfigCreateDto setValue(Double value) {
        this.value = value;
        return this;
    }
}
