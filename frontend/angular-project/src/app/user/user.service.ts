import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { User } from '../models/User';
import { Login } from '../models/Login';
import { ServerMessage } from 'src/app/models/ServerMessage';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = "http://localhost:8086/user/";
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(private http: HttpClient) { }

  signUp(user: User): Observable<User> {
    return this.http.post<User>(`${this.url}signup`, user, this.httpOptions);
  }

  login(login: Login): Observable<ServerMessage> {
    return this.http.post<ServerMessage>(`${this.url}login`, login, this.httpOptions);
  }

  getUser(userId: number): Observable<User> {
    return this.http.get<User>(`${this.url}getUserById?userId=${userId}`, this.httpOptions);
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.url}`, user, this.httpOptions);
  }

  deleteUser(userId: number) {
    return this.http.delete<void>(`${this.url}delete?userId=${userId}`, this.httpOptions);
  }
}
