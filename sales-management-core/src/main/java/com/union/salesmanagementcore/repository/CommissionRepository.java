package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.union.salesmanagementcore.entities.Commission;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, String> {
}
