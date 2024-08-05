import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-updatecustomer',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './updatecustomer.component.html',
  styleUrl: './updatecustomer.component.css',
})
export class UpdatecustomerComponent {
  customerForm: FormGroup;

  constructor(
    private service: CustomerService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {
    this.customerForm = this.formBuilder.group({
      id: [''],
      customerName: [''],
      mobile: [''],
      dob: [''],
      email: [''],
      city: [''],
    });
  }
  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      let customerId: number = Number(params.get('id'));
      this.fetchCustomerById(customerId);
    });
  }
  fetchCustomerById(id: number) {
    this.service
      .getCustomerById(id)
      .subscribe((res) => this.customerForm.setValue(res));
  }
  editCustomer() {
    return this.service.updateCustomerById(this.customerForm.value).subscribe({
      next: () => alert('customer updated successfully'),
    });
  }
}
