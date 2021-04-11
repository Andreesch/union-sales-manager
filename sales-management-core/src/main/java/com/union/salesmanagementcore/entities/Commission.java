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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "COMMISSION")
public class Commission {

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
    @OneToMany(mappedBy = "commission", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Salesman> salesman;

    public String getId() {
        return id;
    }

    public Commission setId(String id) {
        this.id = id;
        return this;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public Commission setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Commission setValue(Double value) {
        this.value = value;
        return this;
    }

    public List<Salesman> getSalesman() {
        return salesman;
    }

    public Commission setSalesman(List<Salesman> salesman) {
        this.salesman = salesman;
        return this;
    }
}
