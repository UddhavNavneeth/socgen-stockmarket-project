package com.ud.sectorservice.repositories;

import com.ud.sectorservice.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
