import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwowaybidingComponent } from './twowaybiding.component';

describe('TwowaybidingComponent', () => {
  let component: TwowaybidingComponent;
  let fixture: ComponentFixture<TwowaybidingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TwowaybidingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TwowaybidingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
