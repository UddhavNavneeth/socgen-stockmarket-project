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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    CompanyListBySectorComponent,
    IpoDetailsComponent,
    CompanyDetailsComponent,
    UserDetailsComponent,
    CompanySearchComponent
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
