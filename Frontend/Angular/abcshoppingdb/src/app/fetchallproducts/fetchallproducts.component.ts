import { Component, inject } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
// import {FormsModules} from '@angular/forms'
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-fetchallproducts',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './fetchallproducts.component.html',
  styleUrl: './fetchallproducts.component.css',
})
export class FetchallproductsComponent {
  products: any;
  constructor(private productService: ProductService) {}
  ngOnInit() {
    this.getProducts();
  }
  getProducts() {
    return this.productService
      .getAllProducts()
      .subscribe((data) => (this.products = data));
  }
}
