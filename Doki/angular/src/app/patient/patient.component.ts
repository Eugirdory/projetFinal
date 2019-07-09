import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Patient} from '../model/patient';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  private patient: Patient = new Patient();

  @Output()
  private pushPatient: EventEmitter<Patient> = new EventEmitter<Patient>();

  constructor() {
  }

  ngOnInit() {
  }

  public add() {
    console.log('addPatient');
    this.pushPatient.emit(this.patient);
    this.patient = new Patient();
  }

}
