import { Component } from '@angular/core';
import { ItemOutputComponent } from '../item-output/item-output.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-item-main',
  standalone: true,
  imports: [ItemOutputComponent, CommonModule],
  templateUrl: './item-main.component.html',
  styleUrl: './item-main.component.css'
})
export class ItemMainComponent {

  courses:string[] = ['java', 'c++', 'sql', 'git'];

  addCourse(newCourse:string) {
    this.courses.push(newCourse);
  }
}
