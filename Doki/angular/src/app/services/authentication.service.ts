import {Injectable} from '@angular/core';
import {Personne} from '../model/personne';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private token: Personne= null;

  constructor(private router: Router) {
    console.log('construction Authentific');
  }

  canActivate(): boolean {
    if (this.token !== null) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

  public login(personne: Personne) {
    if (personne.username === 'toto' && personne.password === 'toto') {
      this.token = personne;
      return true;
    } else {
    }
  }
}

