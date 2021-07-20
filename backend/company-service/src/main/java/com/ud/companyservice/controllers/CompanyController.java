package com.ud.companyservice.controllers;

import com.ud.companyservice.dtos.CompanyDto;
import com.ud.companyservice.entities.Company;
import com.ud.companyservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value="/companyById")
    public CompanyDto getCompanyById(@RequestParam Long companyId) {
        return this.companyService.getCompanyById(companyId);
    }

    @GetMapping(value = "/matchingCompanyList")
    public List<CompanyDto> getMatchingCompanies(@RequestParam String companyName) {
        return this.companyService.getMatchingCompanyList(companyName);
    }

    // additional routes not mentioned in the project document but are crud operations

    @GetMapping
    public List<Company> getCompanyList() {
        return this.companyService.getCompanyList();
    }

    @PostMapping
    public Company addCompany(@RequestBody CompanyDto companyDto) {
        return this.companyService.addCompany(companyDto);
    }

    @PutMapping
    public Company updateCompany(@RequestBody CompanyDto companyDto) {
        return this.companyService.updateCompany(companyDto);
    }

    @DeleteMapping
    public void deleteCompany(@RequestParam Long companyId) {
        this.companyService.deleteCompany(companyId);
    }
}
