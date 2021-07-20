package com.ud.companyservice.services;

import com.ud.companyservice.dtos.CompanyDto;
import com.ud.companyservice.entities.Company;
import com.ud.companyservice.repositories.CompanyRepository;
import com.ud.companyservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private SectorRepository sectorRepository;

    public CompanyDto getCompanyById(Long companyId) {
        return entityToDto(this.companyRepository.findById(companyId).get());
    }

    public List<CompanyDto> getMatchingCompanyList(String companyName) {
        List<CompanyDto> companyDtoList = new ArrayList<CompanyDto>();
        this.companyRepository.findByNameLike(companyName + "%").forEach(company -> {
            companyDtoList.add(entityToDto(company));
        });

        return companyDtoList;
    }

    // additional service methods not mentioned in project report

    public List<Company> getCompanyList() {
        return this.companyRepository.findAll();
    }

    public Company addCompany(CompanyDto companyDto) {
        Company company = dtoToEntity(companyDto);
        return this.companyRepository.save(company);
    }

    public Company updateCompany(CompanyDto companyDto) {
        Company company = dtoToEntity(companyDto);
        return this.companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        this.companyRepository.deleteById(companyId);
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
