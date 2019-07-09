import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Employee} from '../employee';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
  }

  save() {
    console.log('employee', this.employee);
    this.employeeService.createEmployee(this.employee).subscribe(data => console.log(data), error => console.log(error));
  }

}
