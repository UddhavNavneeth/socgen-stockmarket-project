import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Company } from '../models/Company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private url = "http://localhost:8081/company/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http: HttpClient) { }

  getCompanyById(companyId: number): Observable<Company> {
    return this.http.get<Company>(`${this.url}companyById?companyId=${companyId}`, this.httpOptions);
  }
}
