
import {Component, EventEmitter, Input, OnInit} from '@angular/core';
import {Patient} from '../model/patient';
import {Adresse} from '../model/adresse';
import {Router} from '@angular/router';
import {PatientService} from '../services/patient.service';



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

  private newPatient = new EventEmitter();
  constructor(private patientService: PatientService, private router: Router) {
  }

  ngOnInit() {
  this.civilite = ['Monsieur', 'Madame', 'Mademoiselle'];
  this.domicile = new Adresse(null, '', '' , '', '');
  this.patient = new Patient('', '', '',  this.civilite[0], '', '', '', this.domicile,
  null);
  }

  public onFormSubmit({value}: { value: Patient, valid: boolean }) {
    this.patient = value;
    this.patientService.insert(this.patient).subscribe(res => {
      this.newPatient.emit();
      this.router.navigate(['/acceuil']);
  });
  }
}
