import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../services/product.service';
@Component({
  selector: 'app-addproduct',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './addproduct.component.html',
  styleUrl: './addproduct.component.css',
})
export class AddproductComponent {
  constructor(private service: ProductService) {}
  addProduct(product: any) {
    return this.service
      .saveProduct(product.value)
      .subscribe(() => alert('Product Saved successfully'));
  }
}
