import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-twowaybiding',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './twowaybiding.component.html',
  styleUrl: './twowaybiding.component.css'
})
export class TwowaybidingComponent {

  username: string = "Rohit Sharma";


}
