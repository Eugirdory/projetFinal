import {Personne} from './personne';
import {Civilite} from './civilite.enum';
import {Adresse} from './adresse';
import {RendezVous} from './rendez-vous';
export class Patient extends Personne {

  private _dateNaissance: Date;
  private _domicile: Adresse;
  private _rdvs: Array<RendezVous> = new Array<RendezVous>();


  constructor(mail?: string, username?: string, password?: string, civilite?: string, nom?: string, prenom?: string, telephone?: string,
              domicile?: Adresse, dateNaissance?: Date, rdvs?: RendezVous[]) {
    super(mail, username, password, civilite, nom, prenom, telephone);
    this._dateNaissance = dateNaissance;
    this._domicile = domicile;
    this._rdvs = rdvs;
  }


  get dateNaissance(): Date {
    return this._dateNaissance;
  }

  set dateNaissance(value: Date) {
    this._dateNaissance = value;
  }

  get domicile(): Adresse {
    return this._domicile;
  }

  set domicile(value: Adresse) {
    this._domicile = value;
  }

  get rdvs(): RendezVous[] {
    return this._rdvs;
  }

  set rdvs(value: RendezVous[]) {
    this._rdvs = value;
  }
}
