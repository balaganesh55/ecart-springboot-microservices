import { Component } from '@angular/core';

@Component({
  selector: 'app-eventbinding',
  standalone: true,
  imports: [],
  templateUrl: './eventbinding.component.html',
  styleUrl: './eventbinding.component.css'
})
export class EventbindingComponent {

    msg : string = "sample message";

    count:number = 0;

    sayHello() {
      // alert("Hello ");
      this.count++;
    }
}
