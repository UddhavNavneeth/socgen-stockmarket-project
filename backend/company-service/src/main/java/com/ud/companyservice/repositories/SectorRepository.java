package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
