import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StartRequestComponent } from './start-request.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

describe('StartRequestComponent', () => {
  let component: StartRequestComponent;
  let fixture: ComponentFixture<StartRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartRequestComponent ],
      imports: [ReactiveFormsModule, FormsModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StartRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
