package com.ud.companyservice.services;

import com.ud.companyservice.dtos.StockPriceDto;
import com.ud.companyservice.entities.StockPrice;
import com.ud.companyservice.repositories.CompanyRepository;
import com.ud.companyservice.repositories.StockExchangeRepository;
import com.ud.companyservice.repositories.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockPriceService {

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    public List<StockPriceDto> getStockPriceListWithConditions(Long companyId, Long stockExchangeId, Date from, Date to) {
        List <StockPriceDto> stockPriceDtoList = new ArrayList<StockPriceDto>();
        this.stockPriceRepository.findStockPricesByCompany_IdAndStockExchange_IdAndDateAfterAndDateBefore(companyId, stockExchangeId, from, to).forEach(stockPrice -> {
            stockPriceDtoList.add(entityToDto(stockPrice));
        });

        return stockPriceDtoList;
    }

    // additional service methods not mentioned in project report

    public List<StockPriceDto> getStockPriceList() {
        List <StockPriceDto> stockPriceDtoList = new ArrayList<StockPriceDto>();
        this.stockPriceRepository.findAll().forEach(stockPrice -> {
            stockPriceDtoList.add(entityToDto(stockPrice));
        });
        return stockPriceDtoList;
    }

    public StockPriceDto addStockPrice(StockPriceDto stockPriceDto) {
        StockPrice stockPrice = dtoToEntity(stockPriceDto);
        return entityToDto(this.stockPriceRepository.save(stockPrice));
    }

    public StockPriceDto updateStockPrice(StockPriceDto stockPriceDto) {
        StockPrice stockPrice = dtoToEntity(stockPriceDto);
        return entityToDto(this.stockPriceRepository.save(stockPrice));
    }

    public void deleteStockPrice(Long stockPriceId) {
        this.stockPriceRepository.deleteById(stockPriceId);
    }

    public StockPrice dtoToEntity(StockPriceDto stockPriceDto) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.setId(stockPriceDto.getId());
        stockPrice.setCurrentPrice(stockPriceDto.getCurrentPrice());
        stockPrice.setDate(stockPriceDto.getDate());
        stockPrice.setTime(stockPriceDto.getTime());
        stockPrice.setCompany(this.companyRepository.findById(stockPriceDto.getCompanyId()).get());
        stockPrice.setStockExchange(this.stockExchangeRepository.findById(stockPriceDto.getStockExchangeId()).get());

        return stockPrice;
    }

    public StockPriceDto entityToDto(StockPrice stockPrice) {
        StockPriceDto stockPriceDto = new StockPriceDto();
        stockPriceDto.setId(stockPrice.getId());
        stockPriceDto.setCurrentPrice(stockPrice.getCurrentPrice());
        stockPriceDto.setDate(stockPrice.getDate());
        stockPriceDto.setTime(stockPrice.getTime());
        stockPriceDto.setCompanyId(stockPrice.getCompany().getId());
        stockPriceDto.setStockExchangeId(stockPrice.getStockExchange().getId());

        return stockPriceDto;
    }
}
