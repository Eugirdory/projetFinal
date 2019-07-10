import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Personne} from '../model/personne';
import {Patient} from '../model/patient';
import {Praticien} from '../model/praticien';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  @Input('personne')
  private p: Personne = new Personne();

  @Output()
  private showPraticien = new EventEmitter<boolean>();

  private type = false;

  constructor() {
  }

  ngOnInit() {
    if (this.type = false) {
      this.p = new Patient();
    } else {this.p= new Praticien()}

  }

}
