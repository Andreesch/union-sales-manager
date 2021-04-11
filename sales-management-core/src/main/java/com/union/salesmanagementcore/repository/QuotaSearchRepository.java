package com.union.salesmanagementcore.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.union.salesmanagementcore.entities.Quota;

public interface QuotaSearchRepository {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Query(value = "SELECT quota FROM Quota quota"
            + " JOIN FETCH quota.salesman salesman"
            + " JOIN FETCH quota.quarter quarter"
            + " WHERE salesman.id = :salesmanId "
            + " AND :referenceDate BETWEEN quarter.initQuarterReference AND quarter.endQuarterReference ")
    Optional<Quota> findBySalesmanIdAndReferenceDate(@Param("salesmanId") String id,
            @Param("referenceDate") LocalDate saleDate);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Query(value = "SELECT quota FROM Quota quota"
            + " JOIN FETCH quota.salesman salesman"
            + " JOIN FETCH quota.quarter quarter"
            + " WHERE salesman.id = :salesmanId "
            + " AND quarter.id = :quarterId ")
    Optional<Quota> findBySalesmanIdAndQuarterId(@Param("salesmanId") String id,
            @Param("quarterId") String quarterId);
}
