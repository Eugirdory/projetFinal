import { Component, OnInit } from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../services/praticien-service';

@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrls: ['./praticien.component.css']
})
export class PraticienComponent implements OnInit {

  private praticiens: Praticien[] = [];
  private mot = '';
  constructor(private praticienService: PraticienService) {
  }

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
