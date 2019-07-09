import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from '../services/authentication.service';
import {User} from '../login/user';
import {Personne} from '../model/personne';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private authService: AuthenticationService;
  private message = '';
  private personne: Personne = new Personne();
  constructor() { }

  ngOnInit() {
  }

  public login() {
    if (this.authService.login(this.user)) {
      console.log('ok');
    } else {
      this.message = 'erreure authentification';
    }
  }
}
