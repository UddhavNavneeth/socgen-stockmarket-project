package com.ud.stockexchangeservice.repositories;

import com.ud.stockexchangeservice.entities.CompanyCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyCodeRepository extends JpaRepository<CompanyCode, Long> {
    List<CompanyCode> findCompanyCodeByStockExchange_Id(Long id);
}
