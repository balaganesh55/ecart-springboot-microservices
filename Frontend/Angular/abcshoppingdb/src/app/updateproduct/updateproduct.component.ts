import { Component } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-updateproduct',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './updateproduct.component.html',
  styleUrl: './updateproduct.component.css',
})
export class UpdateproductComponent {
  productForm: FormGroup;

  constructor(
    private service: ProductService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {
    this.productForm = this.formBuilder.group({
      id: [''],
      productName: [''],
      productPrice: [''],
      mfd: [''],
      category: [''],
    });
  }
  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      let productId: number = Number(params.get('id'));
      this.fetchProductById(productId);
    });
  }
  fetchProductById(id: number) {
    this.service
      .getProductById(id)
      .subscribe((res) => (this.productForm.setValue(res)));
  }
  editProduct() {
     return this.service.updateProductById(this.productForm.value).subscribe(()=>alert("product updated successfully"));
  }
}
