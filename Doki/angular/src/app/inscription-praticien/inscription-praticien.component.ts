import { Component, OnInit } from '@angular/core';
import {Praticien} from '../model/praticien';
import {Specialite} from '../model/specialite';
import {Motif} from '../model/motif';
import {Disponibilite} from '../model/disponibilite';

@Component({
  selector: 'app-inscription-praticien',
  templateUrl: './inscription-praticien.component.html',
  styleUrls: ['./inscription-praticien.component.css']
})
export class InscriptionPraticienComponent implements OnInit {

  private praticien: Praticien;
  private specialites: Specialite [] = [];
  private motifs: Motif [] = [];
  private dispo: Disponibilite [] = [];

  constructor() { }

  ngOnInit() {
  }

}
