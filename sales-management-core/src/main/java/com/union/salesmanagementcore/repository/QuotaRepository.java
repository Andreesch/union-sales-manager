package com.union.salesmanagementcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.union.salesmanagementcore.entities.Quota;

public interface QuotaRepository extends JpaRepository<Quota, String>, QuotaSearchRepository {
}
