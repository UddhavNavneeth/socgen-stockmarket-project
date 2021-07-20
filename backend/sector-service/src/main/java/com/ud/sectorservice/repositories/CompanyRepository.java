package com.ud.sectorservice.repositories;

import com.ud.sectorservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findCompaniesBySector_Id(Long id);
}
