package com.union.salesmanagementcore.api.dto;

import com.union.salesmanagementcore.entities.Region;

public class SalesmanResponseDto {

    private String id;

    private String name;

    private Region region;

    public String getId() {
        return id;
    }

    public SalesmanResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SalesmanResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public SalesmanResponseDto setRegion(Region region) {
        this.region = region;
        return this;
    }
}
