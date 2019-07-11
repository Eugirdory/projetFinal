import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionPatientComponent } from './inscription-patient.component';

describe('InscriptionPatientComponent', () => {
  let component: InscriptionPatientComponent;
  let fixture: ComponentFixture<InscriptionPatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptionPatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
