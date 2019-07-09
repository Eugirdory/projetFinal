import {Adresse} from './adresse';
import {Jour} from './jour.enum';

export class Disponibilite {
  get jour(): Jour {
    return this._jour;
  }

  set jour(value: Jour) {
    this._jour = value;
  }

  get heureD(): Date {
    return this._heureD;
  }

  set heureD(value: Date) {
    this._heureD = value;
  }

  get heureF(): Date {
    return this._heureF;
  }

  set heureF(value: Date) {
    this._heureF = value;
  }

  get cabinet(): Adresse {
    return this._cabinet;
  }

  set cabinet(value: Adresse) {
    this._cabinet = value;
  }

  private _jour: Jour;
  private _heureD: Date;
  private _heureF: Date;
  private _cabinet: Adresse;


  constructor(jour: Jour, heureD: Date, heureF: Date, cabinet: Adresse) {
    this._jour = jour;
    this._heureD = heureD;
    this._heureF = heureF;
    this._cabinet = cabinet;

  }

}
