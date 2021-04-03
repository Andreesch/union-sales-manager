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
    @JoinColumn(name = "SALESMAN_CONFIG_ID", referencedColumnName = "ID", nullable = false)
    private SalesmanConfig salesmanConfig;

    @OneToMany(mappedBy = "salesman", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Goal> goal;

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

    public SalesmanConfig getSalesmanConfig() {
        return salesmanConfig;
    }

    public Salesman setSalesmanConfig(SalesmanConfig salesmanConfig) {
        this.salesmanConfig = salesmanConfig;
        return this;
    }

    public List<Goal> getGoal() {
        return goal;
    }

    public Salesman setGoal(List<Goal> goal) {
        this.goal = goal;
        return this;
    }
}
