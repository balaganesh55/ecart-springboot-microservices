import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private httpclient: HttpClient) {}

  url: string = 'http://localhost:8081/product/';
  headers = new HttpHeaders();
  getAllProducts(): Observable<Product> {
    return this.httpclient.get<Product>(this.url);
  }
  saveProduct(product: Product): Observable<any> {
    this.headers.set('content-type', 'application/json');
    return this.httpclient.post(this.url, product, { headers: this.headers });
  }
  getProductById(id: number): Observable<Product> {
    return this.httpclient.get<Product>(this.url + id);
  }
  updateProductById(product: Product): Observable<any> {
    this.headers.set('content-type', 'application/json');
    return this.httpclient.put(this.url, product, { headers: this.headers });
  }
  deleteProductById(id: number): Observable<Product> {
    return this.httpclient.delete<Product>(this.url + id);
  }
}
