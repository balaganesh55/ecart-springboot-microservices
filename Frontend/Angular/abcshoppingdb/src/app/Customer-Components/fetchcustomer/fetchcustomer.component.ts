import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-fetchcustomer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './fetchcustomer.component.html',
  styleUrl: './fetchcustomer.component.css'
})
export class FetchcustomerComponent {
  
  customer: any;
  constructor(private service: CustomerService, private route: ActivatedRoute) {}
  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      let customerId: number = Number(params.get('id'));
      this.getCustomer(customerId)
    });
  }
  getCustomer(id: number) {
    this.service.getCustomerById(id).subscribe((res) => (this.customer = res));
  }
}
