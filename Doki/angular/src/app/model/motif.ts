export class Motif {

  private _libelle: string;
  private _duree: number;


  constructor(libelle: string, duree: number) {
    this._libelle = libelle;
    this._duree = duree;
  }

  get libelle(): string {
    return this._libelle;
  }

  set libelle(value: string) {
    this._libelle = value;
  }

  get duree(): number {
    return this._duree;
  }

  set duree(value: number) {
    this._duree = value;
  }
}
