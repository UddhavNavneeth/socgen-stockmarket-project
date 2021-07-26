package com.ud.sectorservice.services;

import com.ud.sectorservice.dtos.CompanyDto;
import com.ud.sectorservice.entities.Company;
import com.ud.sectorservice.entities.Sector;
import com.ud.sectorservice.repositories.CompanyRepository;
import com.ud.sectorservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompanyListForASector(Long sectorId) {
        return this.companyRepository.findCompaniesBySector_Id(sectorId);
    }

    // additional service methods not mentioned in project report
    public List<Sector> getSectorList() {
        return this.sectorRepository.findAll();
    }

    public Sector addSector(Sector sector) {
        return this.sectorRepository.save(sector);
    }

    public Sector updateSector(Sector sector) {
        return this.sectorRepository.save(sector);
    }

    public void deleteSector(Long sectorId) {
        this.sectorRepository.deleteById(sectorId);
    }

    public Company dtoToEntity(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setTurnover(companyDto.getTurnover());
        company.setCeo(companyDto.getCeo());
        company.setBrief(companyDto.getBrief());
        company.setSector(this.sectorRepository.findById(companyDto.getSectorId()).get());

        return company;
    }

    public CompanyDto entityToDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setTurnover(company.getTurnover());
        companyDto.setCeo(company.getCeo());
        companyDto.setBrief(company.getBrief());
        companyDto.setSectorId(company.getSector().getId());

        return companyDto;
    }
}
