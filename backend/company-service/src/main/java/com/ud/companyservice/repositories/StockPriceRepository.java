package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
    List<StockPrice> findStockPricesByCompany_IdAndStockExchange_IdAndDateAfterAndDateBefore(Long companyId, Long stockExchangeId, Date from, Date to);
}
