package com.union.salesmanagementcore.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PAYMENTS")
public class Payment {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDate createdAt;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private Double totalValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUOTA_ID", referencedColumnName = "id")
    private Quota quota;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "SALESMAN_ID", referencedColumnName = "ID")
    private Salesman salesman;

    public String getId() {
        return id;
    }

    public Payment setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Payment setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Payment setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public Quota getQuota() {
        return quota;
    }

    public Payment setQuota(Quota quota) {
        this.quota = quota;
        return this;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Payment setSalesman(Salesman salesman) {
        this.salesman = salesman;
        return this;
    }
}
