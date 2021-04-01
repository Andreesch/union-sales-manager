package com.union.salesmanagementcore.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.union.salesmanagementcore.entities.Region;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesmanUpdate")
public class SalesmanUpdateDto {

    @NotNull
    @ApiModelProperty(value = "${salesman.update.id}")
    private String salesmanId;

    @NotBlank
    @ApiModelProperty(value = "${salesman.update.name}")
    private String name;

    @NotNull
    @ApiModelProperty(value = "${salesman.update.region}")
    private Region region;

    @NotBlank
    @ApiModelProperty(value = "${salesman.update.configId}")
    private String salesmanConfigId;

    public String getSalesmanId() {
        return salesmanId;
    }

    public SalesmanUpdateDto setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SalesmanUpdateDto setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public SalesmanUpdateDto setRegion(Region region) {
        this.region = region;
        return this;
    }

    public String getSalesmanConfigId() {
        return salesmanConfigId;
    }

    public SalesmanUpdateDto setSalesmanConfigId(String salesmanConfigId) {
        this.salesmanConfigId = salesmanConfigId;
        return this;
    }
}
