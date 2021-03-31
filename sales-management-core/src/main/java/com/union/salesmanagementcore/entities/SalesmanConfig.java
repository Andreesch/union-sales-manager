package com.union.salesmanagementcore.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SALESMAN_CONFIG")
public class SalesmanConfig {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "COMMISSION_TYPE", nullable = false)
    private CommissionType commissionType;

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @OrderBy("id DESC")
    @OneToMany(mappedBy = "salesmanConfig", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Salesman> salesman;

    public String getId() {
        return id;
    }

    public SalesmanConfig setId(String id) {
        this.id = id;
        return this;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public SalesmanConfig setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public SalesmanConfig setValue(Double value) {
        this.value = value;
        return this;
    }

    public List<Salesman> getSalesman() {
        return salesman;
    }

    public SalesmanConfig setSalesman(List<Salesman> salesman) {
        this.salesman = salesman;
        return this;
    }
}
