

import {Component, Input, OnInit} from '@angular/core';
import {Patient} from '../model/patient';
import {Adresse} from '../model/adresse';


@Component({
  selector: 'app-inscription-patient',
  templateUrl: './inscription-patient.component.html',
  styleUrls: ['./inscription-patient.component.css']
})
export class InscriptionPatientComponent implements OnInit {



 // constructor(private patientService: PatientService) { }

  @Input('patient')
  private patient: Patient;
  private civilite: string[];
  private domicile: Adresse;


  constructor() {
  }

  ngOnInit() {

    this.civilite = ['Monsieur', 'Madame', 'Mademoiselle'];

    this.patient = new Patient(this.civilite[0], this.patient.password, this.patient.username, this.patient.nom,
      this.patient.prenom, this.patient.dateNaissance, this.patient.mail, this.patient.telephone, this.patient.domicile, );
  }


  public onFormSubmit({value, valid}: { value: Patient, valid: boolean }) {
    this.patient = value;
    console.log(this.patient);

  }
}
