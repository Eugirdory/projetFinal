import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Praticien} from '../model/praticien';

@Injectable({providedIn: 'root'})
export class PraticienService {
  private url = 'http://localhost:8080/boot/rest/praticien';
  private httpHeaders: HttpHeaders;
  private httpOptions: any;

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'No'  // + btoa('moi:toto')
    });
    this.httpOptions = {headers: this.httpHeaders};
  }

  public list(): Observable<any> {
    return this.http.get(this.url, {headers: this.httpHeaders});
  }

  public rechNom(rech: string): Observable<any>{
    return this.http.get(`${this.url}/rnom/` + rech, this.httpOptions);
  }

  public delete(id: string): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, this.httpOptions);
  }

  public update(praticien: Praticien): Observable<any> {
    return this.http.put(`${this.url}/${praticien.username}`, praticien, this.httpOptions);
  }

  public insert(praticien: Praticien): Observable<any> {
    const p = {
      'mail': praticien.mail,
      'username': praticien.username,
      'password': praticien.password,
      'civilite': praticien.civilite,
      'nom': praticien.nom,
      'prenom': praticien.prenom,
      'telephone': praticien.telephone,
      'adresse': praticien.cabinet,
      'specialite': praticien.specialites,
      'motif': praticien.motifs,
    };
    return this.http.post(`${this.url}`, p, this.httpOptions);
  }
}
