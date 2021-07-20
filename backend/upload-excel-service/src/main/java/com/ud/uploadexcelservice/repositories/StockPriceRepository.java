package com.ud.uploadexcelservice.repositories;

import com.ud.uploadexcelservice.entities.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
