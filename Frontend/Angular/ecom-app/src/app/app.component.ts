import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CalculatorService } from './calculator.service';
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,CommonModule,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ecom-app';
  result:number=0;
  private addService=inject(CalculatorService)
  addNumbers(addingnumbers:any){
    console.log(addingnumbers)

    this.result=this.addService.add(addingnumbers.value.num1,addingnumbers.value.num2)
  }
}
