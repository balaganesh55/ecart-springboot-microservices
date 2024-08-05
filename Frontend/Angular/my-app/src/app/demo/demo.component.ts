import { Component } from '@angular/core';

@Component({
  selector: 'app-demo',
  standalone: true,
  imports: [],
  template: `<h4>Testing Demo Component</h4>
  <h3>Sum : {{a+b}}</h3>`,
  styles: [ 'h3 { color: pink }']
})
export class DemoComponent {

  a : number = 100;
  b : number = 200;

}
