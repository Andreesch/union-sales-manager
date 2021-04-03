package com.union.salesmanagementcore.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "QUOTA")
public class Quota {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "QUOTA_TYPE", nullable = false)
    private QuotaType quotaType;

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @Column(name = "INITIAL_QUARTER_REFERENCE", nullable = false)
    private LocalDate initialQuarterReference;

    @Column(name = "END_QUARTER_REFERENCE", nullable = false)
    private LocalDate endQuarterReference;

    @OneToMany(mappedBy = "quota", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Goal> goals;

    public String getId() {
        return id;
    }

    public Quota setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Quota setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public QuotaType getQuotaType() {
        return quotaType;
    }

    public Quota setQuotaType(QuotaType quotaType) {
        this.quotaType = quotaType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Quota setValue(Double value) {
        this.value = value;
        return this;
    }

    public LocalDate getInitialQuarterReference() {
        return initialQuarterReference;
    }

    public Quota setInitialQuarterReference(LocalDate initialQuarterReference) {
        this.initialQuarterReference = initialQuarterReference;
        return this;
    }

    public LocalDate getEndQuarterReference() {
        return endQuarterReference;
    }

    public Quota setEndQuarterReference(LocalDate endQuarterReference) {
        this.endQuarterReference = endQuarterReference;
        return this;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public Quota setGoals(List<Goal> goals) {
        this.goals = goals;
        return this;
    }
}
