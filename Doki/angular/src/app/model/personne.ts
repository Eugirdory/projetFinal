import {Civilite} from './civilite.enum';

export class Personne {

  private _civilite: string;
  private _password: string;
  private _username: string;
  private _nom: string;
  private _prenom: string;
  private _mail: string;
  private _telephone: string;


  constructor(mail?: string, username?: string, password?: string, civilite?: string,   nom?: string, prenom?: string,  telephone?: string) {
    this._civilite = civilite;
    this._password = password;
    this._username = username;
    this._nom = nom;
    this._prenom = prenom;
    this._mail = mail;
    this._telephone = telephone;
  }

  get civilite(): string {
    return this._civilite;
  }

  set civilite(value: string) {
    this._civilite = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
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
