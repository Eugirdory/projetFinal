import {Component, Input, OnInit} from '@angular/core';
import {Patient} from '../model/patient';

@Component({
  selector: 'app-inscription-patient',
  templateUrl: './inscription-patient.component.html',
  styleUrls: ['./inscription-patient.component.css']
})
export class InscriptionPatientComponent implements OnInit {

  @Input()
  private patient: Patient;
  private civilite: string[];

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
    console.log('valid: ' + valid);
  }

}
