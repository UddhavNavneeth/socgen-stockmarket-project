import { Component, OnInit } from '@angular/core';

import { StockExchangeService } from '../stock-exchange.service';

import { StockExchange } from 'src/app/models/StockExchange';

@Component({
  selector: 'app-stock-exchange-list',
  templateUrl: './stock-exchange-list.component.html',
  styleUrls: ['./stock-exchange-list.component.css']
})
export class StockExchangeListComponent implements OnInit {

  public stockExchangeList: StockExchange[];

  constructor(private stockExchangeService: StockExchangeService) {
    this.stockExchangeList = [];
   }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.stockExchangeService.getStockExchangeList().subscribe((list) => {
      this.stockExchangeList = list;
    }, (e) => {
      console.log(e);
    })
  }

}
