package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.union.salesmanagementcore.entities.Payment;

@Repository
public interface PaymentTestRepository extends JpaRepository<Payment, String> {
}
