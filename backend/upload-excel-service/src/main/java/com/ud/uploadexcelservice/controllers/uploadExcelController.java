package com.ud.uploadexcelservice.controllers;

import com.ud.uploadexcelservice.dtos.StockPriceDto;
import com.ud.uploadexcelservice.services.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class uploadExcelController {

    @Autowired
    private StockPriceService stockPriceService;

    @PostMapping
    public void uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        this.stockPriceService.saveStockPriceFromExcel(file);
    }
}
