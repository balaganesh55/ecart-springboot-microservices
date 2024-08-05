import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-addcustomer',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './addcustomer.component.html',
  styleUrl: './addcustomer.component.css'
})
export class AddcustomerComponent {
  constructor(private service: CustomerService) {}
  addCustomer(customer: any) {
    return this.service
      .saveCustomer(customer.value)
      .subscribe(() => alert('Customer Saved successfully'));
  }
}
