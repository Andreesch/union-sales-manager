package com.union.salesmanagementcore.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.union.salesmanagementcore.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Query(value = "SELECT payment FROM Payment payment"
            + " JOIN FETCH payment.salesman salesman"
            + " JOIN FETCH salesman.quotas quota"
            + " JOIN FETCH quota.quarter quarter"
            + " WHERE salesman.id = :salesmanId "
            + " AND :referenceDate BETWEEN quarter.initQuarterReference AND quarter.endQuarterReference ")
    Optional<Payment> findBySalesmanIdAndReferenceDate(@Param("salesmanId") String id,
            @Param("referenceDate") LocalDate referenceDate);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Query(value = "SELECT payment FROM Payment payment"
            + " JOIN FETCH payment.salesman salesman"
            + " JOIN FETCH salesman.quotas quota"
            + " JOIN FETCH quota.quarter quarter"
            + " WHERE quarter.id = :quarterId ")
    List<Payment> findAllByQuarterDate(@Param("quarterId") String quarterId);
}
