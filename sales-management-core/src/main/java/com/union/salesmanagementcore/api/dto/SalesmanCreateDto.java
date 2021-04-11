package com.union.salesmanagementcore.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.union.salesmanagementcore.entities.Region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesmanCreate")
public class SalesmanCreateDto {

    @NotBlank
    @ApiModelProperty(value = "Nome do vendedor")
    private String name;

    @NotNull
    @ApiModelProperty(value = "Região de atuação")
    private Region region;

    @NotNull
    @ApiModelProperty(value = "Identificador da comissão")
    private String commissionId;

    public String getName() {
        return name;
    }

    public SalesmanCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public SalesmanCreateDto setRegion(Region region) {
        this.region = region;
        return this;
    }

    public String getCommissionId() {
        return commissionId;
    }

    public SalesmanCreateDto setCommissionId(String commissionId) {
        this.commissionId = commissionId;
        return this;
    }
}
