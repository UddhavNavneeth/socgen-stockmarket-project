import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { CompanyService } from '../company.service';

import { Company } from 'src/app/models/Company';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {

  public company: Company;

  constructor(
    private companyService: CompanyService,
    private route: ActivatedRoute
    ) {
    this.company = {
      id: 0,
      name: '',
      turnover: 0,
      ceo: '',
      brief: '',
      sector: {
        id: 0,
        name: '',
        brief: ''
      }
    };
   }

  ngOnInit(): void {
    this.getCompany();
  }

  getCompany() {
    const companyId: number = Number(this.route.snapshot.paramMap.get('id'));
    this.companyService.getCompanyById(companyId).subscribe((company) => {
      this.company = company;
    }, (e) => {
      console.log(e);
    });
  }

}
