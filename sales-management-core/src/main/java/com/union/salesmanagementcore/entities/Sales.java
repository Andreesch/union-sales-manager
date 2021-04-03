package com.union.salesmanagementcore.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SALE")
public class Sales {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "DESCRIPTION", length = 255, nullable = false)
    private String description;

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Salesman salesman;

    public String getId() {
        return id;
    }

    public Sales setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Sales setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Sales setValue(Double value) {
        this.value = value;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Sales setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Sales setSalesman(Salesman salesman) {
        this.salesman = salesman;
        return this;
    }
}

