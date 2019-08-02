import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Employee} from "./employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8081/';
  employee: Employee;

  constructor(private http: HttpClient) { }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'employees');
  }

  createEmployee(employee: object): Observable<object> {
    return this.http.post(`${this.baseUrl}` + 'create', employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + 'delete/' + id);
  }

  updateEmployee(employee: object): Observable<any> {
    return this.http.put(this.baseUrl + 'update' , employee);
  }

  login(username: string, password: string): Observable<any> {
    let loginObject = {
      'username': username,
      'password': password
    };
    return this.http.post(this.baseUrl + 'login', loginObject);
  }
}
