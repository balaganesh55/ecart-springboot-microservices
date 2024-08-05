import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BindingdemoComponent } from './bindingdemo.component';

describe('BindingdemoComponent', () => {
  let component: BindingdemoComponent;
  let fixture: ComponentFixture<BindingdemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BindingdemoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BindingdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
