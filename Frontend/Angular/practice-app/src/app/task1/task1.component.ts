import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task1',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './task1.component.html',
  styleUrl: './task1.component.css'
})
export class Task1Component {
  mobile:string="";





  products :Product[]= [
    { id: 1, name: 'iphone', price: 9990 },
    { id: 2, name: 'samsung', price: 7990 },
    { id: 3, name: 'pixel', price: 5990 },
    { id: 4, name: 'oneplus', price: 7290 },
    { id: 5, name: 'redmi', price: 7490 },
    // { id: 6, name: 'Sony Xperia 5 II', price: 899 },
    // { id: 7, name: 'Huawei P40 Pro', price: 899 },
    // { id: 8, name: 'Nokia 8.3 5G', price: 699 },
    // { id: 9, name: 'Asus ROG Phone 5', price: 999 },
    // { id: 10, name: 'Realme GT', price: 499 }
  ];

  price:number=0;
  addAmount(value:number){
    this.price+=value;
  }
  reduceAmount(value:number){
    this.price-=value;
  }
}
interface Product{
  id:number,
  name:string,
  price:number
}