import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SignupComponent } from './user/signup/signup.component';
import { LoginComponent } from './user/login/login.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { CompanyListBySectorComponent } from './sector/company-list-by-sector/company-list-by-sector.component';
import { IpoDetailsComponent } from './ipo/ipo-details/ipo-details.component';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';
import { CompanySearchComponent } from './company/company-search/company-search.component';

const routes: Routes = [
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user/details/:id', component: UserDetailsComponent},
  {path: 'companiesBySector', component: CompanyListBySectorComponent},
  {path: 'company/:id', component: CompanyDetailsComponent},
  {path: 'matchingCompanies', component: CompanySearchComponent},
  {path: 'ipos', component: IpoDetailsComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
