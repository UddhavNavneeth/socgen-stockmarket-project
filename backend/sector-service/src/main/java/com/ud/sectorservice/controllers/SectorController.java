package com.ud.sectorservice.controllers;

import com.ud.sectorservice.entities.Company;
import com.ud.sectorservice.entities.Sector;
import com.ud.sectorservice.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/companyList")
    public List<Company> getCompanyListForASector(@RequestParam Long sectorId) {
        return this.sectorService.getCompanyListForASector(sectorId);
    }

    // additional routes not mentioned in the project document but are crud operations
    @GetMapping
    public List<Sector> getSectorList() {
        return this.sectorService.getSectorList();
    }

    @PostMapping
    public Sector addSector(@RequestBody Sector sector) {
        return this.sectorService.addSector(sector);
    }

    @PutMapping
    public Sector updateSector(@RequestBody Sector sector) {
        return this.sectorService.updateSector(sector);
    }

    @DeleteMapping
    public void deleteSector(@RequestParam Long sectorId) {
        this.sectorService.deleteSector(sectorId);
    }
}
