import { Component, OnInit } from '@angular/core';

import { SectorService } from '../sector.service';

import { Company } from 'src/app/models/Company';

@Component({
  selector: 'app-company-list-by-sector',
  templateUrl: './company-list-by-sector.component.html',
  styleUrls: ['./company-list-by-sector.component.css']
})
export class CompanyListBySectorComponent implements OnInit {

  public companyList: Company[]

  constructor(private sectorService: SectorService) { 
    this.companyList = [];
  }

  ngOnInit(): void {
    this.getCompanyList(12);
  }

  getCompanyList(sectorId: number) {
    this.sectorService.companyList(sectorId).subscribe((list) => {
      this.companyList = list;
    }, (e) => {
      console.log(e);
    })
  }

}
