package com.union.salesmanagementcore.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class QuotaCreateDto {

    @ApiModelProperty(value = "Identificador do vendedor")
    private String salesmanId;

    @ApiModelProperty(value = "Valor da cota")
    private Double value;

    @ApiModelProperty(value = "Identificador do período de vigência")
    private String quarterId;

    public String getSalesmanId() {
        return salesmanId;
    }

    public QuotaCreateDto setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public QuotaCreateDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getQuarterId() {
        return quarterId;
    }

    public QuotaCreateDto setQuarterId(String quarterId) {
        this.quarterId = quarterId;
        return this;
    }
}
