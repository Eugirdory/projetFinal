import {Personne} from '../model/personne';
import {AuthenticationService} from '../services/authentication.service';
import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  private personne: Personne = new Personne();
  private message = '';


  constructor(private authService: AuthenticationService) {
  }

  ngOnInit() {
  }

  public login() {
    if (this.authService.login(this.personne)) {
      console.log('ok');
    } else {
      this.message = 'erreur authentification';
    }

  }
}
