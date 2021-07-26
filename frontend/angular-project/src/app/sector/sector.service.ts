import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Company } from '../models/Company';

@Injectable({
  providedIn: 'root'
})
export class SectorService {

  private url = "http://localhost:8083/sector/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http: HttpClient) { }

  companyList(sectorId: number): Observable<Company[]> {
    return this.http.get<Company[]>(`${this.url}companyList?sectorId=${sectorId}`, this.httpOptions)
  }
}
