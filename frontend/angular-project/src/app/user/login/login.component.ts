import { Component, OnInit } from '@angular/core';

import { UserService } from '../user.service';

import { Login } from '../../models/Login';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginBody: Login;

  constructor(private userService: UserService) {
    this.loginBody = {
      username: '',
      password: ''
    }
   }

  ngOnInit(): void {
  }

  login() {
    console.log(this.loginBody);
    this.userService.login(this.loginBody).subscribe((result) => {
      console.log(result);
    })
  }

}
