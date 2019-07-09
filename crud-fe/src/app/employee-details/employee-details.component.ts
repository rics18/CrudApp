import {Component, Input, OnInit} from '@angular/core';
import {EmployeeService} from '../employee.service';
import {EmployeeListComponent} from '../employee-list/employee-list.component';
import {Employee} from '../employee';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  employee: Employee;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = this.employeeService.employee;
  }

  updateEmployee(employee) {
    this.employeeService.updateEmployee(employee).subscribe(data  => {
        console.log('Put Request is successful ', data);
      },
      error  => {
        console.log('Error', error);
      }
    );

  }

}
