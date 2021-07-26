import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SignupComponent } from './user/signup/signup.component';
import { LoginComponent } from './user/login/login.component';
import { CompanyListBySectorComponent } from './sector/company-list-by-sector/company-list-by-sector.component';

const routes: Routes = [
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'companiesBySector', component: CompanyListBySectorComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
