import { Component } from '@angular/core';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [],
  templateUrl: './test.component.html',
  styleUrl: './test.component.css'
})
export class TestComponent {
   title: string = "Test Component";
   firstName : string = "Raj";
   lastName: string = "Kumar";

}
