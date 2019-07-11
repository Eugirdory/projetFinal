import {Personne} from '../model/personne';
import {AuthenticationService} from '../services/authentication.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  private personne: Personne = new Personne();
  private message = '';


  constructor(private authService: AuthenticationService, private router: Router) {
  }

  ngOnInit() {
  }

  public login() {
    if (this.authService.login(this.personne)) {
      console.log('ok');
      this.router.navigate(['/accueil']);
    } else {
      this.message = 'erreur authentification';
    }

  }
}
