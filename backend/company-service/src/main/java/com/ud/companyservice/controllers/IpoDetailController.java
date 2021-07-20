package com.ud.companyservice.controllers;

import com.ud.companyservice.dtos.IpoDetailDto;
import com.ud.companyservice.services.IpoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/ipoDetail")
public class IpoDetailController {

    @Autowired
    private IpoDetailService ipoDetailService;

    @GetMapping("/byCompanyId")
    public IpoDetailDto getIpoDetailByCompanyId(@RequestParam Long companyId) {
        return this.ipoDetailService.getIpoDetailByCompanyId(companyId);
    }

    // additional routes not mentioned in the project document but are crud operations

    @GetMapping
    public List<IpoDetailDto> getIpoDetailList() {
        return this.ipoDetailService.getIpoDetailList();
    }

    @PostMapping
    public IpoDetailDto addIpoDetail(@RequestBody IpoDetailDto ipoDetailDto) {
        return this.ipoDetailService.addIpoDetail(ipoDetailDto);
    }

    @PutMapping
    public IpoDetailDto updateIpoDetail(@RequestBody IpoDetailDto ipoDetailDto) {
        return this.ipoDetailService.updateIpoDetail(ipoDetailDto);
    }

    @DeleteMapping
    public void deleteIpoDetail(Long ipoDetailId) {
        this.ipoDetailService.deleteIpoDetail(ipoDetailId);
    }
}
