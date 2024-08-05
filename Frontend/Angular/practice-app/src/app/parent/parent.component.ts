import { Component } from '@angular/core';
import { ChildComponent } from '../child/child.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [ChildComponent,CommonModule],
  templateUrl: './parent.component.html',
  styleUrl: './parent.component.css'
})
export class ParentComponent {
  //send data to child component
counter:number=0;
increment(){
  this.counter++;
}

//recieve data from child component
fruits:string[]=["Apple","Banana"];
addFruit(fruit:string){
  this.fruits.push(fruit);
}
}
