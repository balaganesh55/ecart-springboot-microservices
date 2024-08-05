import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {

form=new FormGroup({
  FirstName:new FormControl("",Validators.required),
  LastName:new FormControl("",Validators.required),
  Email:new FormControl(""),
  Mobile:new FormControl(""),
  Gender:new FormControl(""),
})
get FirstName(){
  return this.form.get('FirstName')
}
get LastName(){
  return this.form.get('LastName')
}
get Email(){
  return this.form.get('Email')
}
get Mobile(){
  return this.form.get('Mobile')
}
get Gender(){
  return this.form.get('Gender')
}


onSave(){
  console.log(this.form.value)
}
}
