import {Civilite} from './civilite.enum';

export class Personne {

  private _civilite: Civilite;
  private _nom: string;
  private _prenom: string;
  private _mail: string;
  private _telephone: string;


  constructor(civilite?: Civilite, nom?: string, prenom?: string, mail?: string, telephone?: string) {
    this._civilite = civilite;
    this._nom = nom;
    this._prenom = prenom;
    this._mail = mail;
    this._telephone = telephone;
  }


  get civilite(): Civilite {
    return this._civilite;
  }

  set civilite(value: Civilite) {
    this._civilite = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get mail(): string {
    return this._mail;
  }

  set mail(value: string) {
    this._mail = value;
  }

  get telephone(): string {
    return this._telephone;
  }

  set telephone(value: string) {
    this._telephone = value;
  }
}
