package com.union.salesmanagementcore.services.vo;

import com.union.salesmanagementcore.entities.Quota;
import com.union.salesmanagementcore.entities.Salesman;

public class PaymentCreateVO {

    private Quota quota;

    private Double totalValue;

    private Salesman salesman;

    public Quota getQuota() {
        return quota;
    }

    public PaymentCreateVO setQuota(Quota quota) {
        this.quota = quota;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public PaymentCreateVO setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public PaymentCreateVO setSalesman(Salesman salesman) {
        this.salesman = salesman;
        return this;
    }
}
