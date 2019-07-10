import { Component, OnInit } from '@angular/core';
import {Praticien} from '../model/praticien';
import {Specialite} from '../model/specialite';
import {Motif} from '../model/motif';
import {Disponibilite} from '../model/disponibilite';
import {Jour} from '../model/jour.enum';

@Component({
  selector: 'app-inscription-praticien',
  templateUrl: './inscription-praticien.component.html',
  styleUrls: ['./inscription-praticien.component.css']
})
export class InscriptionPraticienComponent implements OnInit {

  private praticien: Praticien;
  private civilite: string[];
  private specialites: Specialite [] = [];
  private motifs: Motif [] = [];
  private dispo: Disponibilite [] = [];

  constructor() { }

  ngOnInit() {
    this.civilite = ['Monsieur', 'Madame', 'Mademoiselle'];

    this.praticien = new Praticien(this.civilite[0], '', '', '', '', '', '',
      {}, [], [], []);
  }

}
