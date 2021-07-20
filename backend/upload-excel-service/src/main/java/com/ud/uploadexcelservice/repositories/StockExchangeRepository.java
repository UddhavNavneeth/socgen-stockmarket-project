package com.ud.uploadexcelservice.repositories;

import com.ud.uploadexcelservice.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
}
