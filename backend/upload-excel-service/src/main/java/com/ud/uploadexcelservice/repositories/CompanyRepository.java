package com.ud.uploadexcelservice.repositories;

import com.ud.uploadexcelservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
