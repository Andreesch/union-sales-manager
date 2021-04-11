package com.union.salesmanagementcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.union.salesmanagementcore.entities.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {

    List<Sales> findAllBySalesmanId(String salesmanId);
}
