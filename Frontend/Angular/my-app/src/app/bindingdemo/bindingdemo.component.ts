import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-bindingdemo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bindingdemo.component.html',
  styleUrl: './bindingdemo.component.css'
})
export class BindingdemoComponent {
    title: string = 'Biding Demo'
    isDisabled:boolean = true
    imgPath:string = '/assets/images/img1.jpg'
    // color : string = 'pink'
    status : string = 'success'

    styleClass: StyleClass = new StyleClass();

    myCustomer:Customer = {
      customerId : 100,
      customerName : 'raj kumar',
      customerAge : 25
    }

    
}

interface Customer {
  customerId : number,
  customerName : string,
  customerAge : number
}

class StyleClass {
  'color': string= 'blue';
  'font-size.px': number= 20;
  'font-weight': string= 'bold'; 
}
