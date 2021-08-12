import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { IpoDetail } from '../models/IpoDetail';

@Injectable({
  providedIn: 'root'
})
export class IpoService {

  private url = "http://localhost:8081/ipoDetail/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http: HttpClient) { }

  getIpoDetailList(): Observable<IpoDetail[]> {
    return this.http.get<IpoDetail[]>(`${this.url}ordered`, this.httpOptions);
  }
}
