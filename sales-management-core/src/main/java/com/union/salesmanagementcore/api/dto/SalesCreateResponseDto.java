package com.union.salesmanagementcore.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SalesResponse")
public class SalesCreateResponseDto {

    @ApiModelProperty(value = "${sales.response.id}")
    private String id;

    @ApiModelProperty(value = "${sales.response.description}")
    private String description;

    @ApiModelProperty(value = "${sales.response.value}")
    private Double value;

    @ApiModelProperty(value = "${sales.response.createdAt}")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "${sales.response.salesmanId}")
    private String salesmanId;

    public String getId() {
        return id;
    }

    public SalesCreateResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SalesCreateResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public SalesCreateResponseDto setValue(Double value) {
        this.value = value;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public SalesCreateResponseDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public SalesCreateResponseDto setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
        return this;
    }
}
