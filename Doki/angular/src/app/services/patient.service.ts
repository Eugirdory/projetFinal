import { Injectable } from '@angular/core';


import {Patient} from '../model/patient';

import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private url = 'http://localhost:8080/boot/rest/patient';
  private httpHeaders: HttpHeaders;
  private httpOptions: any;


  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic '   + btoa('moi:toto')

    });
    this.httpOptions = {headers: this.httpHeaders};
  }
  public list(): Observable<any> {
    return this.http.get(this.url, {headers: this.httpHeaders});
  }

  public delete(id: string): Observable<any> {
    return this.http.delete(`${this.url}/${id}`, this.httpOptions);
  }

  public update(patient: Patient): Observable<any> {
    return this.http.put(`${this.url}/${patient.username}`, patient, this.httpOptions);
  }

  public insert(patient: Patient): Observable<any> {
    const p = {
      'mail': patient.mail,
      'username': patient.username,
      'password': patient.password,
      'civilite': patient.civilite,
      'nom': patient.nom,
      'prenom': patient.prenom,
      'telephone': patient.telephone,
      'adresse': patient.domicile,
      'dateNaissance': patient.dateNaissance,

    };
    return this.http.post(`${this.url}`, p, this.httpOptions);
  }
}

