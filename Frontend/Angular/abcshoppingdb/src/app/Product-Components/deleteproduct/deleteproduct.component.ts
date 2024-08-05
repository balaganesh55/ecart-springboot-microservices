import { Component, Inject } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deleteproduct',
  standalone: true,
  imports: [],
  templateUrl: './deleteproduct.component.html',
  styleUrl: './deleteproduct.component.css',
})
export class DeleteproductComponent {
  constructor(private service: ProductService, private route: ActivatedRoute) {}
  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      let productId = Number(params.get('id'));
      this.deleteProduct(productId);
    });
  }
  deleteProduct(id: number) {
    this.service
      .deleteProductById(id)
      .subscribe(() => alert('Product deleted Successfully'));
  }
}
