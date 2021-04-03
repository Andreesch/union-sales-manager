package com.union.salesmanagementcore.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GOAL")
public class Goal {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "GOAL_SALESMAN_ID", referencedColumnName = "ID", nullable = false)
    private Salesman salesman;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "GOAL_QUOTA_ID", referencedColumnName = "ID", nullable = false)
    private Quota quota;

    private LocalDate createdAt;

    public String getId() {
        return id;
    }

    public Goal setId(String id) {
        this.id = id;
        return this;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Goal setSalesman(Salesman salesman) {
        this.salesman = salesman;
        return this;
    }

    public Quota getQuota() {
        return quota;
    }

    public Goal setQuota(Quota quota) {
        this.quota = quota;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Goal setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
