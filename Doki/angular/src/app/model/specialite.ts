import {Praticien} from './praticien';

export class Specialite{

  private _libelle: string;
  private _praticiens: Array<Praticien> = new Array<Praticien>();


  constructor(libelle: string, praticiens: Array<Praticien>) {
    this._libelle = libelle;
    this._praticiens = praticiens;
  }


  get libelle(): string {
    return this._libelle;
  }

  set libelle(value: string) {
    this._libelle = value;
  }

  get praticiens(): Array<Praticien> {
    return this._praticiens;
  }

  set praticiens(value: Array<Praticien>) {
    this._praticiens = value;
  }
}
