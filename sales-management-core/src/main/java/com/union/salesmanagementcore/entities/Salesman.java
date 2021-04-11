package com.union.salesmanagementcore.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SALESMAN")
public class Salesman {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "REGION", nullable = false)
    private Region region;

    @OrderBy("createdAt ASC")
    @OneToMany(mappedBy = "salesman", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Sales> sales;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMISSION_ID", referencedColumnName = "ID", nullable = false)
    private Commission commission;

    @OneToMany(mappedBy = "salesman", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Quota> quotas;

    @OneToMany(mappedBy = "salesman", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Payment> payments;

    public String getId() {
        return id;
    }

    public Salesman setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Salesman setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Salesman setRegion(Region region) {
        this.region = region;
        return this;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public Salesman setSales(List<Sales> sales) {
        this.sales = sales;
        return this;
    }

    public Commission getCommission() {
        return commission;
    }

    public Salesman setCommission(Commission commission) {
        this.commission = commission;
        return this;
    }

    public List<Quota> getQuotas() {
        return quotas;
    }

    public Salesman setQuotas(List<Quota> quotas) {
        this.quotas = quotas;
        return this;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public Salesman setPayments(List<Payment> payments) {
        this.payments = payments;
        return this;
    }
}
