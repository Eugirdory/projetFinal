import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Personne} from '../model/personne';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  @Output()
  private showLogout = new EventEmitter<boolean>();

  private log = false;
  constructor() { }

  ngOnInit() {

  }
}
