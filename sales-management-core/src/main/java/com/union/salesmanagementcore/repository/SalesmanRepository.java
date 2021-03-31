package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.union.salesmanagementcore.entities.Salesman;

public interface SalesmanRepository extends JpaRepository<Salesman, String> {
}
