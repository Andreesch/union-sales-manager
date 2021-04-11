package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.union.salesmanagementcore.entities.Quarter;

public interface QuarterRepository extends JpaRepository<Quarter, String> {
}
