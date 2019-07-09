import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateEmployeeComponent} from './create-employee/create-employee.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeDetailsComponent} from './employee-details/employee-details.component';
import {PageNotFoundComponent} from './page-not-found.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'employees',
    pathMatch: 'full'
  },
  {
    path: 'employees',
    component: EmployeeListComponent,
  },
  {
    path: 'update',
    component: EmployeeDetailsComponent
  },
  {
    path: 'add',
    component: CreateEmployeeComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [ EmployeeListComponent, EmployeeDetailsComponent, CreateEmployeeComponent, PageNotFoundComponent ];
