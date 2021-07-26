import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { UserService } from '../user.service';

import { Login } from '../../models/Login';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginBody: Login;
  message: string;

  constructor(private userService: UserService) {
    this.loginBody = {
      username: '',
      password: ''
    };

    this.message = '';
   }

  ngOnInit(): void {
  }

  login() {
    this.userService.login(this.loginBody).subscribe((result) => {
      
    }, (e) => {
      this.message = e.error.message;
    })
  }

}
