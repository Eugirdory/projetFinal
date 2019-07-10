import {Routes} from '@angular/router';

import {InscriptionPraticienComponent} from './inscription-praticien/inscription-praticien.component';

import {PatientComponent} from './patient/patient.component';
import {InscriptionComponent} from './inscription/inscription.component';
import {PageAcceuilComponent} from './page-acceuil/page-acceuil.component';



export const routes: Routes = [
  {path: 'inscription', component: InscriptionComponent},

  {path: 'accueil', component : PageAcceuilComponent},

  {path: 'patient', component: PatientComponent},
  {path: 'inscriptionPraticien', component: InscriptionPraticienComponent},
];

