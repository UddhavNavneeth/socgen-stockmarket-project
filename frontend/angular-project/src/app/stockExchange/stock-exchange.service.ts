import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { StockExchange } from '../models/StockExchange';

@Injectable({
  providedIn: 'root'
})
export class StockExchangeService {

  private url = "http://localhost:8082/stockExchange/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http: HttpClient) { }

  getStockExchangeList(): Observable<StockExchange[]> {
    return this.http.get<StockExchange[]>(`${this.url}`, this.httpOptions);
  }

  addStockExchange(stockExchange: StockExchange): Observable<StockExchange> {
    return this.http.post<StockExchange>(`${this.url}`, stockExchange, this.httpOptions);
  }
}
