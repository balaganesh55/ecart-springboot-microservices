import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-demo',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './demo.component.html',
  styleUrl: './demo.component.css'
})
export class DemoComponent {
name:string="Ganesh"
color:string='red'
imgpath:string='/assets/images/img.jpg'
button(){
  alert("say hello");
}
username:string="ganesh";
  mycustomer:Customer={
      customername:"ganesh",
  customerid:9553897931
  }
obj:string[]=["sql","mongodb","postgre","mysql"]
products:Product[] = [
  {
    productId:10,
    productName:'Iphonex',
    productPrice: 85000,
    category: 'mobile'
  },
  {
    productId:20,
    productName:'Iphoney',
    productPrice: 55000,
    category: 'mobile'
  },
  {
    productId:30,
    productName:'DellXP',
    productPrice: 125000,
    category: 'laptop'
  }
]
styleClass: StyleClass=new StyleClass();
 constructor() { } 
 isLogged:boolean=true;
 status:string="failure";
}
interface Customer{
  customername:string,
  customerid:number
}
interface Product{
  productId:number,
  productName:string,
  productPrice: number,
  category: string
}
class StyleClass {
  'padding': string='10px';
 } 