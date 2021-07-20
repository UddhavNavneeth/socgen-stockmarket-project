package com.ud.stockexchangeservice.controllers;


import com.ud.stockexchangeservice.entities.Company;
import com.ud.stockexchangeservice.entities.StockExchange;
import com.ud.stockexchangeservice.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/stockExchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping
    public List<StockExchange> getStockExchangeList() {
        return stockExchangeService.getStockExchangeList();
    }

    @PostMapping
    public StockExchange addStockExchange(@RequestBody StockExchange stockExchange) {
        return stockExchangeService.addStockExchange(stockExchange);
    }

    @GetMapping("/companyList")
    public List<Company> getCompanyListForAStockExchange(@RequestParam Long stockExchangeId) {
        return this.stockExchangeService.getCompanyListForAStockExchange(stockExchangeId);
    }

    // additional routes not mentioned in the project document but are crud operations
    @PutMapping
    public StockExchange updateStockExchange(@RequestBody StockExchange stockExchange) {
        return this.stockExchangeService.updateStockExchange(stockExchange);
    }

    @DeleteMapping
    public void deleteStockExchange(@RequestParam Long stockExchangeId) {
        this.stockExchangeService.deleteStockExchange(stockExchangeId);
    }
}
