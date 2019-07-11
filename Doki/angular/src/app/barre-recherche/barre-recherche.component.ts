import {Component, OnInit} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../services/praticien-service';

@Component({
  selector: 'app-barre-recherche',
  templateUrl: './barre-recherche.component.html',
  styleUrls: ['./barre-recherche.component.css']
})
export class BarreRechercheComponent implements OnInit {

  private mot = '';
  praticiens: Praticien[] = [];

  constructor(private praticienService: PraticienService) {
  }

  ngOnInit() {
  }

  public searchNom() {
    this.praticienService.rechNom(this.mot).subscribe(res => {
      this.praticiens = res;
    });

  }

}
