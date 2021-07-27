import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Company } from '../models/Company';
import { CompanyDto } from '../models/CompanyDto';

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

  getMatchingCompanyList(companyName: string): Observable<Company[]> {
    return this.http.get<Company[]>(`${this.url}matchingCompanyList?companyName=${companyName}`, this.httpOptions);
  }

  getCompanyList(): Observable<Company[]> {
    return this.http.get<Company[]>(`${this.url}`, this.httpOptions);
  }

  addCompany(companyDto: CompanyDto): Observable<CompanyDto> {
    return this.http.post<CompanyDto>(`${this.url}`, companyDto, this.httpOptions);
  }

  updateCompany(companyDto: CompanyDto): Observable<CompanyDto> {
    return this.http.put<CompanyDto>(`${this.url}`, companyDto, this.httpOptions);
  }
}
