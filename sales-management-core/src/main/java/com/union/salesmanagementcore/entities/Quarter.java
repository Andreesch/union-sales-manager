package com.union.salesmanagementcore.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "QUARTER")
public class Quarter {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @Column(name = "INIT_QUARTER_REFERENCE", nullable = false)
    private LocalDate initQuarterReference;

    @Column(name = "END_QUARTER_REFERENCE", nullable = false)
    private LocalDate endQuarterReference;

    @OneToMany(mappedBy = "quarter", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Quota> quotas;

    public String getId() {
        return id;
    }

    public Quarter setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Quarter setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getInitQuarterReference() {
        return initQuarterReference;
    }

    public Quarter setInitQuarterReference(LocalDate initQuarterReference) {
        this.initQuarterReference = initQuarterReference;
        return this;
    }

    public LocalDate getEndQuarterReference() {
        return endQuarterReference;
    }

    public Quarter setEndQuarterReference(LocalDate endQuarterReference) {
        this.endQuarterReference = endQuarterReference;
        return this;
    }

    public List<Quota> getQuotas() {
        return quotas;
    }

    public Quarter setQuotas(List<Quota> quotas) {
        this.quotas = quotas;
        return this;
    }
}
