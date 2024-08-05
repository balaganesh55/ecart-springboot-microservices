import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deletecustomer',
  standalone: true,
  imports: [],
  templateUrl: './deletecustomer.component.html',
  styleUrl: './deletecustomer.component.css'
})
export class DeletecustomerComponent {
  constructor(private service: CustomerService, private route: ActivatedRoute) {}
  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      let customerId = Number(params.get('id'));
      this.deleteCustomer(customerId);
    });
  }
  deleteCustomer(id: number) {
    this.service
      .deleteCustomerById(id)
      .subscribe(() => alert('Customer deleted Successfully'));
  }
}
