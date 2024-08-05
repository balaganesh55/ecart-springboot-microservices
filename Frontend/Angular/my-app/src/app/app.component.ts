import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestComponent } from './test/test.component';
import { DemoComponent } from './demo/demo.component';
import { BindingdemoComponent } from './bindingdemo/bindingdemo.component';
import { EventbindingComponent } from './eventbinding/eventbinding.component';
import { TwowaybidingComponent } from './twowaybiding/twowaybiding.component';
import { DirectivesComponent } from './directives/directives.component';
import { CommonModule } from '@angular/common';
import { ParentComponent } from './parent/parent.component';
import { ItemMainComponent } from './item-main/item-main.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { ContactformComponent } from './contactform/contactform.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    TestComponent,
    DemoComponent,
    BindingdemoComponent,
    EventbindingComponent,
    TwowaybidingComponent,
    DirectivesComponent,
    ParentComponent,
    ItemMainComponent,
    RegistrationFormComponent,
    ContactformComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ECOM-APP';
}
