import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-directives',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './directives.component.html',
  styleUrl: './directives.component.css'
})
export class DirectivesComponent {

  isLoggedIn:boolean = false;

  title: string = "Courses";

  courses:string[] = ["java", "sql",'hibernate', 'git','spring'];

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

}

interface Product {
  productId: number,
  productName : string,
  productPrice : number,
  category:string
}