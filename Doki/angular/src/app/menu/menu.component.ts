import {Component, Input, OnInit} from '@angular/core';
import {Personne} from '../model/personne';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  @Input('personne')
  private p: Personne = null;

  constructor() { }

  ngOnInit() {
  }



}
