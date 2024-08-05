import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpclient:HttpClient) { }
  url: string = 'http://localhost:8081/customer/';
  headers = new HttpHeaders();
  getAllCustomers(){
    return this.httpclient.get(this.url);
  }
  saveCustomer(customer: Customer): Observable<any> {
    this.headers.set('content-type', 'application/json');
    return this.httpclient.post(this.url, customer, { headers: this.headers });
  }
  getCustomerById(id: number): Observable<Customer> {
    return this.httpclient.get<Customer>(this.url + id);
  }
  updateCustomerById(customer: Customer): Observable<any> {
    this.headers.set('content-type', 'application/json');
    return this.httpclient.put(this.url, customer, { headers: this.headers });
  }
  deleteCustomerById(id: number): Observable<Customer> {
    return this.httpclient.delete<Customer>(this.url + id);
  }
}
