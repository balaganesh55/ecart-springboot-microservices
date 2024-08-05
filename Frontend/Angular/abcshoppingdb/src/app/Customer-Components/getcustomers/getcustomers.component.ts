import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../model/customer';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-getcustomers',
  standalone: true,
  imports: [CommonModule,RouterLink],
  templateUrl: './getcustomers.component.html',
  styleUrl: './getcustomers.component.css'
})
export class GetcustomersComponent {
constructor(private service:CustomerService){}
customers:any=[]
ngOnInit(){
  this.fetchallcustomers()
}
fetchallcustomers(){
  this.service.getAllCustomers().subscribe(data=>this.customers=data)
}
}
