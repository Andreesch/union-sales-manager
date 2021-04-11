package com.union.salesmanagementcore.strategy;

import com.union.salesmanagementcore.services.vo.PaymentCreateVO;

public interface PaymentStrategy {

    void pay(PaymentCreateVO paymentCreateVO);
}
