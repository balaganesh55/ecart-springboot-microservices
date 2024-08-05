import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registration-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registration-form.component.html',
  styleUrl: './registration-form.component.css'
})
export class RegistrationFormComponent {

  doRegistration(registrationForm:any) {
    console.log(registrationForm.value);
   

    //call api to save this data
   // customerService.addnewCustomer(registrationForm.value);
  }

}
