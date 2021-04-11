package com.union.salesmanagementcore.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.union.salesmanagementcore.entities.CommissionType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CommissionCreateDto")
public class CommissionCreateDto {

    @NotNull
    @ApiModelProperty(value = "${salesmanConfig.create.commissionType}")
    private CommissionType commissionType;

    @NotNull
    @ApiModelProperty(value = "${salesmanConfig.create.value}")
    private Double value;

    @NotBlank
    @ApiModelProperty(value = "identificador do período")
    private String quarterId;

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public CommissionCreateDto setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CommissionCreateDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getQuarterId() {
        return quarterId;
    }

    public CommissionCreateDto setQuarterId(String quarterId) {
        this.quarterId = quarterId;
        return this;
    }
}
