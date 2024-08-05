import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-item-output',
  standalone: true,
  imports: [],
  templateUrl: './item-output.component.html',
  styleUrl: './item-output.component.css'
})
export class ItemOutputComponent {

  @Output() newItemEvent = new EventEmitter<string>();

  addNewCourse(value:string) {
    this.newItemEvent.emit(value);
  }

}
