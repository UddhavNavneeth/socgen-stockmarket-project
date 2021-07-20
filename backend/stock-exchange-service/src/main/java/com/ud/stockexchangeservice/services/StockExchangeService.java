package com.ud.stockexchangeservice.services;

import com.ud.stockexchangeservice.entities.Company;
import com.ud.stockexchangeservice.entities.CompanyCode;
import com.ud.stockexchangeservice.entities.StockExchange;
import com.ud.stockexchangeservice.repositories.CompanyCodeRepository;
import com.ud.stockexchangeservice.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private CompanyCodeRepository companyCodeRepository;

    public List<StockExchange> getStockExchangeList() {
        return this.stockExchangeRepository.findAll();
    }

    public StockExchange addStockExchange(StockExchange stockExchange) {
        return this.stockExchangeRepository.save(stockExchange);
    }

    public List<Company> getCompanyListForAStockExchange(Long stockExchangeId) {
        List<CompanyCode> companyCodes = this.companyCodeRepository.findCompanyCodeByStockExchange_Id(stockExchangeId);
        List<Company> companies = new ArrayList<Company>();
        companyCodes.forEach(companyCode -> {
            companies.add(companyCode.getCompany());
        });

        return companies;
    }

    // additional service methods not mentioned in project report

    public StockExchange updateStockExchange(StockExchange stockExchange) {
        return this.stockExchangeRepository.save(stockExchange);
    }

    public void deleteStockExchange(Long stockExchangeId) {
        this.stockExchangeRepository.deleteById(stockExchangeId);
    }
}
