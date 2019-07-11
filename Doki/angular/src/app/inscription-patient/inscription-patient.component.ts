import {Component, Input, OnInit} from '@angular/core';
import {Patient} from '../model/patient';
import {Adresse} from '../model/adresse';

@Component({
  selector: 'app-inscription-patient',
  templateUrl: './inscription-patient.component.html',
  styleUrls: ['./inscription-patient.component.css']
})
export class InscriptionPatientComponent implements OnInit {

  @Input('patient')
  private patient: Patient;
  private civilite: string[];
  private domicile: Adresse;

  constructor() {
  }

  ngOnInit() {
  this.civilite = ['Monsieur', 'Madame', 'Mademoiselle'];
  this.domicile = new Adresse(null, '', '' , '', '');
 // this.patient = new Patient('', '', '', '', '', '', '', this.domicile, '');
  }
/*
  public onFormSubmit({value, valid}: { value: Patient, valid: boolean }) {
    this.patient = value;
    console.log(this.patient);
    console.log('valid: ' + valid);
  } */

}
