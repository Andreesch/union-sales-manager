package com.union.salesmanagementcore.api.dto;

import java.time.LocalDate;

public class QuarterResponseDto {

    private String id;

    private LocalDate createdAt;

    private LocalDate initQuarterReference;

    private LocalDate endQuarterReference;

    public String getId() {
        return id;
    }

    public QuarterResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public QuarterResponseDto setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getInitQuarterReference() {
        return initQuarterReference;
    }

    public QuarterResponseDto setInitQuarterReference(LocalDate initQuarterReference) {
        this.initQuarterReference = initQuarterReference;
        return this;
    }

    public LocalDate getEndQuarterReference() {
        return endQuarterReference;
    }

    public QuarterResponseDto setEndQuarterReference(LocalDate endQuarterReference) {
        this.endQuarterReference = endQuarterReference;
        return this;
    }
}
