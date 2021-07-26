import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

import { UserService } from '../user.service';

import { User } from '../../models/User';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  public user: User
  public message: string;

  constructor(private userSerice: UserService,
    private activeRoute: ActivatedRoute,
    private route: Router) {
    this.user = {
      username: '',
      password: '',
      userType: '',
      email: '',
      mobile: '',
      isdCode: '',
      confirmed: false
    }

    this.message = '';
   }

  ngOnInit(): void {
    this.getUser();
  }

  getUser() {
    const userId: number = Number(this.activeRoute.snapshot.paramMap.get('id'));
    this.userSerice.getUser(userId).subscribe((user) => {
      this.user = user;
    }, (e) => {
      console.log(e);
    })
  }

  updateUser() {
    this.userSerice.updateUser(this.user).subscribe((user) => {
      this.user = user;
    }, (e) => {
      console.log(e);
      this.message = e.error.message;
    })
  }

  deleteUser() {
    const userId: number = Number(this.activeRoute.snapshot.paramMap.get('id'));
    this.userSerice.deleteUser(userId).subscribe(() => {
      this.route.navigate(['/signup']);
    }, (e) => {
      console.log(e);
      this.message = e.error.message;
    })
  }

}
