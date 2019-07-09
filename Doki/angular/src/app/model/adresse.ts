export class Adresse {

  private _numero: number;
  private _rue: string;
  private _cp: string;
  private _ville: string;
  private _code: string;


  constructor(numero?: number, rue?: string, cp?: string, ville?: string, code?: string) {
    this._numero = numero;
    this._rue = rue;
    this._cp = cp;
    this._ville = ville;
    this._code = code;
  }


  get numero(): number {
    return this._numero;
  }

  set numero(value: number) {
    this._numero = value;
  }

  get rue(): string {
    return this._rue;
  }

  set rue(value: string) {
    this._rue = value;
  }

  get cp(): string {
    return this._cp;
  }

  set cp(value: string) {
    this._cp = value;
  }

  get ville(): string {
    return this._ville;
  }

  set ville(value: string) {
    this._ville = value;
  }

  get code(): string {
    return this._code;
  }

  set code(value: string) {
    this._code = value;
  }
}
