package com.union.salesmanagementcore.api.dto;

import java.time.LocalDate;

public class QuarterCreateDto {

    private LocalDate initQuarterReference;

    private LocalDate endQuarterReference;

    public LocalDate getInitQuarterReference() {
        return initQuarterReference;
    }

    public QuarterCreateDto setInitQuarterReference(LocalDate initQuarterReference) {
        this.initQuarterReference = initQuarterReference;
        return this;
    }

    public LocalDate getEndQuarterReference() {
        return endQuarterReference;
    }

    public QuarterCreateDto setEndQuarterReference(LocalDate endQuarterReference) {
        this.endQuarterReference = endQuarterReference;
        return this;
    }
}
