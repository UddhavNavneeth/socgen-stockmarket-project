import { Component, OnInit, Input } from '@angular/core';

import { UserService } from '../user.service';

import { User } from '../../models/User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user: User;
  public message: string;

  constructor(private userService: UserService) { 
    this.user = {
      username: "",
      password: "",
      userType: "",
      email: "",
      mobile: "",
      isdCode: "",
      confirmed: false
    };

    this.message = '';
   }

  ngOnInit(): void {
  }

  signup(): void {
    this.user.userType = "user";
    this.user.isdCode = "+91"
    this.userService.signUp(this.user).subscribe((user) => {

    }, (e) => {
      console.log(e);
    });

  }

}
