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

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @OneToMany(mappedBy = "quota", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Sales> sales;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "SALESMAN_ID", referencedColumnName = "ID")
    private Salesman salesman;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "QUARTER_ID", referencedColumnName = "ID")
    private Quarter quarter;

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

    public Double getValue() {
        return value;
    }

    public Quota setValue(Double value) {
        this.value = value;
        return this;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public Quota setSales(List<Sales> sales) {
        this.sales = sales;
        return this;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Quota setSalesman(Salesman salesman) {
        this.salesman = salesman;
        return this;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public Quota setQuarter(Quarter quarter) {
        this.quarter = quarter;
        return this;
    }
}
