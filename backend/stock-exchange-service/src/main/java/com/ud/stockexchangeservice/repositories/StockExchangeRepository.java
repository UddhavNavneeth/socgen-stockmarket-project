package com.ud.stockexchangeservice.repositories;

import com.ud.stockexchangeservice.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
}
