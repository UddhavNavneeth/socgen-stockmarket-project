package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByNameLike(String companyName);
}
