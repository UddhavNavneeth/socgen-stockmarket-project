import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { StockExchangeService } from '../stock-exchange.service';

import { StockExchange } from 'src/app/models/StockExchange';

@Component({
  selector: 'app-add-stock-exchange',
  templateUrl: './add-stock-exchange.component.html',
  styleUrls: ['./add-stock-exchange.component.css']
})
export class AddStockExchangeComponent implements OnInit {

  public stockExchange: StockExchange;
  public message: string;

  constructor(private stockExchangeService: StockExchangeService,
    private route: Router) {
    this.stockExchange = {
      name: '',
      brief: '',
      remarks: '',
      address: {
        street1: '',
        street2: '',
        city: '',
        state: '',
        country: '',
        zipcode: ''
      }
    }

    this.message = '';
   }

  ngOnInit(): void {
  }

  addStockExchange() {
    this.stockExchangeService.addStockExchange(this.stockExchange).subscribe(() => {
      this.route.navigate(['/admin/stockExchangeList']);
    }, (e) => {
      this.message =  e.error.message;
      console.log(e);
    })
  }

}
