import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Praticien} from '../model/praticien';
import {PraticienService} from '../services/praticien-service';

@Component({
  selector: '[lignePraticien]',
  templateUrl: './praticien-detail.component.html',
  styleUrls: ['./praticien-detail.component.css']
})
export class PraticienDetailComponent implements OnInit {

  @Input('praticien')
  private p: Praticien;

  @Output()
  private praticienRefresh = new EventEmitter();


  constructor(private praticienService: PraticienService) {

  }

  ngOnInit() {
  }

}
