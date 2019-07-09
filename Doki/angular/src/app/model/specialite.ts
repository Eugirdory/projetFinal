import {Praticien} from './praticien';

export class Specialite{

  private _intitule: string;
  private _praticiens: Array<Praticien> = new Array<Praticien>();


  constructor(intitule: string, praticiens: Array<Praticien>) {
    this._intitule = intitule;
    this._praticiens = praticiens;
  }


  get intitule(): string {
    return this._intitule;
  }

  set intitule(value: string) {
    this._intitule = value;
  }

  get praticiens(): Array<Praticien> {
    return this._praticiens;
  }

  set praticiens(value: Array<Praticien>) {
    this._praticiens = value;
  }
}
