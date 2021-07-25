import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from '../models/User';
import { Login } from '../models/Login';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = "http://localhost:8086/user/signup";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http: HttpClient) { }

  signUp(user: User): Observable<User> {
    return this.http.post<User>(this.url, user, this.httpOptions);
  }

  login(login: Login): Observable<String> {
    return this.http.post<String>(this.url, login, this.httpOptions);
  }
}
