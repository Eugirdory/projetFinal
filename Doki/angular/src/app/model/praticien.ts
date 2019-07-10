import {RendezVous} from './rendez-vous';
import {Motif} from './motif';
import {Specialite} from './specialite';
import {Disponibilite} from './disponibilite';
import {Personne} from './personne';
import {Civilite} from './civilite.enum';
import {Adresse} from './adresse';

export class Praticien extends Personne{

  private _cabinet: Adresse;
  private _specialites: Array<Specialite> = new Array<Specialite>();
  private _dispos: Array<Disponibilite> = new Array<Disponibilite>();
  private _rdvs: Array<RendezVous> = new Array<RendezVous>();
  private _motifs: Array<Motif> = new Array<Motif>();


  constructor(civilite?: string, password?: string, username?: string, nom?: string, prenom?: string, mail?: string, telephone?: string, cabinet?: Adresse, specialites?: Array<Specialite>, dispos?: Array<Disponibilite>, motifs?: Array<Motif>, rdvs?: Array<RendezVous>) {
    super(civilite, password, username, nom, prenom, mail, telephone);
    this._cabinet = cabinet;
    this._specialites = specialites;
    this._dispos = dispos;
    this._rdvs = rdvs;
    this._motifs = motifs;
  }


  get cabinet(): Adresse {
    return this._cabinet;
  }

  set cabinet(value: Adresse) {
    this._cabinet = value;
  }

  get specialites(): Array<Specialite> {
    return this._specialites;
  }

  set specialites(value: Array<Specialite>) {
    this._specialites = value;
  }

  get dispos(): Array<Disponibilite> {
    return this._dispos;
  }

  set dispos(value: Array<Disponibilite>) {
    this._dispos = value;
  }

  get rdvs(): Array<RendezVous> {
    return this._rdvs;
  }

  set rdvs(value: Array<RendezVous>) {
    this._rdvs = value;
  }

  get motifs(): Array<Motif> {
    return this._motifs;
  }

  set motifs(value: Array<Motif>) {
    this._motifs = value;
  }
}
