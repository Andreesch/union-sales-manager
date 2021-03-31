package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.union.salesmanagementcore.entities.SalesmanConfig;

@Repository
public interface SalesmanConfigRepository extends JpaRepository<SalesmanConfig, String> {
}
