package com.ud.companyservice.controllers;

import com.ud.companyservice.dtos.StockPriceDto;
import com.ud.companyservice.services.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stockPrice")
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceService;

    @GetMapping(value = "/stockPriceCondtional")
    public List<StockPriceDto> getStockListWithConditions(
            @RequestParam Long companyId, @RequestParam Long stockExchangeId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {

      return this.stockPriceService.getStockPriceListWithConditions(companyId, stockExchangeId, from, to);
    }

    // additional routes not mentioned in the project document but are crud operations

    @GetMapping
    public List<StockPriceDto> getStockPriceList() {
        return this.stockPriceService.getStockPriceList();
    }


    @PostMapping
    public StockPriceDto addStockPrice(@RequestBody StockPriceDto stockPriceDto) {
        return this.stockPriceService.addStockPrice(stockPriceDto);
    }

    @PutMapping
    public StockPriceDto uploadStockPrice(@RequestBody StockPriceDto stockPriceDto) {
        return this.stockPriceService.updateStockPrice(stockPriceDto);
    }

    @DeleteMapping
    public void deleteStockPrice(@RequestParam Long stockPriceId) {
        this.stockPriceService.deleteStockPrice(stockPriceId);
    }
}
