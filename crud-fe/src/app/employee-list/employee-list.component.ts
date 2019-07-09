import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Router} from '@angular/router';
import {Employee} from '../employee';
import {Observable} from 'rxjs';
import {error} from "util";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;
  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    console.log(id);
    this.employeeService.deleteEmployee(id).subscribe(data  => {
        console.log('Delete Request is successful ', data);
        this.reloadData();
      },
      error  => {
        console.log('Error', error);
      }
    );
  }

  edit(employee) {
    this.employeeService.employee = employee;
    this.router.navigateByUrl('/update');
    }

}
