import {Component, EventEmitter, Input, OnInit} from '@angular/core';
import {Praticien} from '../model/praticien';
import {Specialite} from '../model/specialite';
import {Motif} from '../model/motif';
import {Disponibilite} from '../model/disponibilite';
import {PraticienService} from '../services/praticien-service';
import {Adresse} from '../model/adresse';
@Component({
  selector: 'app-inscription-praticien',
  templateUrl: './inscription-praticien.component.html',
  styleUrls: ['./inscription-praticien.component.css']
})
export class InscriptionPraticienComponent implements OnInit {
  @Input('praticien')
  private praticien: Praticien;
  private civilite: string[];
  private specialites: Specialite [] = [];
  private motifs: Motif [] = [];
  private dispo: Disponibilite [] = [];
  private newPraticien = new EventEmitter();
  private cabinet: Adresse;
  constructor(private praticienService: PraticienService) { }
  ngOnInit() {
    this.civilite = ['Monsieur', 'Madame', 'Mademoiselle'];
    this.cabinet = new Adresse(null, '', '' , '', '');
    this.praticien = new Praticien(
      '', '', '', '', '', '', '', this.cabinet, [], []);
  }
  public onFormSubmit({ value }: { value: Praticien, valid: boolean }) {
    this.praticien = value;
    this.praticienService.insert(this.praticien).subscribe(res => {
      this.newPraticien.emit();
    });
  }
}
