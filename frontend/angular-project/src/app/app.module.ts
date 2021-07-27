import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';
import { CompanyListBySectorComponent } from './sector/company-list-by-sector/company-list-by-sector.component';
import { IpoDetailsComponent } from './ipo/ipo-details/ipo-details.component';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { CompanySearchComponent } from './company/company-search/company-search.component';
import { UserNavbarComponent } from './user-navbar/user-navbar.component';
import { StockExchangeListComponent } from './stockExchange/stock-exchange-list/stock-exchange-list.component';
import { AdminCompanyListComponent } from './company/admin-company-list/admin-company-list.component';
import { AdminAddCompanyComponent } from './company/admin-add-company/admin-add-company.component';
import { AdminCompanyDetailsComponent } from './company/admin-company-details/admin-company-details.component';
import { AdminIpoListComponent } from './ipo/admin-ipo-list/admin-ipo-list.component';
import { AdminAddIpoComponent } from './ipo/admin-add-ipo/admin-add-ipo.component';
import { AdminIpoDetailsComponent } from './ipo/admin-ipo-details/admin-ipo-details.component';
import { AddStockExchangeComponent } from './stockExchange/add-stock-exchange/add-stock-exchange.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    CompanyListBySectorComponent,
    IpoDetailsComponent,
    CompanyDetailsComponent,
    UserDetailsComponent,
    CompanySearchComponent,
    UserNavbarComponent,
    StockExchangeListComponent,
    AdminCompanyListComponent,
    AdminAddCompanyComponent,
    AdminCompanyDetailsComponent,
    AdminIpoListComponent,
    AdminAddIpoComponent,
    AdminIpoDetailsComponent,
    AddStockExchangeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
