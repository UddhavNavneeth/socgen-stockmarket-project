package com.ud.companyservice.services;

import com.ud.companyservice.dtos.IpoDetailDto;
import com.ud.companyservice.entities.IpoDetail;
import com.ud.companyservice.repositories.CompanyRepository;
import com.ud.companyservice.repositories.IpoDetailRepository;
import com.ud.companyservice.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IpoDetailService {

    @Autowired
    private IpoDetailRepository ipoDetailRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    public IpoDetail getIpoDetailByCompanyId(Long companyId) {
        return this.ipoDetailRepository.findIpoDetailByCompany_Id(companyId);
    }

    public List<IpoDetail> getOrderedIpoDetailList() {
        return this.ipoDetailRepository.findAllByOrderByOpenDateTimeAsc();
    }

    // additional service methods not mentioned in project report

    public List<IpoDetail> getIpoDetailList() {
        return this.ipoDetailRepository.findAll();
    }

    public IpoDetailDto addIpoDetail(IpoDetailDto ipoDetailDto) {
        IpoDetail ipoDetail = dtoToEntity(ipoDetailDto);
        return entityToDto(this.ipoDetailRepository.save(ipoDetail));
    }

    public IpoDetailDto updateIpoDetail(IpoDetailDto ipoDetailDto) {
        IpoDetail ipoDetail = dtoToEntity(ipoDetailDto);
        return entityToDto(this.ipoDetailRepository.save(ipoDetail));
    }

    public void deleteIpoDetail(Long IpoDetailId) {
        this.ipoDetailRepository.deleteById(IpoDetailId);
    }


    public IpoDetail dtoToEntity(IpoDetailDto ipoDetailDto) {
        IpoDetail ipoDetail = new IpoDetail();
        ipoDetail.setId(ipoDetailDto.getId());
        ipoDetail.setPricePerShare(ipoDetailDto.getPricePerShare());
        ipoDetail.setTotalNumberOfShares(ipoDetailDto.getTotalNumberOfShares());
        ipoDetail.setRemarks(ipoDetailDto.getRemarks());
        ipoDetail.setOpenDateTime(ipoDetailDto.getOpenDateTime());
        ipoDetail.setCompany(this.companyRepository.findById(ipoDetailDto.getCompanyId()).get());
        ipoDetail.setStockExchange(this.stockExchangeRepository.findById(ipoDetailDto.getStockExchangeId()).get());

        return ipoDetail;
    }

    public IpoDetailDto entityToDto(IpoDetail ipoDetail) {
        IpoDetailDto ipoDetailDto = new IpoDetailDto();
        ipoDetailDto.setId(ipoDetail.getId());
        ipoDetailDto.setPricePerShare(ipoDetail.getPricePerShare());
        ipoDetailDto.setTotalNumberOfShares(ipoDetail.getTotalNumberOfShares());
        ipoDetailDto.setRemarks(ipoDetail.getRemarks());
        ipoDetailDto.setOpenDateTime(ipoDetail.getOpenDateTime());
        ipoDetailDto.setCompanyId(ipoDetail.getCompany().getId());
        ipoDetailDto.setStockExchangeId(ipoDetail.getStockExchange().getId());

        return ipoDetailDto;
    }
}
