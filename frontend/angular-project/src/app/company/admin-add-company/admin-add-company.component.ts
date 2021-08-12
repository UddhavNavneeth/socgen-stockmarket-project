import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { CompanyService } from '../company.service';

import { Company } from 'src/app/models/Company';
import { CompanyDto } from 'src/app/models/CompanyDto';

@Component({
  selector: 'app-admin-add-company',
  templateUrl: './admin-add-company.component.html',
  styleUrls: ['./admin-add-company.component.css']
})
export class AdminAddCompanyComponent implements OnInit {

  public companyDto: CompanyDto;
  public message: string;

  constructor(private companyService: CompanyService,
    private router: Router) {
    this.companyDto = {
      name: '',
      turnover: 0,
      ceo: '',
      brief: '',
      sectorId: 12
    }

    this.message = '';
   }

  ngOnInit(): void {
  }

  addCompany() {
    this.companyService.addCompany(this.companyDto).subscribe(() => {
      this.router.navigate(['/admin/companyList']);
    }, (e) => {
      this.message = e.error.message;
      console.log(e);
    })
  }
}
