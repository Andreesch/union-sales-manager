package com.union.salesmanagementcore.helper;

import com.union.salesmanagementcore.entities.CommissionType;

public class CommissionHelper {

    public static Double calculateCommissionToReceive(Double totalSalesValue, Double commissionValue,
            CommissionType commissionType, boolean hasAchievedGoal) {

        if (!hasAchievedGoal) {
            return 0d;
        }

        if (CommissionType.VALUE.equals(commissionType)) {
            return commissionValue;
        } else {
            return (totalSalesValue * commissionValue) / 100;
        }
    }
}
