import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-contactform',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './contactform.component.html',
  styleUrl: './contactform.component.css'
})
export class ContactformComponent {

  profileForm = new FormGroup({
    firstName : new FormControl('',[Validators.required,Validators.minLength(5)]),
    lastName : new FormControl('',Validators.required),
    email : new FormControl(''),
    gender : new FormControl('')
  }
  );

  createProfile() {
    if (this.profileForm.valid) {
      console.log('Form submitted:', this.profileForm.value);
    }   
  }

  get firstName() {
    return this.profileForm.get('firstName');
  }

  get lastName() {
    return this.profileForm.get('lastName');
  }
}
