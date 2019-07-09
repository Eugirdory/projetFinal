import {Patient} from './patient';
import {Praticien} from './praticien';
import {Motif} from './motif';

export class RendezVous {

  private _creneau: Date;
  private _motif: Motif;
  private _patient: Patient;
  private _praticien: Praticien;


  constructor(creneau?: Date, motif?: Motif, patient?: Patient, praticien?: Praticien) {
    this._creneau = creneau;
    this._motif = motif;
    this._patient = patient;
    this._praticien = praticien;
  }


  get motif(): Motif {
    return this._motif;
  }

  set motif(value: Motif) {
    this._motif = value;
  }

  get creneau(): Date {
    return this._creneau;
  }

  set creneau(value: Date) {
    this._creneau = value;
  }

  get patient(): Patient {
    return this._patient;
  }

  set patient(value: Patient) {
    this._patient = value;
  }

  get praticien(): Praticien {
    return this._praticien;
  }

  set praticien(value: Praticien) {
    this._praticien = value;
  }
}
