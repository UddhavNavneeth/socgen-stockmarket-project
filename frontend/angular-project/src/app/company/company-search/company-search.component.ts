import { Component, OnInit } from '@angular/core';

import { CompanyService } from '../company.service';

import { Company } from 'src/app/models/Company';

@Component({
  selector: 'app-company-search',
  templateUrl: './company-search.component.html',
  styleUrls: ['./company-search.component.css']
})
export class CompanySearchComponent implements OnInit {

  public companyName: string;
  public companyList: Company[]; 

  constructor(private companyService: CompanyService) {
    this.companyName = '';
    this.companyList = [];
   }

  ngOnInit(): void {
  }

  getMatchingCompanies() {
    this.companyService.getMatchingCompanyList(this.companyName).subscribe((list) => {
      this.companyList = list;
    }, (e) => {
      console.log(e);
    })
  }
}
