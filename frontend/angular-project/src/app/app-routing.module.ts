import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SignupComponent } from './user/signup/signup.component';
import { LoginComponent } from './user/login/login.component';
import { CompanyListBySectorComponent } from './sector/company-list-by-sector/company-list-by-sector.component';
import { IpoDetailsComponent } from './ipo/ipo-details/ipo-details.component';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';

const routes: Routes = [
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'companiesBySector', component: CompanyListBySectorComponent},
  {path: 'ipos', component: IpoDetailsComponent},
  {path: 'company/:id', component: CompanyDetailsComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
