import { Component, OnInit } from '@angular/core';

import { CompanyService } from '../company.service';

import { Company } from 'src/app/models/Company';

@Component({
  selector: 'app-admin-company-list',
  templateUrl: './admin-company-list.component.html',
  styleUrls: ['./admin-company-list.component.css']
})
export class AdminCompanyListComponent implements OnInit {

  public companyList: Company[];

  constructor(private companyService: CompanyService) {
    this.companyList = [];

   }

  ngOnInit(): void {
    this.getCompanyList();
  }

  getCompanyList() {
    return this.companyService.getCompanyList().subscribe((list) => {
      this.companyList = list;
    }, (e) => {
      console.log(e);
    })
  }

}
