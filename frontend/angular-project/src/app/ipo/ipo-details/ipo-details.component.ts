import { Component, OnInit } from '@angular/core';

import { IpoService } from '../ipo.service';

import { IpoDetail } from 'src/app/models/IpoDetail';

@Component({
  selector: 'app-ipo-details',
  templateUrl: './ipo-details.component.html',
  styleUrls: ['./ipo-details.component.css']
})
export class IpoDetailsComponent implements OnInit {

  public ipoDetailList: IpoDetail[]

  constructor(private ipoService: IpoService) {
    this.ipoDetailList = [];
   }

  ngOnInit(): void {
    this.getIpoDetailList();
  }

  getIpoDetailList() {
    this.ipoService.getIpoDetailList().subscribe((list) => {
      this.ipoDetailList = list;
    }, (e) => {
      console.log(e);
    })
  }

}
