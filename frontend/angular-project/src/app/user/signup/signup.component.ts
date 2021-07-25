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

   }

  ngOnInit(): void {
  }

  signup(): void {
    this.user.userType = "user";
    this.user.isdCode = "+91"
    console.log(this.user);
    this.userService.signUp(this.user).subscribe();
  }

}
