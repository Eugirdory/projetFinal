
import {Component, EventEmitter, Input, OnInit} from '@angular/core';
import {Patient} from '../model/patient';
import {Praticien} from "../model/praticien";
import {Specialite} from "../model/specialite";
import {Motif} from "../model/motif";
import {Disponibilite} from "../model/disponibilite";
import {Adresse} from "../model/adresse";
import {PraticienService} from "../services/praticien-service";

@Component({
  selector: 'app-inscription-patient',
  templateUrl: './inscription-patient.component.html',
  styleUrls: ['./inscription-patient.component.css']
})
export class InscriptionPatientComponent implements OnInit {

  private patient: Patient;
  private civilite: string[];
  private specialites: Specialite [] = [];
  private motifs: Motif [] = [];
  private dispo: Disponibilite [] = [];
  private newPatient = new EventEmitter();
  private cabinet: Adresse;

 // constructor(private patientService: PatientService) { }

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
