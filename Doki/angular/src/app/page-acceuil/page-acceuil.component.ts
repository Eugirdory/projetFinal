import { Component, OnInit } from '@angular/core';
import {PraticienService} from '../services/praticien-service';
import {Praticien} from '../model/praticien';

@Component({
  selector: 'app-page-acceuil',
  templateUrl: './page-acceuil.component.html',
  styleUrls: ['./page-acceuil.component.css']
})
export class PageAcceuilComponent implements OnInit {
  
  private praticiens: Praticien[] = [];
  private mot = '';

  constructor(private praticienService: PraticienService) { }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.praticienService.list().subscribe(res => {
      console.log('list');
      this.praticiens = res;
    });
  }

  public searchNom() {
    console.log('je cherche');
    this.praticienService.rechNom(this.mot).subscribe(res => {
      this.praticiens = res;
    });

  }



}
