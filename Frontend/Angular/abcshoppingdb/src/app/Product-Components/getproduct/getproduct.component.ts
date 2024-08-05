import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-getproduct',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './getproduct.component.html',
  styleUrl: './getproduct.component.css',
})
export class GetproductComponent {
  product: any;
  constructor(private service: ProductService, private route: ActivatedRoute) {}
  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      let productId: number = Number(params.get('id'));
      this.fetchProductById(productId);
    });
  }
  fetchProductById(id: number) {
    this.service.getProductById(id).subscribe((res) => (this.product = res));
  }
}
