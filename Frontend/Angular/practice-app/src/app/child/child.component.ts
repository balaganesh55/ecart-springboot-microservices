import { Component, EventEmitter, Input, Output, output } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: true,
  imports: [],
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent {
  //recieve data from parent
@Input() counter:number=0;

 //send data from parent
 @Output() fruit=new EventEmitter<string>()
 addfruitfunction(value:string){
  this.fruit.emit(value);
 }
}
