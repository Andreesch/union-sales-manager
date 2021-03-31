package com.union.salesmanagementcore.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.union.salesmanagementcore.entities.Region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesmanCreate")
public class SalesmanCreateDto {

    @NotBlank
    @ApiModelProperty(value = "${salesman.create.name}")
    private String name;

    @NotNull
    @ApiModelProperty(value = "${salesman.create.region}")
    private Region region;

    @NotNull
    @ApiModelProperty(value = "${salesman.create.configId}")
    private String salesmanConfigId;

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

    public String getSalesmanConfigId() {
        return salesmanConfigId;
    }

    public SalesmanCreateDto setSalesmanConfigId(String salesmanConfigId) {
        this.salesmanConfigId = salesmanConfigId;
        return this;
    }
}
