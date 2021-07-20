package com.ud.uploadexcelservice.services;

import com.ud.uploadexcelservice.dtos.StockPriceDto;
import com.ud.uploadexcelservice.entities.StockPrice;
import com.ud.uploadexcelservice.repositories.CompanyRepository;
import com.ud.uploadexcelservice.repositories.StockExchangeRepository;
import com.ud.uploadexcelservice.repositories.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public void saveStockPriceFromExcel(MultipartFile file) {
        List<StockPrice> stockPriceList = new ArrayList<StockPrice>();

        try {
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet worksheet = workbook.getSheetAt(0);

            for (int i = 1; i < 10; i++) {
                StockPriceDto stockPriceDto = new StockPriceDto();

                Row row = worksheet.getRow(i);

                stockPriceDto.setCompanyId((long) row.getCell(0).getNumericCellValue());
                stockPriceDto.setStockExchangeId((long) row.getCell(1).getNumericCellValue());
                stockPriceDto.setCurrentPrice((float) row.getCell(2).getNumericCellValue());
                stockPriceDto.setDate(row.getCell(3).getDateCellValue());

                String cell = row.getCell(4).getStringCellValue();
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                Date time = df.parse(cell);
                stockPriceDto.setTime(time);

                stockPriceList.add(dtoToEntity(stockPriceDto));
            }

        } catch(Throwable e) {
            e.printStackTrace();
        }

        List<StockPriceDto> stockPriceDtoList = new ArrayList<StockPriceDto>();

        this.stockPriceRepository.saveAll(stockPriceList);
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
