package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.union.salesmanagementcore.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, String> {
}
