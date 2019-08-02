import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public username: string;
  public password: string;
  public errorMessage: string;

  constructor(private loginService: EmployeeService) { }

  ngOnInit() {
  }

  public login() {
    this.loginService.login(this.username, this.password)
      .subscribe();
  }
}
